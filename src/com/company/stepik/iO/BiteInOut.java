package com.company.stepik.iO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

class BiteInOut {

    public static void main(String[] args) throws IOException {
//        createTXT();
//        copy();
//        readConsole();
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})));
        System.out.println(4 ^ 3);

    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int checksum = 0;
        int n = inputStream.read();
        while (n > -1) {
            checksum = Integer.rotateLeft(checksum, 1) ^ n;
            n = inputStream.read();
        }
        return checksum;
        // your implementation here
    }

    public static void copy() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("/users/andmat/downloads/File-TXT.txt");
            out = new FileOutputStream("/users/andmat/downloads/File-TXT2.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    private static Path file = Paths.get("/users/andmat/downloads/File-TXT3.txt");

    public static void createTXT() {
        String test = "Hello, where is your napkin?";
        List<String> lines = Arrays.asList("This is test for copy file.",
                "This is test2 for copy file.", test);
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
//            Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileOutputStream fileStream = new FileOutputStream(
                new File("/users/andmat/downloads/File-TXT3.txt"));
             OutputStreamWriter writer = new OutputStreamWriter(fileStream)) {
            System.out.println("Enter characters, 'q' to quit.");
            char c = 0;
            while (c != 'q') {
                c = (char) reader.read();
                System.out.print(c);
                writer.write(c);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }


}
