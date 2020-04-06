package chapter7.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorMain {

    public static void main(String[] args) {

        ExecutorService service = null;

        try {
            service = Executors.newSingleThreadExecutor();

            System.out.println("Begin!");

            service.execute(() -> System.out.println("Printing inventory"));
            service.execute(() -> { for (int i = 1; i < 10; i++) {
                System.out.println("Printing thead 1 " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                });

            service.shutdown(); //Throws RejectExecutionException and does not accept any new task
//            service.shutdownNow();

            service.execute(() -> { for (int i = 1; i < 10; i++) {
                System.out.println("Printing thread 2" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            });
            service.execute(() -> System.out.println("Printing inventory"));

            System.out.println("End!");

        } finally {
            service.shutdown();
        }

    }

}
