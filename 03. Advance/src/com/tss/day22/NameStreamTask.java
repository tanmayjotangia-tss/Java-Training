package com.tss.day22;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class NameStreamTask {
    static void main() {
        String[] names = {"Jayesh", "Nimesh", "Mark", "Mahesh", "Ramesh"};

        Stream<String> nameStream = Arrays.stream(names);

        System.out.println("First 3 Students in Ascending order");
        Arrays.stream(names)
                .sorted()
                .limit(3)
                .forEach(System.out::println);


        System.out.println("First 3 students in Ascending order with name containing a");
        Arrays.stream(names)
                .filter(name -> name.contains("a"))
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("Students in reverse order");
//        List<String> list = Arrays.asList(names);
//        Collections.reverse(list);
//        list.forEach(System.out::println);

        Arrays.stream(names)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("First 3 characters of all name");
        Arrays.stream(names)
                .map(name -> name.substring(0,3))
                .forEach(System.out::println);

        System.out.println("Name of Students that contain less than or equal to 4 characters");
        Arrays.stream(names)
                .filter(name -> name.length() <= 4)
                .forEach(System.out::println);

    }
}
