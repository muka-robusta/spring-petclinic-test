package io.github.one2story.petclinic.services.springdatajpa;

import io.github.one2story.petclinic.model.Specialty;
import io.github.one2story.petclinic.repos.SpecialtyRepo;
import io.github.one2story.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepo specialtyRepo;

    public SpecialtySDJpaService(SpecialtyRepo specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepo.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
         return specialtyRepo.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepo.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepo.deleteById(aLong);
    }
}
