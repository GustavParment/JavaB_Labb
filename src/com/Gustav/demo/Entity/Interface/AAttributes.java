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
                       int experience, int level, int damage,int gold) {
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
        println("HP: " + GREEN + health + RESET);
        println("Level: " + BLUE + level + RESET);
        println("Damage: " + RED + damage + RESET);
        println("Gold: " + YELLOW + gold + RESET);
        println("Spirit: " + PURPLE + spirit + RESET);
        println("Strength " + BLACK + strength + RESET);
        println("Agility: " + CYAN + agility + RESET);


    }


    public void calculateDamage(AAttributes attacker) {

        int damage = attacker.getDamage();
        int maxIncrease = attacker.getStrength();


        if (attacker.getStrength() >= 10) {
            while (attacker.getStrength() % 2 == 0 && damage < maxIncrease) {
                damage += 10;
                attacker.setDamage(damage);
                attacker.setDamage(getDamage()-10);
                System.out.println("CALC:"+ damage);



            }
        }



    }


    public void calculateHealthReg(AAttributes attacker){

        int health = attacker.getHealth();
        int maxIncrease = attacker.getSpirit();

        if (attacker.getSpirit() >= 10 ){
            while (attacker.getSpirit() % 10 == 0 && health < maxIncrease ){

                health += 2;


                attacker.setHealth(health);
                attacker.setHealth(attacker.getHealth() - 10);



            }

            System.out.println("NEW HEALTH: " + attacker.getHealth());
        }



    }
}


