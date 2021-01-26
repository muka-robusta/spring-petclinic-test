package io.github.one2story.petclinic.services.map;

import io.github.one2story.petclinic.model.Vet;
import io.github.one2story.petclinic.services.SpecialtyService;
import io.github.one2story.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    private VetServiceMap(SpecialtyService service) {
        specialtyService = service;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object == null)
            return null;

        object.getSpecialities().forEach(specialty -> {
            if (specialty.getId() == null)
                specialty.setId(specialtyService.save(specialty).getId());
        });

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
