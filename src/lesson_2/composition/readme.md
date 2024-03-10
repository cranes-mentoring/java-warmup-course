## Lesson Five: Composition in Java

### 1. Introduction to Composition

Composition is a fundamental concept in object-oriented programming where one class contains an object of another class. This lesson will focus on the `Connector` and `Meta` classes, showcasing the principles of composition.

### 2. Composition in `Connector` and `Meta` Classes

#### Connector Class
The `Connector` class includes an instance of the `Meta` class, demonstrating composition.

```java
public class Connector {

    String host;
    Meta meta;

    public Connector(String host, Meta meta) {
        this.host = host;
        this.meta = meta;
    }
}
```

#### Meta Class
The `Meta` class contains a `HashMap` that holds additional metadata.

```java
import java.util.HashMap;

public class Meta {
    HashMap<String, String> meta;

    public Meta(HashMap<String, String> meta) {
        this.meta = meta;
    }
}
```

### 3. Advantages of Composition

- **Code Reusability**: Composition allows reusing existing classes, promoting a modular and reusable code structure.
- **Flexibility**: The ability to change the behavior of a class by changing the composed object.
- **Simplified Interfaces**: Classes can expose only the necessary functionality, resulting in cleaner and more manageable interfaces.

### 4. Practical Usage

#### Creating and Using `Connector` with `Meta`

```java
import java.util.HashMap;

public class LessonFive {

    public static void main(String[] args) {
        // Creating metadata
        HashMap<String, String> metadata = new HashMap<>();
        metadata.put("version", "1.0");
        metadata.put("author", "John Doe");

        // Creating Connector with Meta
        Meta meta = new Meta(metadata);
        Connector connector = new Connector("localhost", meta);

        // Accessing metadata through composition
        System.out.println("Host: " + connector.host);
        System.out.println("Metadata: " + connector.meta.meta);
    }
}
```

In this lesson, we explored the concept of composition in Java through the `Connector` and `Meta` classes. Composition allows building complex systems by combining simpler, more focused components, promoting code reuse, flexibility, and simplified interfaces. The provided example demonstrates how to create and use classes in a composition relationship.