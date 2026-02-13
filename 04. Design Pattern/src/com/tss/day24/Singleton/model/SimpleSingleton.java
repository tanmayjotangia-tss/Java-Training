package com.tss.day24.Singleton.model;

public class SimpleSingleton {
    private static SimpleSingleton instance;

    private SimpleSingleton(){};

    public static SimpleSingleton getInstance(){
        if(instance==null){
            instance = new SimpleSingleton();
        }
        return instance;
    }
}
