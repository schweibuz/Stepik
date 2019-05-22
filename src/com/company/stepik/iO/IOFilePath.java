package com.company.stepik.iO;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

class IOFilePath {
    public static void main(String[] args) {

//        File file = new FileReader();

        files();

    }

    static public void files() {
        File usrbin = new File("/users/andmat/downloads");
        System.out.println("exists: " + usrbin.exists());
        System.out.println("isFile: " + usrbin.isFile());
        System.out.println("isDirectory: " + usrbin.isDirectory());

        System.out.println(Arrays.toString(usrbin.list()));
        System.out.println(Arrays.toString(usrbin.listFiles()));

        System.out.println(usrbin.getParentFile());
        System.out.println(usrbin.getName());

        File dir = new File("/users/andmat/downloads/a/b/c/d");
//        boolean success =
        dir.mkdirs();

        Path path = Paths.get("/users/andmat/downloads/a");
        File fromPath = path.toFile();
        System.out.println(path.getName(0));
        System.out.println("Files exists: " + Files.exists(path));

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(path)) {
            for (Path child : dirStream) {
                System.out.println("child: " + child);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path dir2 = Paths.get("/users/andmat/downloads/e/v/s/n/l/k");
        Path dier = Paths.get("asdfasdf");
        try {
//            Files.createDirectory();      //mkdir
            Files.createDirectories(dir2);      //mkdirs

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}