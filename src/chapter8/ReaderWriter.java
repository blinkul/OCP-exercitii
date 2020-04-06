package chapter8;

import java.io.*;

public class ReaderWriter {



    public static void main(String[] args) throws IOException {

        File inFile = new File("files/file.txt");
        File outFile = new File("files/fileResult.txt");

        copyWithoutBuffer(inFile, outFile);

    }

    public static void copyWithoutBuffer(File in, File out) throws IOException {
        long start = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader(in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {

            String s;
            while ( (s = reader.readLine()) != null) {
                writer.write(s);
                writer.newLine();
                writer.flush();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println( (end - start) );
    }

}
