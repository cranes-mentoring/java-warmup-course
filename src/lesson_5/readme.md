# Lesson Five: Threads and Executors in Java

In this lesson, we'll dive into the world of Java threads and executors. Understanding how to work with threads is crucial for building concurrent and efficient applications.

## Part 1: Basics of Threads

### 1.1 Runnable and Thread Classes

#### OwnRunnableClass
The `OwnRunnableClass` is an implementation of the `Runnable` interface, providing the `run` method to be executed when the thread starts.

```java
public class OwnRunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("run: OwnRunnableClass");
    }
}
```

#### OwnThreadClass
The `OwnThreadClass` extends the `Thread` class, overriding the `run` method for custom thread behavior.

```java
public class OwnThreadClass extends Thread {

    @Override
    public void run() {
        super.run();
        // Custom thread behavior
    }
}
```

#### LessonFive Class
The `LessonFive` class demonstrates various aspects of working with threads.

```java
public class LessonFive {

    private void classRunner() {
        // Creating and running a thread using OwnRunnableClass
        var runnableClass = new OwnRunnableClass();
        runnableClass.run();

        // Creating and running a thread using OwnThreadClass
        var threadClass = new OwnThreadClass();
        threadClass.start();
    }

    private void lambdaRunner() {
        // Creating and running threads using anonymous classes and lambdas
        Thread threadAsAnonymous = new Thread() {
            public void run() {
                System.out.println("Thread Running");
            }
        };
        threadAsAnonymous.start();

        Thread threadAsLambda = new Thread(() -> System.out.println("Thread Running"));
        threadAsLambda.start();

        // Creating and running a Runnable using a lambda
        Runnable myRunnableLambda = () -> System.out.println("Runnable running");
        myRunnableLambda.run();
    }

    private void infoAboutThread() {
        // Retrieving information about the current thread
        Thread thread = Thread.currentThread();
        String threadName = Thread.currentThread().getName();
        int threadPriority = Thread.currentThread().getPriority();
        Thread.State threadState = Thread.currentThread().getState();

        // Pausing the current thread
        try {
            sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## Part 2: Virtual Threads

### 2.1 Introduction to Virtual Threads

Java introduced virtual threads as lightweight, highly efficient threads. They can be created using the `Thread.ofVirtual()` method.

```java
private void virtualThread() throws InterruptedException {
    // Creating and starting a virtual thread
    Thread.ofVirtual().start(() -> System.out.println("Virtual Thread Running"));

    // Starting a virtual thread and waiting for it to finish
    readFromFile().start();
    // or
    readFromFile().join();
}

private Thread readFromFile() {
    // Creating a virtual thread for reading from a file
    return createVirtualThread(
            "reading from file",
            () -> {
                System.out.println("open file....");
                try {
                    sleep(Duration.ofMillis(500L));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("close file...");
            });
}

private Thread createVirtualThread(String name, Runnable runnable) {
    // Creating a virtual thread with a custom name and runnable
    return Thread.ofVirtual()
            .name(name)
            .start(runnable);
}
```

## Part 3: Executors and Thread Pools

### 3.1 Introduction to Executors and Thread Pools

Executors and thread pools provide a convenient way to manage and reuse threads. They abstract away the complexity of manual thread management.

```java
private void pools() throws ExecutionException, InterruptedException {
    // Creating a fixed-size thread pool using Executors
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    // Submitting a task to the executor and obtaining a Future
    Future<String> future = executorService.submit(() -> "Run here!");

    // Getting the result from the Future
    String result = future.get();

    // Creating a ThreadPoolExecutor for more control over the thread pool
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    executor.submit(() -> {
        Thread.sleep(1000);
        return null;
    });
    executor.submit(() -> {
        Thread.sleep(1000);
        return null;
    });
    executor.submit(() -> {
        Thread.sleep(1000);
        return null;
    });
}
```

In this lesson, we covered the basics of working with threads in Java, including creating threads using `Runnable` and `Thread` classes, utilizing virtual threads, and leveraging executors and thread pools for efficient thread management. Understanding these concepts is essential for building responsive and concurrent applications in Java.