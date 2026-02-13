package com.tss.day24.Prototype.model;

import java.util.HashMap;
import java.util.Map;

public class MobRegistry {
    private static final Map<String,Mob> mobPrototypes = new HashMap<>();


    static {
        mobPrototypes.put("zombie", new Zombie());
        mobPrototypes.put("skeleton", new Skeleton());
        mobPrototypes.put("creeper", new Creeper());
        mobPrototypes.put("villager",new Villager());
    }

    public static Mob spawnMob(String type){
        Mob prototype = mobPrototypes.get(type.toLowerCase());

        if(prototype == null){
            throw new IllegalArgumentException("Unknow Mob type");
        }
        return prototype.clone();
    }
}
