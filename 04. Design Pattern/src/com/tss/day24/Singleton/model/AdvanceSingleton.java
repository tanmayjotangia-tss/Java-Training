package com.tss.day24.Singleton.model;

public class AdvanceSingleton {
    private AdvanceSingleton(){};

    private static class SingletonInstance{
        private static final AdvanceSingleton INSTANCE = new AdvanceSingleton();
    }

    public static AdvanceSingleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}
