package com.revature.Week2.Day2.Exercises;

public class Exercise6 {
    public static void main(String[] args) {
        Student person = null;

        try {
            person = new Student("I am a student", -1);
        } catch (StudentRecordException ex) {
            ex.printStackTrace();
        }
    }
}
