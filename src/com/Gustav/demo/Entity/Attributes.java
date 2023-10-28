package com.Gustav.demo.Entity;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.MessageHandler.*;

public abstract class Attributes implements Combat {

   private int strength;
   private int intelligence;
   private int agility;
   private int health;
   private int experience;
   private int level;
   private int baseDamage;
   private int magicDamage;


   public Attributes(int strength, int intelligence, int agility, int health, int experience, int level, int baseDamage
   , int magicDamage)
    {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
        this.magicDamage = magicDamage;
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


    public int getBaseDamage() {
        return baseDamage;
    }


    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }


    public void levelUp(Attributes attacker){

       attacker.setExperience(attacker.getExperience() + 100);

       if (attacker.getExperience() == 100) {

           attacker.setLevel(attacker.getLevel() + 1);
           println(attacker.getName() + YELLOW + " gained 100 xp" + RESET);
           println(BLUE_BOLD + "You reached level: " + attacker.getLevel() + RESET);
       }


    }

    void act(){



    }

    void getStatus(){

        println("Strength "     + strength);
        println("Intelligence " + intelligence);
        println("Agility: "     + agility);
        println("Experience: "  + experience);
        println("Level: "       + level);
        println("Base damage: " + baseDamage);
    }



    void calculateDamage(){

    }


    void didDoge(){



    }



}
