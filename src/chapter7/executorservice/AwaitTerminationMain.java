package chapter7.executorservice;

import java.util.concurrent.*;

//THIS IS MISSING SOMETHING
public class AwaitTerminationMain {

    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            service.execute(new TaskCreator(1));
            service.execute(new TaskCreator(2));
        } finally {
            System.out.println("Service will be shutting down!");
            service.shutdown();
        }

        try {
            service.awaitTermination(15, TimeUnit.SECONDS);
            if (service.isTerminated()) {
                System.out.println("All processes are completed!");
            } else {
                System.out.println("At least one process is running!");
            }
        } catch (InterruptedException e) {
            System.out.println("Awaiting termination has been cancelled");
        }

    }
}

class TaskCreator implements Runnable {

    private int number;

    public TaskCreator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 10; i > 1; i--) {
            try {
                System.out.println("(" + number + ") Take off in " + i + "s");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("(" + number + ") Launch has been interrupted!");
            }
        }
        System.out.println("(" + number + ") ROCKET IS TAKING OFF!");
    }

}
