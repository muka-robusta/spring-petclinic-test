package io.github.one2story.petclinic.services;

import org.springframework.stereotype.Service;

@Service
public class SetterInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "O Bella Chao - Setter";
    }
}
