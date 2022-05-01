package com.revature.Week3.Day3.Exercises;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Exercise8 {
    public static void main(String [ ] args) throws FileNotFoundException {
        new Exercise8().findLongestWords();
    }

    public String findLongestWords() throws FileNotFoundException {

        String longest_word = "";
        String current;
        Scanner sc = new Scanner(new File("C:\\Java-FSD-Revature-4\\class1\\src\\com\\revature\\Week3\\Day3\\Demo1.java"));


        while (sc.hasNext()) {
            current = sc.next();
            if (current.length() > longest_word.length()) {
                longest_word = current;
            }

        }
        System.out.println("\n"+longest_word+"\n");
        return longest_word;
    }
}
