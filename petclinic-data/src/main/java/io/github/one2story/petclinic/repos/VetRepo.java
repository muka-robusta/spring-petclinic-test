package io.github.one2story.petclinic.repos;

import io.github.one2story.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepo extends CrudRepository<Vet, Long> {

}
