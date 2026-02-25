package com.tss.day27;

public class ArithmeticOperation {

    public int add(int number1, int number2){
        return number1+number2;
    }

    public int sub(int number1, int number2){
        return number1-number2;
    }

    public int mul(int number1, int number2){
        return number1*number2;
    }

    public double divide(int number1, int number2){
        if(number2 == 0){
            throw new ArithmeticException("Can not divide by zero");
        }
        return (double) number1 /number2;
    }
}
