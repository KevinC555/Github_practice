package com.revature.Week3.Day3.Exercises;

import java.io.File;
public class Exercise3 {
    public static void main(String[] args) {

        File my_file_dir = new File("C:\\Java-FSD-Revature-4\\class1\\src\\com\\revature\\Week3\\Day3\\Demo1.java");
        if (my_file_dir.exists())
        {
            System.out.println("The directory or file exists.\n");
        }
        else
        {
            System.out.println("The directory or file does not exist.\n");
        }
    }
}

