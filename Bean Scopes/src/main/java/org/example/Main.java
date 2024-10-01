package org.example;

import org.example.config.ProjectConfig;
import org.example.services.PaymentService;
import org.example.services.ProductService;
import org.example.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var config = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println("Before retrieving beans");

        //Constructor prints once because UserService is a Singleton Bean. Eager initialisation.
        UserService us1 = config.getBean("userService1", UserService.class);
        UserService us2 = config.getBean("userService1", UserService.class);
        //Prints now because of lazy initialisation.
        ProductService ps1 = config.getBean(ProductService.class);

        System.out.println("After retrieving beans");

        //Equal because singleton bean.
        System.out.println(us1 == us2);

        //Prototype Bean. Different object for each retrieval.
        PaymentService pas1 = config.getBean(PaymentService.class);
        PaymentService pas2 = config.getBean(PaymentService.class);

        System.out.println(pas1 == pas2);
    }
}