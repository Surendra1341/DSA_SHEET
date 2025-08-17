package com.FileHandling;

import java.io.*;

public class Other_Main {
    public static void main(String[] args) {

        // create file
        try {
            File fo = new File("src/com/FileHandling/new-file.txt");
            fo.createNewFile();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        // write in file
        try (FileWriter fw = new FileWriter("src/com/FileHandling/new-file.txt")) {
            fw.write("hello 123");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try(BufferedReader br=new BufferedReader(new FileReader("src/com/FileHandling/new-file.txt"))){
            while(br.ready()){
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
      }


        //create and delete
        try {
            File fo = new File("src/com/FileHandling/random.txt");
            fo.createNewFile();
            if(fo.delete()){
                System.out.println(fo.getName());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
