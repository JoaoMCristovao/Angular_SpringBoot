package com.fibonacci.fibonacci.fibonacci;

public class ResultCalculator {
    public static int Calculate(int index){
        if(index < 0){
            System.err.println("Invalid index");
            return -1;
        }

        int value = 1, prev = 1, prevprev = 0;

        for(int i = 0; i < index; i ++){
            value = prev + prevprev;

            prevprev = prev;

            prev = value;
        }

        return value;
    }
}
