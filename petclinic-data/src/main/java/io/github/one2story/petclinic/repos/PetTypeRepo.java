package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepo extends CrudRepository<PetType, Long> {

}
