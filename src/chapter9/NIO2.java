package chapter9;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class NIO2 {

    public static void main(String[] args) {

        Path oldPath = Paths.get("C:", "ciprian", "test.txt");
        Path newPath = Paths.get("C:", "ciprian", "new-test.txt");

        try {
            Files.copy(oldPath, newPath);
            Files.copy(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
