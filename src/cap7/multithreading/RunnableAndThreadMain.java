package cap7.multithreading;

public class RunnableAndThreadMain {

    public static void main(String[] args) {

        Thread usingRunnable = new Thread(new RunnableMock());
        usingRunnable.start();

        ThreadMock usingThread = new ThreadMock();
        usingThread.start();
    }
}

class RunnableMock implements Runnable {

    @Override
    public void run() {
        for ( int i = 1; i <= 20; i++) {
            System.out.println("Runnable: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadMock extends Thread {

    @Override
    public void run() {
        for ( int i = 1; i <= 20; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
