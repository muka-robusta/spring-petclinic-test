package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepo extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
