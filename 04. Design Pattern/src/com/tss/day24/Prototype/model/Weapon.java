package com.tss.day24.Prototype.model;

public class Weapon {
    private String type;
    private int damage;

    public Weapon(String type, int damage) {
        this.type = type;
        this.damage = damage;
    }

    public Weapon(Weapon weapon) {
        this.type = weapon.type;
        this.damage = weapon.damage;
    }

    public void upgrade(int extraDamage) {
        this.damage += extraDamage;
    }

    public String toString() {
        return type + " (Damage: " + damage + ")";
    }
}
