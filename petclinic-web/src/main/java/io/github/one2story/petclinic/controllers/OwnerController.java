package io.github.one2story.petclinic.controllers;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

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

        final List<Owner> ownersByLastNameList = ownerService.findAllByLastNameLike(owner.getLastName());

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


    @GetMapping("/{ownerId}")
    public ModelAndView getOwnerInfo(@PathVariable("ownerId") Long ownerId) {
        final ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

}
