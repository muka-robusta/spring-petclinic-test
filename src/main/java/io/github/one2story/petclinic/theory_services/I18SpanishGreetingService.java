package io.github.one2story.petclinic.theory_services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("SP")
@Service("i18Service")
public class I18SpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo";
    }
}
