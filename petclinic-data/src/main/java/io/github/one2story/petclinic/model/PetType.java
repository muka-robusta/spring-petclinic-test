package io.github.one2story.petclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetType extends BaseEntity {

    private String name;
}
