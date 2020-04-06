package chapter8;

import java.io.*;

public class Streams {

    public static void main(String[] args) {

        try {
            File inFile = new File("files/file.txt");
            File outFile = new File("files/fileResult.txt");

//            copyByteByByte(inFile, outFile);
            copyUsingBuffer(inFile, outFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyByteByByte(File input, File output) throws IOException {
        long start = System.currentTimeMillis();
        try (FileInputStream in = new FileInputStream(input);
             FileOutputStream out = new FileOutputStream(output)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println( (end - start) );
    }

    public static void copyUsingBuffer(File input, File output) throws IOException {
        long start = System.currentTimeMillis();
        try (InputStream in = new BufferedInputStream(new FileInputStream(input));
            OutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ( (lengthRead = in.read(buffer)) > 0 ) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println( (end - start) );
    }

}
