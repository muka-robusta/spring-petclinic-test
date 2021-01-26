package io.github.one2story.petclinic.services.springdatajpa;

import io.github.one2story.petclinic.model.Vet;
import io.github.one2story.petclinic.repos.VetRepo;
import io.github.one2story.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepo vetRepo;

    public VetSDJpaService(VetRepo vetRepo) {
        this.vetRepo = vetRepo;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepo.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepo.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepo.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepo.deleteById(aLong);
    }
}
