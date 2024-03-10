# Java Development Lesson: Unit Tests, TestNG, and MockK

## Introduction

In this lesson, we'll explore the importance of unit tests in Java development and delve into advanced testing techniques using TestNG and MockK. Understanding how to write effective unit tests is crucial for ensuring the reliability and maintainability of your codebase.

## Prerequisites

Make sure you have the following set up in your Java project:

- **Java 21:** Use the latest Java version for enhanced language features and performance.
- **Maven:** Maven is a powerful build tool that simplifies project management and dependencies.

## 1. Unit Tests

### What are Unit Tests?

**Unit tests** verify the smallest units of your code in isolation. They help ensure that each part of your application works as intended. Writing unit tests early in the development process can prevent bugs and make code changes less error-prone.

### Example:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    public void testAddition() {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.add(3, 7);
        assertEquals(10, result, "Addition should return the correct sum");
    }

    @Test
    public void testSubtraction() {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.subtract(10, 4);
        assertEquals(6, result, "Subtraction should return the correct difference");
    }
}
```

**Note:** Ensure you have a `MathUtils` class with `add` and `subtract` methods.

## 2. TestNG and MockK

### TestNG Overview

**TestNG** is a testing framework inspired by JUnit but introduces new functionalities and is designed to be more flexible. It supports parallel test execution, parameterized tests, and various annotations for test configuration.

### Example:

```java
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TestNGExample {

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5, 4);
        assertEquals(result, 20, "Multiplication should return the correct result");
    }
}
```

**Note:** Ensure you have a `Calculator` class with a `multiply` method.

### MockK for Mocking

**MockK** is a mocking library for Kotlin, but it can also be used seamlessly in Java projects. It simplifies the creation of mock objects for testing purposes.

### Example:

```java
import io.mockk.MockKAnnotations;
import io.mockk.MockKExtension;
import io.mockk.every;
import io.mockk.mockk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockKExtension.class)
public class MockKExample {

    @Test
    public void testMocking() {
        MockKAnnotations.init(this);
        
        Calculator calculator = mockk(Calculator.class);
        every(() -> calculator.add(2, 3)).returns(5);

        int result = calculator.add(2, 3);
        assertEquals(result, 5, "Mocked addition should return the expected result");
    }
}
```

**Note:** Ensure you have a `Calculator` class with an `add` method.

3. Spock: Expressive Testing Framework
   Introduction to Spock
   Spock is a testing and specification framework that combines the best features of JUnit and TestNG. It offers a concise and expressive syntax for writing tests and is particularly powerful when used with Groovy.

Example:
groovy
Copy code
class SpockExample extends spock.lang.Specification {

    def "should return successful status"() {
        given:
        def service = new SomeService()

        when:
        def status = service.performAction()

        then:
        status == "SUCCESS"
    }
}
Note: Spock uses Groovy, so make sure to have Groovy dependencies and configure your project accordingly.