package com.revature.Week3.Day1.Exercises.HashSet;

import java.util.HashSet;

public class Exercise4 {
    public static void main(String[] args) {

        HashSet<String> names = new HashSet<String>();

        names.add("Paul");
        names.add("John");
        names.add("Mark");

        System.out.println("Original: " + names);

        names.removeAll(names);
        System.out.println("After removing: "+names);
    }
}
