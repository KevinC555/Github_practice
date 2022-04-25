package com.revature.Week3.Day1.Exercises;

import java.util.LinkedList;
public class Exercise5 {
    public static void main(String[] args) {

        LinkedList <String> l_list = new LinkedList <String> ();

        l_list.add("Pink");
        l_list.add("Blue");
        l_list.add("Maroon");
        l_list.add("Black");
        l_list.add("Green");

        System.out.println("Original linked list: " + l_list);
        System.out.println("Adding the color Orange after the color Pink " + l_list);
        l_list.add(1, "Orange");

        System.out.println("The linked list:" + l_list);
    }
}