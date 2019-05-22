package com.company.stepik.iO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class InputOutputStream {

    public static void main(String[] args) throws IOException {

//        readAndWrite();
//        fileReaderWriter();
        bufReader();
        stringWriter("hello");
        nioBufReader();


    }

    static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        // your implementation here
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        int c;
        StringBuilder str = new StringBuilder();
        while ((c = reader.read()) != -1) {
            str.append((char) c);
        }
        return str.toString();
    }

    static Path path2 = Paths.get("/users/andmat/downloads/File-TXT2.txt");
    static Path pathOut = Paths.get("/users/andmat/downloads/File-TXT-OUT.txt");

    static void readAndWrite() throws FileNotFoundException {
        Reader reader = new InputStreamReader(new FileInputStream(
                "/users/andmat/downloads/File-TXT2.txt"), StandardCharsets.UTF_8);
        Writer writer = new OutputStreamWriter(new FileOutputStream(
                "/users/andmat/downloads/File-TXT-OUT.txt"), StandardCharsets.UTF_8);
        String str = null;
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReaderWriter() {
        try (FileReader reader = new FileReader("/users/andmat/downloads/File-TXT3.txt");
             FileWriter writer = new FileWriter("/users/andmat/downloads/File-TXT-OUT.txt", true)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.println((char) c);
                writer.write((char) c);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void bufReader() {        //read to intermediate buffer from char array
        try (FileReader reader = new FileReader("/users/andmat/downloads/File-TXT-OUT.txt")) {
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.print(buf);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void stringWriter(String string) {
        StringWriter writer = new StringWriter();
        writer.append(string);
        System.out.println("\n" + writer.toString());
    }

    static void nioBufReader() {        //самый норм способ
        try (BufferedReader reader = Files.newBufferedReader(pathOut, StandardCharsets.UTF_8)) {  //or Paths.get(...);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
