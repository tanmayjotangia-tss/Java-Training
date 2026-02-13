package com.tss.day24.Prototype.model;

public class Villager extends Mob{

    public Villager(){
        super("Villager",50,0,new Weapon("No weapon", 0));
    }

    public Villager(Villager villager){
        super(villager);
    }

    @Override
    public Mob clone() {
        return new Villager(this);
    }
}
