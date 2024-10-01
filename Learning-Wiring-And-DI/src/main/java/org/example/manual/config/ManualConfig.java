package org.example.manual.config;

import org.example.manual.entity.Cat;
import org.example.manual.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManualConfig {

    @Bean
    public Cat cat1() {
        Cat cat1 = new Cat();
        cat1.setName("Coco");
        return cat1;
    }

    @Bean
    public Person person1(@Qualifier("cat1") Cat cat) {
        Person person1 = new Person();
        person1.setName("Bob");
        person1.setCat(cat);
        return person1;
    }

    @Bean
    public Person person2() {
        Person person2 = new Person();
        person2.setName("Ruble");
        person2.setCat(cat2());
        return person2;
    }

    @Bean
    public Cat cat2() {
        Cat cat2 = new Cat();
        cat2.setName("Bubu");
        return cat2;
    }

}
