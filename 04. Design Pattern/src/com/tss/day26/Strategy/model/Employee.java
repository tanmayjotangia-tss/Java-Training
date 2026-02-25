package com.tss.day26.Strategy.model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private Role role;


    public Employee(int id, String name, String department, Role role) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
    }

    public void changeRole(Role newRole){
        System.out.println(name + " is changing role from " + role.getClass().getSimpleName() + " to " + newRole.getClass().getSimpleName());
        this.role = newRole;
    }

    public void showResponsibility(){
        System.out.println(name + "'s responsibilities are:\n" + role.getDescription());
    }
}
