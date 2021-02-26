package io.github.one2story.petclinic.services;

import io.github.one2story.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String name);

}
