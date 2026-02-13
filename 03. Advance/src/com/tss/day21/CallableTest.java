package com.tss.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {
    static void main() throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int number = i;
            tasks.add(() -> {
//                Thread.sleep(5000);
                return number * number;
            });
        }

        List<Callable<String>> tasks2 = Arrays.asList(
                () -> "Task 1",
                () -> "Task 2",
                () -> "Task 3"
        );

        List<Future<Integer>> results = executor.invokeAll(tasks);

        List<Integer> processedResults = new ArrayList<>();
        for (Future<Integer> future : results) {
            processedResults.add(future.get());
        }

        System.out.println("Processed Results: " + processedResults);

        String results2 = executor.invokeAny(tasks2);
        System.out.println(results2);

        executor.shutdown();
    }
}
