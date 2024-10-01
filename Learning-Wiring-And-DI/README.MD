# Wiring Beans in Spring

The Spring context is a memory space that the Spring Framework uses to manage objects. If these objects have a "has-a" relationship (association) with other objects in the context, you need to tell Spring to establish these relationships, a process known as wiring. Here are the ways to achieve this:

## Manually Setting Relationships Between Beans in the Config Class

For beans declared as methods in the Config class with the `@Bean` annotation, you can set relationships in two ways:

### 1. Directly Referring to the @Bean Annotated Method

A relationship can be established by directly referring to the `@Bean` annotated method that creates one bean from the method that creates the other (inside a setter, constructor, etc.). If the bean referred to is already created, Spring does not call its `@Bean` method again but returns a reference to the existing bean in the context.

### 2. Defining a Parameter to the Method Annotated with @Bean

If the `@Bean` method has a parameter, Spring searches for a bean of that parameter's type in its context and injects that value. If there are multiple beans of the parameter's type, you can specify which one to use to prevent an exception:

- **Parameter Name Matching**: The parameter name matches one of the `@Bean` method names (deprecated and not recommended due to potential refactoring issues).
- **@Qualifier**: Use `@Qualifier("beanMethodName")` to specify which bean to use.
- **@Primary**: Annotate one of the beans with `@Primary` to make it the default.

## Using @Autowired Annotation

Alternatively, use the `@Autowired` annotation in the class that contains the object of another bean class as an attribute. This method can also wire beans declared with stereotype annotations. If there are multiple beans of the same type, use the `@Qualifier` annotation to specify the bean to use. There are three ways to use `@Autowired`:

### 1. Using @Autowired with the Attribute

Annotate the field where Spring should inject the bean from the context. This approach is not recommended as it prevents the field from being final, making it harder to manage and test.

### 2. Using @Autowired to Inject Value Through the Constructor

Annotate the constructor that Spring should call to create the bean. Spring injects the other beans from the context through the constructor's parameters. This is a recommended practice.

### 3. Using @Autowired to Inject Values Through a Setter Method

Annotate the setter of the attribute where Spring should inject a bean from the context. This method is often avoided as it prevents the field from being final, complicates testing, and can be challenging to read.

## Circular Dependencies

Creating two beans that depend on each other results in a circular dependency. Spring cannot handle circular dependencies and will fail with an exception. Avoid such configurations to prevent runtime errors.

