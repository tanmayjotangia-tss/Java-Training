package com.tss.day24.Prototype.model;

public class Zombie extends Mob {
    public Zombie(){
        super("Zombie",85,60,new Weapon("Hands",60));
    }

    public Zombie(Zombie zombie){
        super(zombie);
    }

    @Override
    public Mob clone() {
        return new Zombie(this);
    }
}
