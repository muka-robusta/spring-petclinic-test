package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepo extends CrudRepository<Specialty, Long> {

}
