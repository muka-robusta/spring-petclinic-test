package io.github.one2story.petclinic.services.map;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.model.Pet;
import io.github.one2story.petclinic.services.OwnerService;
import io.github.one2story.petclinic.services.PetService;
import io.github.one2story.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object.getPets() == null)
            return null;

        object.getPets().forEach(pet -> {
            if (pet.getPetType() == null)
                throw new RuntimeException("Pet type cant be null");

            if (pet.getPetType().getId() == null)
                pet.setPetType(petTypeService.save(pet.getPetType()));

            if (pet.getId() == null)
                pet.setId(petService.save(pet).getId());
        });


        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Owner> findAllByLastNameLike(String name) {
        // TODO: implement this
        return null;
    }
}
