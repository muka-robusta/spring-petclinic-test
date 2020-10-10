package io.github.one2story.petclinic.theory_controllers;

import io.github.one2story.petclinic.theory_services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    @BeforeEach
    void setUp() {

        controller = new ConstructorInjectedController(new ConstructorGreetingService());

    }

    @Test
    void getGreeting() {

        System.out.println(controller.getGreeting());

    }
}