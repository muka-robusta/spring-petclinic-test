package io.github.one2story.petclinic.bootstrap;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.model.Vet;
import io.github.one2story.petclinic.services.OwnerService;
import io.github.one2story.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Feya");
        owner1.setLastName("Ding Ding");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Feya");
        owner2.setLastName("Ding Dong");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tsuprun");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lana");
        vet2.setLastName("Banana");

        vetService.save(vet2);


    }
}
