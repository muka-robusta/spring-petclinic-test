package io.github.one2story.petclinic.services.map;

import io.github.one2story.petclinic.model.Visit;
import io.github.one2story.petclinic.services.PetService;
import io.github.one2story.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {

        if (visit.getPet() == null || visit.getPet().getOwner() == null
                || visit.getPet().getId() == null
                || visit.getPet().getOwner().getId() == null)
            throw new RuntimeException("Invalid Visit");

        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return null;
    }
}
