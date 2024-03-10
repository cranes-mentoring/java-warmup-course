# Lesson 8: Extra Lesson on Useful Languages for Teams

In this extra lesson, we'll explore three languages that can be beneficial for a development team: Groovy, Kotlin, and Scala. Each language brings unique features and capabilities to the table, making them valuable in different scenarios.

## 1. Groovy: Testing with Spock

### What is Groovy?

**Groovy** is a dynamic language for the Java Virtual Machine (JVM) with features similar to Python, Ruby, and Smalltalk. It seamlessly integrates with existing Java code and libraries, making it an excellent choice for scripting and testing.

### Testing with Spock

**Spock** is a testing and specification framework for Groovy and Java applications. It provides a readable and expressive syntax for writing tests and specifications. Spock's power becomes evident when combined with Groovy's concise and expressive features.

#### Example:

```groovy
class MathOperationsSpec extends spock.lang.Specification {

    def "should add two numbers"() {
        given:
        def calculator = new Calculator()

        when:
        def result = calculator.add(3, 7)

        then:
        result == 10
    }

    def "should subtract two numbers"() {
        given:
        def calculator = new Calculator()

        when:
        def result = calculator.subtract(10, 4)

        then:
        result == 6
    }
}
```

In this example, Spock allows you to express your test scenarios in a natural language style.

## 2. Kotlin: Mocking with MockK

### What is Kotlin?

**Kotlin** is a modern, concise, and statically-typed programming language that interoperates seamlessly with Java. It aims to be fully interoperable with existing Java codebases while offering advanced features.

### Mocking with MockK

**MockK** is a mocking library for Kotlin, designed to simplify the creation of mock objects for testing. It provides a clear and concise syntax for defining mock behavior.

#### Example:

```kotlin
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MockKExample {

    @Test
    fun `should mock addition`() {
        val calculator = mockk<Calculator>()
        every { calculator.add(2, 3) } returns 5

        val result = calculator.add(2, 3)
        assertEquals(5, result, "Mocked addition should return the expected result")
    }
}
```

MockK simplifies the process of creating mock objects and defining their behavior.

## 3. Scala: Gatling Load Tests

### What is Scala?

**Scala** is a powerful, statically-typed programming language that combines object-oriented and functional programming features. It is designed to be concise and expressive, making it an excellent choice for building scalable and maintainable systems.

### Gatling Load Tests

**Gatling** is an open-source load testing framework written in Scala. It allows you to simulate thousands of users interacting with your application, providing insights into performance and scalability.

#### Example:

```scala
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MySimulation extends Simulation {

  val httpConf = http.baseUrl("https://example.com")

  val scn = scenario("My Scenario")
    .exec(http("request_1").get("/page1"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpConf)
}
```

This Gatling simulation sends 10 users to visit "https://example.com/page1" simultaneously.