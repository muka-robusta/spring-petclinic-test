package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepo extends CrudRepository<Visit, Long> {

}
