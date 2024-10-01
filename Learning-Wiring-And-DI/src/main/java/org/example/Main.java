package org.example;

import org.example.auto.components.Car;
import org.example.auto.config.AutoConfig;
import org.example.manual.config.ManualConfig;
import org.example.manual.entity.Cat;
import org.example.manual.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ManualConfig.class, AutoConfig.class);

        //@Bean annotated method for cat directly called by @Bean method for person
        Person person = context.getBean("person1", Person.class);
        Cat cat = context.getBean("cat1", Cat.class);
        System.out.println("Person: " + person.getName());
        System.out.println("Cat: " + cat.getName());
        System.out.println("Person's" + " " + person.getCat());

        System.out.println();

        //Cat bean passed through parameter of Person bean.
        Person person2 = context.getBean("person2", Person.class);
        Cat cat2 = context.getBean("cat2", Cat.class);
        System.out.println("Person2: " + person2.getName());
        System.out.println("Cat2: " + cat2.getName());
        System.out.println("Person2's" + " " + person2.getCat());

        System.out.println();

        Car car = context.getBean(Car.class);
        System.out.println(car.getName());
        //@Autowired on constructor.
        System.out.println(car.getEngine());
        //@Autowired on field.
        System.out.println(car.getTyre());
        //@Autowired on setter.
        System.out.println(car.getTransmission());
    }
}