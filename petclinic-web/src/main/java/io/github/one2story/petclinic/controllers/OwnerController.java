package io.github.one2story.petclinic.controllers;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final static String VIEWS_OWNER_CU_FORM = "owners/createOrUpdateOwnerForm";

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/find"})
    public String findOwner(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // By filling empty field gets all owners
        if (owner.getLastName() == null)
            owner.setLastName("");

        String findQuery = "%" + owner.getLastName() + "%";
        final List<Owner> ownersByLastNameList = ownerService.findAllByLastNameLike(findQuery);

        if (ownersByLastNameList.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }

        if (ownersByLastNameList.size() == 1) {
            owner = ownersByLastNameList.get(0);
            return "redirect:/owners/" + owner.getId();
        }

        model.addAttribute("selections", ownersByLastNameList);
        return "owners/ownersList";

    }

    @GetMapping("/new")
    public String initCreatingForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CU_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors())
            return VIEWS_OWNER_CU_FORM;

        Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

    @GetMapping("/{ownerId}")
    public ModelAndView getOwnerInfo(@PathVariable("ownerId") Long ownerId) {
        final ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping("{ownersId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownersId") Long ownerId, Model model) {
        final Owner ownerById = ownerService.findById(ownerId);
        model.addAttribute(ownerById);
        return VIEWS_OWNER_CU_FORM;
    }

    @PostMapping("{ownerId}/edit")
    public String processUpdateOwner(@Valid Owner owner,
                                     BindingResult bindingResult,
                                     @PathVariable("ownerId") Long ownerId) {
        if (bindingResult.hasErrors())
            return VIEWS_OWNER_CU_FORM;

        owner.setId(ownerId);
        final Owner savedOwner = ownerService.save(owner);
        return "redirect:/owners/" + savedOwner.getId();
    }

}
