package com.revature.Week3.Day1.Exercises.TreeSet;

import java.util.TreeSet;
public class Exercise2 {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<String>();
        names.add("Mark");
        names.add("John");
        names.add("Bob");
        names.add("Smith");

        for (String element : names) {
            System.out.println(element);
        }
    }
}

