package com.tss.day24.Prototype.test;

import com.tss.day24.Prototype.model.*;

public class MinecraftMobTest {
    static void main() {

        System.out.println("Creating Zombie clone from Registry");
        Mob zombie1 = MobRegistry.spawnMob("zombie");
        zombie1.takeDamage(20);
        zombie1.showStats();

        System.out.println("Creating Zombie clone from Registry");
        Mob zombie2 = MobRegistry.spawnMob("zombie");
        zombie2.showStats();

        System.out.println("Creating Zombie clone from particular Zombie");
        Mob zombie3 = zombie1.clone();
        zombie3.takeDamage(40);
        zombie3.showStats();
        zombie1.showStats();

        System.out.println("Creating Creeper clone from Registry");
        Mob crepper1 = MobRegistry.spawnMob("creeper");
//        crepper1.takeDamage(20);
        crepper1.showStats();

        System.out.println("Creating Creeper shallow copy. ");
        Mob creeper2 = MobRegistry.spawnMob("creeper");
        creeper2.takeDamage(20);
        creeper2.showStats();
        crepper1.showStats();

        System.out.println("Creating Villager object directly from Registry using DownCasting");
        Villager villager1 = (Villager) MobRegistry.spawnMob("villager");
        villager1.showStats();

        System.out.println("Creating Mob object using existing villager clone");
        Mob skeleton2 = villager1.clone();
        skeleton2.showStats();

        System.out.println("Creating Skeleton object using villager object clone while applying down casting");
        Skeleton skeleton1 = (Skeleton) villager1.clone();
        skeleton1.showStats();
    }
}
