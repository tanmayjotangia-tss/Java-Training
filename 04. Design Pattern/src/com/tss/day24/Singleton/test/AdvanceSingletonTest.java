package com.tss.day24.Singleton.test;

import com.tss.day24.Singleton.model.AdvanceSingleton;

public class AdvanceSingletonTest {
    static void main() {
        AdvanceSingleton as1 = AdvanceSingleton.getInstance();
        AdvanceSingleton as2 = AdvanceSingleton.getInstance();
        AdvanceSingleton as3 = AdvanceSingleton.getInstance();
        AdvanceSingleton as4 = AdvanceSingleton.getInstance();

        System.out.println(as1);
        System.out.println(as2);
        System.out.println(as3);
        System.out.println(as4);
    }
}
