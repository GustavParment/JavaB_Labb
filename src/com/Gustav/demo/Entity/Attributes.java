package com.Gustav.demo.Entity;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public abstract class Attributes implements Combat {

   private int strength;
   private int intelligence;
   private int agility;
   private int damage;
   private int magicDamage;
   private int health;
   private int experience;
   private int level;
   private int gold;

   public Attributes(int strength, int intelligence, int agility, int health,
                     int experience, int level, int damage, int magicDamage, int gold)
    {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.damage = damage;
        this.magicDamage = magicDamage;
        this.gold = gold;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(int magicDamage) {
        this.magicDamage = magicDamage;
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

    public void levelUp(Attributes attacker){

       if (attacker.getExperience() >= 100) {

           attacker.setLevel(attacker.getLevel() + 1);
           attacker.setGold(attacker.getGold() + 5);
           println(BLUE_BOLD + "You reached level: " + attacker.getLevel() + RESET);
           attacker.setExperience(0);
       }


    }

    void getStatus(Attributes attacker){

        println(attacker.getName());
        println("HP: " + GREEN + health + RESET);
        println("Level: " + BLUE + level + RESET);
        println("Damage: " + RED + damage + RESET );
        println("Magical Damage: " + RED + magicDamage+ RESET );
        println("Gold: " + YELLOW + gold + RESET);
        println("Strength " + BLACK +  strength + RESET );
        println("Intelligence " + PURPLE + intelligence + RESET);
        println("Agility: "     + CYAN +  agility + RESET);


    }


    void calculateDamage(Attributes attacker){

       int damage = attacker.getDamage();
       int magicalDamage = attacker.getMagicDamage();

       if (attacker.getIntelligence() > 10 && attacker.getIntelligence() % 10 == 0){

            magicalDamage += 5;

            attacker.setMagicDamage(magicalDamage);

        }
       if (attacker.getStrength() > 10 && attacker.getStrength() % 10 == 0){

            damage += 5;

            attacker.setDamage(damage);
        }

    }


}
