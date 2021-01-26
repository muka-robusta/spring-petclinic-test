package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
