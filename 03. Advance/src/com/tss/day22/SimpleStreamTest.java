package com.tss.day22;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleStreamTest {
    static void main() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);

//        numbers.stream()
//                .filter(number -> number%2==0)
//                .map(number -> number*number)
//                .forEach(System.out::println);


//        numbers.stream()
//                .map(number -> number % 2 == 0 ? number * number : number)
//                .sorted(Comparator.reverseOrder())
//                .limit(8)
//                .peek(number -> System.out.println(number))
//                .count();

        numbers.stream()
                .peek(n-> {
                    System.out.println("Before filter " + n);
                })
                .filter(n -> n %1 == 0)
                .peek(n -> {
                    System.out.println("Before map: " + n);
                })
//                .map(n->n%1==0? n:n)
                .map(n -> n % 2 == 0 ? n * n : n)
                .peek(n -> {
                    System.out.println("Before For Each: " + n);
                })
//                .sorted(Comparator.reverseOrder())
//                .limit(8)
//                .peek(System.out::println)
                .forEach(System.out::println);
//                .count();
//                .toArray();

//                .forEach(n->{});
//
//        int finalSum = numbers.stream()
//                .reduce(5,Integer::sum);
//        System.out.println(finalSum);
//
//        boolean numberGreaterThan10 = numbers.stream()
//                .anyMatch(number -> number >10);
//
//        boolean allGreaterThan20 = numbers.stream()
//                .allMatch(number -> number > 20);
//
//        boolean noneGreaterThan20 = numbers.stream()
//                .noneMatch(number -> number > 20);
//
//        System.out.println("Number greater than 10 present: "+numberGreaterThan10);
//        System.out.println("All numbers greater than 20: "+allGreaterThan20);
//        System.out.println("None greater than 20: "+noneGreaterThan20);
    }
}
