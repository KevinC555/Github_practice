package com.revature.Week2.Day2.Exercises;

public class Student {
    private String name;
    private int record;

    public Student(String name, int record) throws StudentRecordException {
        if (record < 0) {
            throw new StudentRecordException("Student cannot have a negative record: " + record);
        } else {
            this.name = name;
            this.record = record;
            System.out.println("You create a student record");
        }
    }
}