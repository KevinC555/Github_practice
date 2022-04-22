package com.revature.Week2.Day2.Exercises;

public class Exercise4 {
    public static void main (String args[])throws Exception {
        int n = 100, result = 0;
        try {
            result = n/0;
            System.out.println(result);
        } catch(ArithmeticException e) {
            System.out.println (e);
            try {
                throw new NumberFormatException();
            } catch(NumberFormatException ex) {
                System.out.println (ex);
            }
        }
    }
}
