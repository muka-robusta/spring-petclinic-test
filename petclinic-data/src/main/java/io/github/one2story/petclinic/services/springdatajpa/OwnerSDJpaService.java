package io.github.one2story.petclinic.services.springdatajpa;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.repos.OwnerRepo;
import io.github.one2story.petclinic.repos.PetRepo;
import io.github.one2story.petclinic.repos.PetTypeRepo;
import io.github.one2story.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepo ownerRepository;
    private final PetRepo petRepository;
    private final PetTypeRepo petTypeRepository;

    public OwnerSDJpaService(OwnerRepo ownerRepository, PetRepo petRepository, PetTypeRepo petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
