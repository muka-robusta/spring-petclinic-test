package io.github.one2story.petclinic.bootstrap;

import io.github.one2story.petclinic.model.*;
import io.github.one2story.petclinic.services.OwnerService;
import io.github.one2story.petclinic.services.PetTypeService;
import io.github.one2story.petclinic.services.SpecialtyService;
import io.github.one2story.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int petCount = petTypeService.findAll().size();

        if (petCount == 0)
            loadData();

    }

    private void loadData() {
        PetType dogType = new PetType();
        dogType.setName("dog");
        PetType savedDogType = petTypeService.save(dogType);

        PetType catType = new PetType();
        catType.setName("cat");
        PetType savedCatType = petTypeService.save(catType);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedSpecialtyRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSpecialtySurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedSpecialtyDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Feya");
        owner1.setLastName("Ding Ding");
        owner1.setAddress("34, Pyatnitska street");
        owner1.setCity("Chernihiv, Ukraine");
        owner1.setTelephone("+380772223355");

        Pet pet1 = new Pet();
        pet1.setPetType(savedCatType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Kukushka");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Feya");
        owner2.setLastName("Ding Dong");
        owner2.setAddress("34, Pyatnitska street");
        owner2.setCity("Chernihiv, Ukraine");
        owner2.setTelephone("+380772223355");
        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setName("Fiona");
        pet2.setOwner(owner2);
        pet2.setPetType(savedDogType);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tsuprun");
        vet1.getSpecialities().add(savedSpecialtyRadiology);
        vet1.getSpecialities().add(savedSpecialtySurgery);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lana");
        vet2.setLastName("Banana");
        vet2.getSpecialities().add(savedSpecialtyDentistry);

        vetService.save(vet2);
    }
}
