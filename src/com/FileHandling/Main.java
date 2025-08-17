package com.FileHandling;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //this all one by one acc, to notes so remove comment check
//       try(InputStreamReader isr=new InputStreamReader(System.in)){
//           System.out.println("enter some letter: ");
//           int letter=isr.read();
//           while(isr.ready()){
//               System.out.println((char)letter);
//               letter=isr.read();
//           }
////           isr.close();   automatic close it so don't worry
//           System.out.println();
//       } catch (IOException e) {
//           System.out.println(e.getMessage());
//       }

//        try(FileReader fr=new FileReader("src/com/FileHandling/note.txt")){
//            int letter=fr.read();   // actually read return an int
//            while(fr.ready()){
//                System.out.println((char)letter);   // here we convert int -> char
//                letter=fr.read();
//            }
//              fr.close();  // automatic close it so don't worry
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        //byte to char stream then read char
//        try(BufferedReader br=new BufferedReader(new InputStreamReader(System.in))){
//            System.out.println("you type :"  +br.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try(BufferedReader br=new BufferedReader(new FileReader("src/com/FileHandling/note.txt"))){
//            while(br.ready()){
//                System.out.println(br.readLine());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        //output
        OutputStream os=System.out;
//        os.write(😖);    range is exceeded

        System.out.println();
//        try(OutputStreamWriter osw=new OutputStreamWriter(System.out)){
//            osw.write("hello world ");
//            osw.write(97);
//            osw.write(10);  // 10 is for new line
//            osw.write('A');
//            osw.write('\n');
//            char[] arr="hello world !".toCharArray();
//            osw.write(arr);
////            osw.write(😖);
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


//        try(FileWriter fw=new FileWriter("src/com/FileHandling/note.txt",true) ){
//            // basically true for do you want to append
//            fw.write("hello world  ");  //this will add to original file (append)  if you don't send true
//            // like  FileWriter fw=new FileWriter("src/com/FileHandling/note.txt")  it also
//            // working but it override it remember
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try(BufferedWriter bw=new BufferedWriter(new FileWriter("src/com/FileHandling/note.txt",true)) ){
//
//            bw.write(" hare krishna  ");
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
    }
}
