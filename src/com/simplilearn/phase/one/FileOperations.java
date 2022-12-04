package com.simplilearn.phase.one;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileOperations {

    public static void addFile(){
        String fileName = "";
        Scanner input;
        try{
            input = new Scanner(System.in);
            System.out.println("Please enter the file Name");
            fileName = input.nextLine();
            File myFile = new File("C:\\demo\\"+fileName+".txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName()+"\nClick enter to proceed");
                        input.nextLine();
            } else {
                System.out.println("File already exists.\nClick enter to proceed");
                input.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            input = null;
        }
    }
    public static void deleteFile(){
        String inputFile = "";
        Scanner input;
        try{
            input = new Scanner(System.in);
            System.out.println("Enter file name to be deleted");
            inputFile = input.nextLine()+".txt";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        boolean ifExists = searchFile(inputFile);
        if(ifExists){
            File myFile = new File("C:\\demo\\"+inputFile);
            if (myFile.delete()) {
                System.out.println("File deleted successfully. \nClick enter to proceed");
                input.nextLine();
            }
            else {
                System.out.println("Failed to delete the file. \nClick enter to proceed");
                input.nextLine();
            }
        }else{
            System.out.println("File doesnot exist. \nClick enter to proceed");
            input.nextLine();
        }
        input = null;
    }
    public static void searchFile(){
       String inputFile = "";
       boolean flag = true;
       Scanner input;
       try{
           input = new Scanner(System.in);
            System.out.println("Enter file name to search");
            inputFile = input.nextLine()+".txt";
             flag = !searchFile(inputFile);
            } catch (Exception e) {
           throw new RuntimeException(e);
       }

        if (flag) {
            System.out.println("File Not Found. Click enter to proceed");
            input.nextLine();
        }else{
            System.out.println(inputFile + " found. Click enter to proceed");
            input.nextLine();
        }
        input = null;

    }public static boolean searchFile(String name){
        boolean flag = true;
        try {
            File directory = new File("C:\\demo\\");
            String[] fileList = directory.list();
            if (fileList == null) {
                return false;
            } else {
                for (String file : fileList) {
                    if (file.equalsIgnoreCase(name)) {
                        flag = false;
                        break;
                    }
                }
            }
        }catch (Exception ex){
            System.out.println("Some error occurred. Please try again");
        }
        return !flag;
    }
}
