package com.revature.Week2.Day2.Exercises;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) throws AgeAnimalException {
        if (age < 0) {
            throw new AgeAnimalException("Animals cannot have a negative age: " + age);
        } else {
            this.name = name;
            this.age = age;
            System.out.println("You create a doggy");
        }
    }
}