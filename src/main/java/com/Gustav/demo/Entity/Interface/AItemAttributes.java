package com.Gustav.demo.Entity.Interface;

public abstract class AItemAttributes implements IItems {
    private int id;
    private int strength;
    private int spirit;
    private int agility;
    private int health;

    public AItemAttributes(int strength, int spirit, int agility, int health) {
        this.strength = strength;
        this.spirit = spirit;
        this.agility = agility;
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
