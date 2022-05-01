package com.revature.Week3.Day3.Exercises;

import java.io.File;
import java.io.IOException;
public class Exercise1 {
    public static void main(String args[]) throws IOException {

        File directoryPath = new File("C:\\Java-FSD-Revature-4\\class1\\src\\com\\revature\\Week3\\Day3");

        String contents[] = directoryPath.list();
        System.out.println("List of files and directories in the specified directory:");
        for(int i=0; i<contents.length; i++) {
            System.out.println(contents[i]);
        }
    }
}

