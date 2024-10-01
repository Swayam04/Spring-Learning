# Adding Beans to the Spring Context

Beans are object instances that the programmer expects Spring to manage. This repo contains code that demonstrates various methods to add beans to the Spring context, which is like a container for all the instances that Spring is expected to manage.

## Method 1: @Bean Annotation

- **@Configuration**: Designates a configuration class to initiate a Spring context.
- **@Bean**: Marks methods that return the instance of a class to be added to the Spring context. These methods are often named as nouns.
- **Multiple Instances**: Multiple instances of the same class can be added with method names as aliases, and a primary class can be set for default behavior.
- **Flexibility**: This method is flexible and can be used for library classes, but it is more verbose.

## Method 2: Stereotype Annotations

- **@Component**: Used on classes whose objects need to be added to the Spring context.
- **@ComponentScan**: The configuration class needs to be annotated with @ComponentScan, specifying the package of component classes. No need to declare methods inside the config class.
- **Readability**: Involves less code and improves readability but is only applicable to user-defined classes, and only one instance can be added per class.
- **@PostConstruct**: Can be used to set properties after instantiation.

## Programmatically Adding Beans

- **context.registerBean**: `context.registerBean(String beanName, Class<T> beanClass, Supplier<T> supplier, BeanDefinitionCustomizer... customizers)` can be used to programmatically add beans to the context.
- **Flexibility**: This approach is most flexible but can only be used with Spring 5 and above.