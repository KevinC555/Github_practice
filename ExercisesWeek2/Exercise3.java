package com.revature.Week2.Day2.Exercises;

public class Exercise3 {
    static void ageChecker(int age) throws ArithmeticException {

        if (age < 18) {
            throw new ArithmeticException("Access denied, you are under the age of 18.");
        } else {
            System.out.println("You can enter, you are old enough");
        }
    }

    public static void main(String[] args) {
        ageChecker(15);
    }
}

