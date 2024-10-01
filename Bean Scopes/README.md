# Bean Scopes in Spring Framework

Spring Framework offers various approaches for creating beans and managing their lifecycles, known as scopes. These scopes determine the creation, use, and destruction of beans within the application context.

## Overview of Bean Scopes

Spring provides several bean scopes, including:

- **Singleton**
- **Prototype**
- **Request**
- **Session**
- **Application**

This document focuses on the two most commonly used scopes: Singleton and Prototype.

## Singleton Scope

The Singleton scope is the default scope in Spring. It ensures that a single instance of a bean is created and shared throughout the application context.

### Characteristics of Singleton Beans

- Spring creates a Singleton bean when it loads the context and assigns the bean a unique name.
- The framework always returns the same instance when referencing a specific bean by name.
- Unlike the Singleton Design Pattern, which allows only one instance of a specific type, Spring permits multiple instances of the same type as long as they have unique names.

### Best Practices for Singleton Beans

To prevent concurrency issues such as race conditions, it is recommended to design Singleton beans as immutable. Consequently, constructor dependency injection is the preferred method for these beans.

### Instantiation Methods for Singleton Beans

Spring offers two instantiation methods for creating Singleton beans:

1. **Eager Instantiation**
    - Default method
    - Spring creates beans during context initialization
    - Advantages:
        - Slightly more performant
        - Facilitates early detection of configuration issues

2. **Lazy Instantiation**
    - Spring creates bean instances upon first reference
    - Implementation:
        - Use `@Lazy` annotation above the class (for stereotype annotations)
        - Use `@Lazy` annotation above the `@Bean` method (for configuration classes)
    - Benefits:
        - Conserves memory for resource-intensive beans
        - Useful when beans are not always required during application startup

## Prototype Scope

The Prototype scope creates a new instance each time a reference to a prototype-scoped bean is requested.

### Characteristics of Prototype Beans

- Spring manages the object's type rather than a single instance
- A new instance is created for each bean request

### Implementing Prototype Scope

To use the Prototype scope, employ the `@Scope` annotation:

```java
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
```
This annotation can be used with either the `@Bean` method or the component class (stereotype-annotated class).

### Advantages of Prototype Scope

- Eliminates certain concurrency problems, as each thread works with a distinct instance
- Useful for stateful beans where shared instances are undesirable

### Considerations When Mixing Scopes

When injecting a prototype-scoped bean into a singleton-scoped bean, be aware that the singleton bean will always use the same prototype instance, potentially negating the benefits of the prototype scope.

To address this issue, consider the following approach:

1. Inject the application context into the singleton bean
2. Use the context to create new instances of the prototype bean as needed

Example:

```java
@Component
public class SingletonBean {
    @Autowired
    private ApplicationContext context;

    public void someMethod() {
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        // Use the new instance of prototypeBean
    }
}
```
This method ensures that a new instance of the prototype bean is created each time it's required within the singleton bean.