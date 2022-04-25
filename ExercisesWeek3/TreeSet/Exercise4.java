package com.revature.Week3.Day1.Exercises.TreeSet;

import java.util.TreeSet;
import java.util.Iterator;

public class Exercise4 {
    public static void main(String[] args) {

        TreeSet<String> names = new TreeSet<String>();

        names.add("John");
        names.add("Mark");
        names.add("Bob");

        System.out.println("Original:" + names);
        Iterator i = names.descendingIterator();

        System.out.println("Reverse Order:");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

