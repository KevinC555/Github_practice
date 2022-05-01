package com.revature.Week3.Day3.Exercises;

import java.io.File;
import java.io.FilenameFilter;
public class Exercise2 {
    public static void main(String a[]){
        File file = new File("C:\\Java-FSD-Revature-4\\class1\\src\\com\\revature\\Week3\\Day3");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.toLowerCase().endsWith(".y3")){
                    return true;
                } else {
                    return false;
                }
            }
        });
        for(String f:list){
            System.out.println(f);
        }
    }
}

