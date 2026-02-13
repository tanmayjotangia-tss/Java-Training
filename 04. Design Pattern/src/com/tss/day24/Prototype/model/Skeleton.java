package com.tss.day24.Prototype.model;

public class Skeleton extends Mob {

    public Skeleton(){
        super("Skeleton", 80,45,new Weapon("Shoots Arrow",45));
    }

    public Skeleton(Skeleton skeleton){
        super(skeleton);
    }

    @Override
    public Mob clone() {
        return new Skeleton(this);
    }
}
