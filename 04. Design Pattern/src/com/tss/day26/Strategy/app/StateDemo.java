package com.tss.day26.Strategy.app;

import com.tss.day26.Strategy.model.*;
import com.tss.utils.InputUtil;

public class StateDemo {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Tanmay", "Software Development", new JuniorDeveloper());
        employee1.showResponsibility();

        roleChanger(employee1);
        employee1.showResponsibility();
    }

    private static void changeRoleMenu(){
        System.out.println("-----Available roles----");
        System.out.println("1. Junior Developer");
        System.out.println("2. Tester");
        System.out.println("3. Senior Developer");
    }

    private static void roleChanger(Employee employee){
        StateDemo.changeRoleMenu();
        int choice = InputUtil.readInt("Enter choice: ");
        switch (choice){
            case 1 -> employee.changeRole(new JuniorDeveloper());
            case 2 -> employee.changeRole(new Tester());
            case 3 -> employee.changeRole(new SeniorDeveloper());
            default -> System.out.println("Invalid choice!");
        }
    }
}
