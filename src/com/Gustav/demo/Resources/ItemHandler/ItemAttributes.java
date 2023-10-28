package com.Gustav.demo.Resources.ItemHandler;

public abstract class ItemAttributes {

    private int strength;
    private int intelligence;
    private int agility;
    private int health;

    public ItemAttributes(int strength, int intelligence, int agility, int health) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
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
}
