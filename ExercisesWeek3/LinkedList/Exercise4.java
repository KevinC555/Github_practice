package com.revature.Week3.Day1.Exercises.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class Exercise4 {
    public static void main(String[] args)
    {
        LinkedList<String> linkedList = new LinkedList<>();

        // adding elements to linked list
        linkedList.add("Blue");
        linkedList.add("Green");
        linkedList.add("Yellow");
        linkedList.add("Orange");
        linkedList.add("Purple");

        Iterator<String> iterator = linkedList.descendingIterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
}