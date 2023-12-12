package com.Gustav.demo.Entity.Interface;

public abstract class ARelics implements IItems {
    private int relicHealth;
    private int relicAgility;
    private int relicSpirit;
    private int relicStrength;

    public ARelics(int relicHealth, int relicAgility, int relicSpirit, int relicStrength) {
        this.relicHealth = relicHealth;
        this.relicAgility = relicAgility;
        this.relicSpirit = relicSpirit;
        this.relicStrength = relicStrength;
    }

    public int getRelicHealth() {
        return relicHealth;
    }

    public void setRelicHealth(int relicHealth) {
        this.relicHealth = relicHealth;
    }

    public int getRelicAgility() {
        return relicAgility;
    }

    public void setRelicAgility(int relicAgility) {
        this.relicAgility = relicAgility;
    }

    public int getRelicSpirit() {
        return relicSpirit;
    }

    public void setRelicSpirit(int relicSpirit) {
        this.relicSpirit = relicSpirit;
    }

    public int getRelicStrength() {
        return relicStrength;
    }

    public void setRelicStrength(int relicStrength) {
        this.relicStrength = relicStrength;
    }

}