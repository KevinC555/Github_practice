package com.revature.Week3.Day1.Exercises.HashSet;


import java.util.HashSet;
import java.util.Iterator;
public class Exercise2 {
    public static void main(String[] args) {

        HashSet<String> names = new HashSet<String>();

        names.add("Mark");
        names.add("Thomas");
        names.add("George");

        Iterator<String> p = names.iterator();

        while (p.hasNext()) {
            System.out.println(p.next());
        }
    }
}
