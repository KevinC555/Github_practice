package com.revature.Week3.Day1.Exercises;

import java.util.LinkedList;

public class Exercise2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("First");
        list.add("Second");
        System.out.println("Iterating the list using for-loop");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
