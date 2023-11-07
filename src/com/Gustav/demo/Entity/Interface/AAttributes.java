package com.Gustav.demo.Entity.Interface;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public abstract class AAttributes implements ICombat {

    private int strength;
    private int spirit;
    private int agility;
    private int damage;
    private int health;
    private int experience;
    private int level;
    private int gold;

    public AAttributes(int strength, int spirit, int agility, int health,
                       int experience, int level, int damage,int gold)
    {
        this.strength = strength;
        this.spirit = spirit;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.damage = damage;

        this.gold = gold;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void levelUp(AAttributes attacker) {

        if (attacker.getExperience() >= 100) {

            attacker.setLevel(attacker.getLevel() + 1);
            attacker.setAgility(attacker.getAgility() + 2);
            attacker.setSpirit(attacker.getSpirit() + 2);
            attacker.setStrength(attacker.getStrength() + 2);
            println(BLUE_BOLD + "You reached level: " + attacker.getLevel() + RESET);
            attacker.setExperience(0);
        }


    }

    public void getStatus(AAttributes attacker) {

        println(attacker.getName());
        println(GREEN +"HP: " +  health + RESET);
        println(BLUE +"Level: " +  level + RESET);
        println(RED + "Damage: " + damage + RESET);
        println(YELLOW + "Gold: " +  gold + RESET);
        println(PURPLE + "Spirit: " + spirit + RESET);
        println(BLACK + "Strength " +  strength + RESET);
        println(CYAN + "Agility: " + agility + RESET);


    }

    public void calculateDamage(AAttributes attacker) {

        int damage = attacker.getDamage();
        int maxIncrease = attacker.getStrength();


        if (attacker.getStrength() >= 10) {
            while (attacker.getStrength() % 2 == 0 && damage < maxIncrease) {
                damage += 10;
                attacker.setDamage(damage);
                attacker.setDamage(getDamage()-10);

            }
        }
    }

    public void calculateHealthReg(AAttributes attacker){
        switch (attacker.getSpirit()){
            case 20,21,22,23,24,25,26,27,28,29 ->{
                attacker.setHealth(attacker.getHealth() + 2);
                println(attacker.getName() + YELLOW +  " regenerated 2 hp " + RESET);

            }
            case 30,32,33,34,35,36,37,38,39 ->{
                attacker.setHealth(attacker.getHealth() + 4);
                println(attacker.getName() + YELLOW +  " regenerated 4 hp " + RESET);
            }
            case 40,41,42,43,44,45,46,47,48,49 ->{
                attacker.setHealth(attacker.getHealth() + 6);
                println(attacker.getName() + YELLOW +  " regenerated 6 hp " + RESET);
            }
            case 50,51,52,53,54,55,56,57,58,59 ->{
                attacker.setHealth(attacker.getHealth() + 8);
                println(attacker.getName() + YELLOW +  " regenerated 8 hp " + RESET);
            }
            case 60,61,62,63,64,66,67,68,69 ->{
                attacker.setHealth(attacker.getHealth() + 10);
                println(attacker.getName() + YELLOW +  " regenerated 10 hp " + RESET);
            }
            case 70 ->{
                attacker.setHealth(attacker.getHealth() + 20);
                println(attacker.getName() + YELLOW +  " regenerated 20 hp " + RESET);

            }

        }
    }
    public void setSpiritCap(AAttributes attacker){

        if (attacker.getSpirit() >= 70){
            attacker.setSpirit(70);

        }

    }
}



