package lessonFive;

import java.time.Duration;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class LessonFive {

    private void classRunner() {
        // own Runnable class
        var runnableClass = new OwnRunnableClass();
        runnableClass.run();

        // own Thread class
        var threadClass = new OwnTreadClass();
        threadClass.start();
    }

    private void lambdaRunner() {
        // Anonymous runner
        Thread thread = new Thread() {
            public void run() {
                System.out.println("Thread Running");
            }
        };
        thread.start();

        // or
        Thread threadAsLambda = new Thread(() -> System.out.println("Thread Running"));
        threadAsLambda.start();

        Runnable myRunnable =
                new Runnable() {
                    public void run() {
                        System.out.println("Runnable running");
                    }
                };
        myRunnable.run();
        // or
        Runnable myRunnableLambda = () -> System.out.println("Runnable running");
        myRunnableLambda.run();
    }

    private void infoAboutThread() {
        Thread thread = Thread.currentThread();
        String threadName = Thread.currentThread().getName();
        int threadPriority = Thread.currentThread().getPriority();
        Thread.State threadState = Thread.currentThread().getState();

        // pause
        try {
            sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void virtualThread() throws InterruptedException {
        Thread.ofVirtual().start(() -> System.out.println("test"));

        // start
        readFromFile().start();
        // or
        readFromFile().join();

    }

    private Thread readFromFile() {
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
        return Thread.ofVirtual()
                .name(name)
                .start(runnable);
    }

    private void pools() throws ExecutionException, InterruptedException {
        // like queue
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Run here!");
        // get result
        future.get();

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
}
