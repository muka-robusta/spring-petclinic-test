package io.github.one2story.petclinic.theory_services;

import org.springframework.stereotype.Service;

@Service
public class PropertyInjectedGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "O Bella Chao - Property";
    }
}
