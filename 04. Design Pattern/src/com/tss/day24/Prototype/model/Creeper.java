package com.tss.day24.Prototype.model;

public class Creeper extends Mob{

    public Creeper(){
        super("Creeper", 50,100,new Weapon("Explosive Charge",100));
    }

    public Creeper(Creeper creeper){
        super(creeper);
    }

    //reference alliance
    @Override
    public Mob clone() {
        return this;
    }
}
