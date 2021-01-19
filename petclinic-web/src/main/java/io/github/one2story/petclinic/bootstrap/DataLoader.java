package io.github.one2story.petclinic.bootstrap;

import io.github.one2story.petclinic.model.Owner;
import io.github.one2story.petclinic.model.Vet;
import io.github.one2story.petclinic.services.OwnerService;
import io.github.one2story.petclinic.services.VetService;
import io.github.one2story.petclinic.services.map.OwnerServiceMap;
import io.github.one2story.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Feya");
        owner1.setLastName("Ding Ding");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Feya");
        owner2.setLastName("Ding Dong");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tsuprun");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Lana");
        vet2.setLastName("Banana");

        vetService.save(vet2);


    }
}
