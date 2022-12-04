package com.simplilearn.phase.one;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Welcome {
    public static void main(String[] args) {
        File theDir = new File("C:\\demo");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        mainScreen();
    }
    public static void mainScreen(){
        System.out.println("Welcome to Repsitory Management by Sourav Gupta");
        System.out.println("Please select on of below options");
        System.out.println("1. Add File");
        System.out.println("2. Delete a File");
        System.out.println("3. Search a File");
        System.out.println("4. Exit Application");
        Scanner input = null;
        try{
            input = new Scanner(System.in);
            int option = input.nextInt();
            switch (option){
                case 1:
                    FileOperations.addFile();
                    break;
                case 2:
                    FileOperations.deleteFile();
                     break;
                case 3:
                    FileOperations.searchFile();
                   break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid input");
                    mainScreen();
                    break;
            }
        }catch (NoSuchElementException ex){
            System.out.println("Please enter a Numerical input");
            mainScreen();
        }catch(Exception ex) {
            System.out.println("Invalid Input" + ex);
            mainScreen();
        }finally{
            input = null;
            subScreen();
        }
    }

    public static void subScreen(){
        System.out.println("Please select on of below options");
        System.out.println("1. Add a new File");
        System.out.println("2. Delete a File");
        System.out.println("3. Search a File");
        System.out.println("4. Return to Main Screen");
        Scanner inputSub = null;
        try{
            inputSub = new Scanner(System.in);
            int option = inputSub.nextInt();
            switch (option){
                case 1:
                    FileOperations.addFile();
                    break;
                case 2:
                    FileOperations.deleteFile();
                    break;
                case 3:
                    FileOperations.searchFile();
                    break;
                case 4:
                    inputSub = null;
                    mainScreen();
                    break;
                default:
                    System.out.println("Please select a valid input");
                   break;
            }
        }catch (NoSuchElementException ex){
            System.out.println("Please enter a Numerical input");
            subScreen();
        }catch(Exception ex){
            System.out.println("Invalid Input"+ex);
            subScreen();
        }finally{
            subScreen();
        }

    }
}
