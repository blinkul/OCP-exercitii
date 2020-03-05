package cap7.multithreading;

public class Main {

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
        for ( int i = 0; i < 100; i++) {
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
        for ( int i = 0; i < 100; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
