package com.tss.day25.Facade.controller;

import com.tss.day25.Facade.service.LuggageService;
import com.tss.day25.Facade.service.RestaurantService;
import com.tss.day25.Facade.service.RoomService;
import com.tss.utils.InputUtil;

public class Reception {

    private static void displayMenu(){
        System.out.println("\nWelcome to Reception");
        System.out.println("Which service do you want to take ?");
        System.out.println("1. Check IN");
        System.out.println("2. Take meal");
        System.out.println("3. Room Cleaning");
        System.out.println("4. Check OUT");
    }
    public static void contactReception(){

    while(true){
        displayMenu();
        int choice = InputUtil.readInt("Enter your choice: ");

        switch (choice){
            case 1 -> {
                LuggageService.pickLuggage();
                System.out.println("Checked In");
            }
            case 2 -> RestaurantService.serveFood();
            case 3 -> RoomService.cleanRoom();
            case 4 -> {
                LuggageService.dropLuggage();
                System.out.println("Checked Out");
                RoomService.cleanRoom();
                return;
            }
            default -> System.out.println("Invalid choice");
        }
    }
    }
}
