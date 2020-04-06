package chapter6.autoclosable;

import java.io.Closeable;

public class SuppressedExceptionsMain {

    public static void main(String[] args) {

        try(TurkeyCage cage = new TurkeyCage();
            TurkeyCage cage2 = new TurkeyCage();) {
            //This one will throw first
            throw new IllegalStateException("Turkey ran off");
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
            //suppressed exceptions
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }
}

class TurkeyCage implements Closeable {
    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Turkey Escaped from cage!!!");
    }
}
