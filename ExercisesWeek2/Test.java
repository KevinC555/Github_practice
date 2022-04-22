package com.revature.Week2.Day2.Exercises;

public class Test {
    static int count = 0;
    Test() throws NoMoreException{
        if (count == 0) {
            count++;
        }else {
            throw new NoMoreException();
        }
    }
}
