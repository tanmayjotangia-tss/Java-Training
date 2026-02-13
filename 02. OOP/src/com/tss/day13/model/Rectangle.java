package com.tss.day13.model;

public class Rectangle extends Shape {
    private int length,breath;

    public Rectangle(int length, int breath){
        this.length=length;
        this.breath=breath;
    }

    public void area(){
        System.out.println("Area of Rectangle: " + (length*breath));
    }

}

