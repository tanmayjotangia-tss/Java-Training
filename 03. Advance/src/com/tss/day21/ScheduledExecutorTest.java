package com.tss.day21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {
    static void main() {
        ScheduledExecutorService threadService = Executors.newScheduledThreadPool(2);


        threadService.schedule(() -> {
            System.out.println("Hello 1!!");
        }, 2, TimeUnit.SECONDS);


        threadService.scheduleAtFixedRate(() -> {
            System.out.println("Hello 2!!");
        }, 2,5, TimeUnit.SECONDS);


        threadService.schedule(() -> {
            threadService.shutdown();
            System.out.println("Scheduler shutdown");
        }, 100, TimeUnit.SECONDS);
    }
}
