package io.github.one2story.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetclinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetclinicApplication.class, args);
        /*
        final ApplicationContext context = SpringApplication.run(PetclinicApplication.class, args);
        final MyController myController = (MyController) context.getBean("myController");

        System.out.println("------- i18");
        I18Controller i18Controller = (I18Controller) context.getBean("i18Controller");
        System.out.println(i18Controller.sayHello());

        System.out.println("------- PRIMARY");
        System.out.println(myController.sayHello());

        System.out.println("------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

         */
    }

}
