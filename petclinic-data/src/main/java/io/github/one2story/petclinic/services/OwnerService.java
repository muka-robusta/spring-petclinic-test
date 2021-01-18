package io.github.one2story.petclinic.services;

import io.github.one2story.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
