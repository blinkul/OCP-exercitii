package cap7.multithreading.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceMain {

    public static void main(String[] args) {

        Runnable launcher = () -> {
            for (int i = 10; i > 0; i--) {
                System.out.println("Launching in " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.schedule(launcher, 5, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(launcher, 2, 5, TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(launcher, 0, 5, TimeUnit.SECONDS);
    }

}
