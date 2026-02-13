package com.tss.day24.Abstract_Factory.service;

import com.tss.day24.Abstract_Factory.model.CarFactory;

import java.util.HashMap;
import java.util.Map;

public class FactoryProducer {

    private static Map<String, CarFactory> registry = new HashMap<>();

    public static void registerFactory(String name, CarFactory factory) {
        registry.put(name.toUpperCase(), factory);
    }

    public static CarFactory getFactory(String name) {
        CarFactory factory = registry.get(name.toUpperCase());
        if (factory == null) throw new IllegalArgumentException("Invalid Car Type");
        return factory;
    }
}
