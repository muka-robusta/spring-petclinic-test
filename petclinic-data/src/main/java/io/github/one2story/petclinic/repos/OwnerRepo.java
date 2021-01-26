package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepo extends CrudRepository<Owner, Long> {

}
