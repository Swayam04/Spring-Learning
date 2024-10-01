package org.example;

import org.example.config.ProjectConfig;
import org.example.entity.Cat;
import org.example.entity.Dog;
import org.example.entity.Lion;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //Using Bean annotation
        Cat cat = context.getBean(Cat.class);
        System.out.println(cat.getName());

        //Multiple beans of same type
        Integer num1 = context.getBean("b", Integer.class);
        System.out.println(num1);

        //Primary bean
        Integer num2 = context.getBean(Integer.class);
        System.out.println(num2);

        //Stereotype annotation - @Component
        Dog dog = context.getBean(Dog.class);
        System.out.println(dog.getName());

        Lion l1 = new Lion();
        l1.setName("Christian");

        //Using the registerBean method
        context.registerBean("lion1", Lion.class, () -> l1, bc -> bc.setPrimary(true));
        System.out.println(context.getBean(Lion.class).getName());
    }
}