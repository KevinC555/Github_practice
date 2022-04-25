package com.revature.Week3.Day1.Exercises.HashSet;

import java.util.HashSet;
public class Exercise1 {
    public static void main(String[] args) {

        HashSet<String> names = new HashSet<String>();

        names.add("Mark");
        names.add("Paul");
        names.add("Watson");

        System.out.println("The names of my friends are: " + names);
    }
}
