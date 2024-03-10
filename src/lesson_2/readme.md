## Lesson Four: Object-Oriented Programming - Encapsulation, Inheritance, and Polymorphism

### 1. Encapsulation

#### AbstractConnector
The `AbstractConnector` class demonstrates encapsulation by keeping the `host` and `port` fields private and providing methods for controlled access.

```java
public abstract class AbstractConnector {

    private String host;
    private int port;

    // Constructor and abstract method are encapsulated

    public void connect() {
        // Method demonstrates encapsulation by accessing private fields
        System.out.println("Abstract connector. connect. host:" + host + " port:" + port);
    }

    // Other methods and implementation details are encapsulated
}
```

#### Connector
The `Connector` class encapsulates the process of creating a connection.

```java
public class Connector {

    public String createConnection(String host) {
        // Method encapsulates the process of creating a connection
        var newConnection = openConnection();
        // todo: do some work
        return newConnection;
    }

    private String openConnection() {
        // Method encapsulates the details of opening a connection
        return "ip address";
    }
}
```

### 2. Inheritance

#### MobileConnector and OfficeConnector
The `MobileConnector` and `OfficeConnector` classes demonstrate inheritance by extending the `AbstractConnector` class.

```java
public class MobileConnector extends AbstractConnector {
    // Inherits abstract method 'ping' and other methods from AbstractConnector
}

public class OfficeConnector extends AbstractConnector {
    // Inherits abstract method 'ping' and other methods from AbstractConnector
}
```

### 3. Polymorphism

#### LessonTwo
The `LessonTwo` class demonstrates polymorphism with the use of the `connectToAnotherOffice` method, accepting any class implementing the `IConnector` interface.

```java
public class LessonTwo {

    public static void main(String[] args) {
        // Polymorphism
        var office = new Office("Budva-1");
        var officeConnectorOne = new OfficeConnector("localhost", 8080);

        office.connectToAnotherOffice(officeConnectorOne);

        var officeBar = new Office("Bar-1");
        var mobileConnectorOne = new MobileConnector("MTEL", "localhost", 8081);
        officeBar.connectToAnotherOffice(mobileConnectorOne);
    }
}
```

#### IConnector Interface
The `IConnector` interface defines a contract for connection-related actions.

```java
public interface IConnector {
    void connect(String host);
    void disconnect(String host);
    void pause(String host);
    void dropAll();
}
```

#### Office
The `Office` class demonstrates polymorphism by accepting any class implementing the `IConnector` interface.

```java
public class Office {

    public void connectToAnotherOffice(IConnector connector) {
        connector.connect("remote_host");
        // todo: additional actions
    }
}
```

In this lesson, we covered the concepts of encapsulation, inheritance, and polymorphism through practical examples using Java classes and interfaces. These principles are fundamental to object-oriented programming and contribute to building robust and maintainable code.