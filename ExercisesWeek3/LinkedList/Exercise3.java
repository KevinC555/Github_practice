package com.revature.Week3.Day1.Exercises.LinkedList;

import java.util.LinkedList;
import java.util.Iterator;
public class Exercise3 {
    public static void main(String[] args) {

        LinkedList<String> l_list = new LinkedList<String>();

        l_list.add("Monday");
        l_list.add("Tuesday");
        l_list.add("Wednesday");
        l_list.add("Thursday");
        l_list.add("Friday");
// set Iterator at specified index
        Iterator p = l_list.listIterator(0);

        // print list from second position
        while (p.hasNext()) {
            System.out.println(p.next());
        }
    }
}