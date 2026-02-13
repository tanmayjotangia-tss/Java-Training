package com.tss.day21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutorTest {
    static void main() {
        ExecutorService threadService = Executors.newFixedThreadPool(2);


        threadService.submit(() -> {
            System.out.println("Hello 1!!");
        });

        threadService.submit(() -> {
            System.out.println("Hello 2!!");
        });


        threadService.submit(() -> {
            System.out.println("Hello 3!!");
        });



        threadService.submit(() -> {
            System.out.println("Hello 4!!");
        });


        threadService.submit(() -> {
            System.out.println("Hello 5!!");
        });



        threadService.submit(() -> {
            System.out.println("Hello 6!!");
        });



        threadService.submit(() -> {
            System.out.println("Hello 7!!");
        });


        threadService.submit(() -> {
            System.out.println("Hello 8!!");
        });

        threadService.shutdown();
    }
}
