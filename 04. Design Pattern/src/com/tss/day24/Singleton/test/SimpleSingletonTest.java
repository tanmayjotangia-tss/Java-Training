package com.tss.day24.Singleton.test;

import com.tss.day24.Singleton.model.SimpleSingleton;

public class SimpleSingletonTest {
    static void main() {

        SimpleSingleton s1 = SimpleSingleton.getInstance();
        SimpleSingleton s2 = SimpleSingleton.getInstance();
        SimpleSingleton s3 = SimpleSingleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
