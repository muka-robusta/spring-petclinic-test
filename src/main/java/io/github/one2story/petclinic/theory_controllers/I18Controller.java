package io.github.one2story.petclinic.theory_controllers;

import io.github.one2story.petclinic.theory_services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class I18Controller {
    private final GreetingService greetingService;

    public I18Controller(@Qualifier("i18Service") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
