package chapter8;

import java.io.*;

public class PrintStreamAndPrintWriter {

    public static void main(String[] args) throws IOException {

        File source = new File("files\\zoo.log");
        
        if (!source.exists()) {
            source.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(source)) {
            out.print("Today's weather is: ");
            out.println("Sunny");
            out.print("Today's temperature at the zoo is: ");
            out.print(1/3.0);
            out.println('C');
            out.format("It has rained 10.12 inches this year");
            out.println();
            out.printf("It may rain 21.2 more inches this year");
        }

        BufferedReader a = new BufferedReader(new FileReader(""));
    }
}