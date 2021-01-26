package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepo extends CrudRepository<Pet, Long> {

}
