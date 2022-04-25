package com.revature.Week3.Day1.Exercises.TreeSet;

import java.util.TreeSet;
public class Exercise5 {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<String>();

        names.add("Mark");
        names.add("Derek");
        names.add("Josh");

        System.out.println("Names: ");
        System.out.println(names);


        Object firstName = names.first();
        System.out.println("First Name is: "+firstName);


        Object lastName = names.last();
        System.out.println("Last Name is: "+lastName);
    }
}

