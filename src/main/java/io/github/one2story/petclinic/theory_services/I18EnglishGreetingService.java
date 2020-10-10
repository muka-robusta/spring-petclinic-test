package io.github.one2story.petclinic.theory_services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN", "default"})
@Service("i18Service")
public class I18EnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world";
    }
}
