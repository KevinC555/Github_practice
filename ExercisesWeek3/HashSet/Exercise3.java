package com.revature.Week3.Day1.Exercises.HashSet;

import java.util.HashSet;
import java.util.Iterator;
public class Exercise3 {
    public static void main(String[] args) {

        HashSet<String> names = new HashSet<String>();

        names.add("Mark");
        names.add("Thomas");
        names.add("George");

        System.out.println("Original: " + names);
        System.out.println("Hash Set Size is: " + names.size());
    }
}
