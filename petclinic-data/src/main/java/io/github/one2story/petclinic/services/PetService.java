package io.github.one2story.petclinic.services;

import io.github.one2story.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();
    Pet findById(Long id);

    Pet save(Pet owner);

}
