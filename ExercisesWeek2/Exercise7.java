package com.revature.Week2.Day2.Exercises;

public class Exercise7 {
    public static void main(String[] args) {
        try {
            Test test1 = new Test();
            Test test2 = new Test();
            Test test3 = new Test();
        } catch (NoMoreException ex) {
            System.out.println(ex);
        }
    }
}
