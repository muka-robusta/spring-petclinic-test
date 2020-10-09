package io.github.one2story.petclinic;

import io.github.one2story.petclinic.controllers.ConstructorInjectedController;
import io.github.one2story.petclinic.controllers.MyController;
import io.github.one2story.petclinic.controllers.PropertyInjectedController;
import io.github.one2story.petclinic.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetclinicApplication {

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(PetclinicApplication.class, args);
        final MyController myController = (MyController) context.getBean("myController");

        final String greetMsg = myController.sayHello();

        System.out.println(greetMsg );

        System.out.println("------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
    }

}
