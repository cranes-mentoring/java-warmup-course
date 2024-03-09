# Lesson Three: Generics in Java

Generics in Java provide a way to create classes, interfaces, and methods that operate with types as parameters, allowing for increased code flexibility and reusability. In this lesson, we'll explore generics through practical examples.

## Part 1: Records and Generics

### 1.1 Records
Records, introduced in Java 16, simplify the creation of classes to store and retrieve data. In this example, we have a `Connector` record:

```java
public record Connector(
        String host,
        int port
) {
}
```

This record automatically generates `equals`, `hashCode`, and `toString` methods based on its components (`host` and `port`).

## Part 2: Generic Classes and Methods

### 2.1 GenericWithClasses
The `GenericWithClasses` class demonstrates the creation of a generic class. It can hold and return data of any type.

```java
public class GenericWithClasses<T> {

    private T data;

    public GenericWithClasses(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
```

### 2.2 GenericWithMethods
The `GenericWithMethods` class illustrates generic methods with various constraints.

```java
public class GenericWithMethods {

    public <T> List<T> collect(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public <T extends Number> List<T> collectNumbers(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public <T extends Number & Comparable> List<T> collectNumbersAndComparable(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public void findAllHosts(List<? extends Connector> connectors) {
        connectors.stream().map(Connector::host).forEach(System.out::println);
    }
}
```

### 2.3 GenericWithNumberClasses
The `GenericWithNumberClasses` class is a generic class with a type constraint, ensuring it works only with subclasses of `Number`.

```java
public class GenericWithNumberClasses<T extends Number> {

    private T data;

    public GenericWithNumberClasses(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void display() {
        System.out.println("This is a bounded type generics class.");
    }
}
```

## Part 3: Using Generics in Practice

### 3.1 LessonThree Main Class
In the `LessonThree` class, we put generics into practice with various scenarios:

- **Generic Methods Usage:**
```java
var genericWithMethods = new GenericWithMethods();
var integers = new Integer[] { 1, 2, 3 };
genericWithMethods.collect(integers);
genericWithMethods.collectNumbers(integers);
genericWithMethods.collectNumbersAndComparable(integers);
```

- **Generic Classes Usage:**
```java
var genericWithStringClasses = new GenericWithClasses<>("test");
var genericWithIntegerClasses = new GenericWithClasses<>(123);
```

- **GenericWithNumberClasses with Type Constraint:**
```java
var numbers = new GenericWithNumberClasses(123);
numbers.display();
// but with String we will have exceptions
// var strings = new GenericWithNumberClasses("123"); // cast exception
```

### 3.2 ConnectorMapper - A Generic Mapper
The `ConnectorMapper` class implements a generic interface `Mapper` that maps `Connector` objects to strings.

```java
public class ConnectorMapper implements Mapper<Connector, String> {
    @Override
    public String map(Connector data) {
        return data.toString();
    }

    @Override
    public List<String> map(List<Connector> listOfData) {
        return listOfData
                .stream()
                .map(Connector::toString)
                .collect(Collectors.toList());
    }
}
```

### 3.3 Mapper Interface
The `Mapper` interface defines generic methods for mapping objects.

```java
public interface Mapper<T, U> {
    U map(T data);

    List<U> map(List<T> listOfData);
}
```

## Summary

This lesson covered the basics of generics in Java, including generic classes, methods, and interfaces. We applied these concepts in practical scenarios with records, generic classes, and methods. Understanding generics is crucial for creating flexible and reusable code in Java.