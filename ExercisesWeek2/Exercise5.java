package com.revature.Week2.Day2.Exercises;

public class Exercise5 {
    public static void main(String[] args) {
        Animal dog = null;

        try {
            dog = new Animal("I am a dog", -5);
        } catch (AgeAnimalException ex) {
            ex.printStackTrace();
        }
    }
}


