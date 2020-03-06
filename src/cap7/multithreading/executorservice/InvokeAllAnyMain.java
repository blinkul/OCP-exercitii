package cap7.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//THIS IS MISSING SOMETHING
public class InvokeAllAnyMain {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Marcel");
        Cat cat2 = new Cat("Mitzoi");
        Cat cat3 = new Cat("Cici");

        List<Play<Cat>> playingTasks = new ArrayList<>();
        playingTasks.add(new Play<>(cat1));
        playingTasks.add(new Play<>(cat2));
        playingTasks.add(new Play<>(cat3));

        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<Cat> result;
        try {
            result = service.invokeAny(playingTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Cat implements Future<Cat> {
    public String name;
    public boolean isTired;

    public Cat (String name) {
        this.name = name;
    }

    public void setTired(boolean tired) {
        isTired = tired;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Cat get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public Cat get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}

class Play<Cat> implements Callable<Cat> {

    private Cat cat;

    public Play(Cat cat) {
        this.cat = cat;
    }

    @Override
    public Cat call() throws Exception {
        return this.play(cat);
    }

    public synchronized Cat play(Cat cat) throws InterruptedException {

        for (int i = 10; i == 0; i--) {
            System.out.println("Playing time remaining: " + i);
            Thread.sleep(1000);
        }

        return cat;
    }

}
