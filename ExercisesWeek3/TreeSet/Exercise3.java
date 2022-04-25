package com.revature.Week3.Day1.Exercises.TreeSet;

import java.util.TreeSet;
public class Exercise3 {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<String>();
        names.add("Mark");
        names.add("Bob");
        names.add("John");

        System.out.println("Names: "+names);

        TreeSet<String> newNames = new TreeSet<String>();
        newNames.add("William");
        newNames.add("Jonah");
        newNames.add("Kyle");
        System.out.println("New names: "+newNames);

        names.addAll(newNames);
        System.out.println("Names: "+names);
    }
}

