package com.tss.day39.task.entity;

public class Student {

    private int enrollNumber;
    private String name;
    private int age;
    private Address address;

    public Student(int enrollNumber, String name, int age, Address address) {
        this.enrollNumber = enrollNumber;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getEnrollNumber() {
        return enrollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrollNumber=" + enrollNumber +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}