package io.github.one2story.petclinic.services;

import io.github.one2story.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();
    Vet findById(Long id);

    Vet save(Vet vet);

}
