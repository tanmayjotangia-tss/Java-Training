package com.tss.day24.Prototype.model;

public abstract class Mob implements Prototype<Mob> {
    private String name;
    private int health;
    private int attackDamage;

    //Deep Copy
    private Weapon weapon;

    protected Mob(String mobName,int health,int attackDamage,Weapon weapon){
        this.name = mobName;
        this.health =health;
        this.attackDamage=attackDamage;
        this.weapon = weapon;
    }

    protected Mob(Mob mob){
        this.name = mob.name;
        this.health = mob.health;
        this.attackDamage = mob.attackDamage;

        //Deep Copy due to mutable object
        this.weapon = new Weapon(mob.weapon);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
    public void showStats() {
        String weaponInfo = (weapon != null) ? weapon.toString() : "No Weapon";
        System.out.println(
                name + " | HP: " + health +
                        " | ATK: " + attackDamage +
                        " | Weapon: " + weaponInfo
        );
    }


    @Override
    public abstract Mob clone();
}
