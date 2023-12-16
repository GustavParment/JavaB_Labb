package com.Gustav.demo.Entity.Interface;

import java.util.ArrayList;
import java.util.List;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public abstract class AAttributes implements ICombat {
    private int id;
    private int strength;
    private int spirit;
    private int agility;
    private int damage;
    private int health;
    private int experience;
    private int level;
    private int gold;
    private int damageDone;
    private int totalAttackerDamage = 0;
    private int totalDefenderDamage = 0;

    public int getTotalAttackerDamage() {
        return totalAttackerDamage;
    }

    public void setTotalAttackerDamage(int totalAttackerDamage) {
        this.totalAttackerDamage = totalAttackerDamage;
    }

    public int getTotalDefenderDamage() {
        return totalDefenderDamage;
    }

    public void setTotalDefenderDamage(int totalDefenderDamage) {
        this.totalDefenderDamage = totalDefenderDamage;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }

    public AAttributes(int strength, int spirit,
                       int agility, int health,
                       int experience, int level,
                       int damage, int gold)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        if (attacker.getExperience() >= 100 && attacker.getLevel() != 12) {

            attacker.setLevel(attacker.getLevel() + 1);
            attacker.setAgility(attacker.getAgility() + 2);
            attacker.agilityCap(attacker);
            attacker.setSpirit(attacker.getSpirit() + 2);
            attacker.spiritCap(attacker);
            attacker.setStrength(attacker.getStrength() + 2);
            attacker.strengthCap(attacker);
            println(BLUE_BOLD + "You reached level: " + attacker.getLevel() + RESET);
            attacker.setExperience(0);
        }else{
            levelCap(attacker);
        }


    }

    private void levelCap(AAttributes attacker){
        if (attacker.getLevel() >= 12){
        attacker.setLevel(12);
        println(BLUE_BOLD + "You have reached the max Level 12 and wont benefit form any more attributes then health" + RESET);
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

        cappedStatusMessage(attacker);


    }

    private void cappedStatusMessage(AAttributes attacker) {
        if (attacker.getStrength() == 80){
            println(BLUE_BOLD + "You are capped in Strength and won't benefit from more" +  RESET);
        }
        if (attacker.getSpirit() == 70){
            println(BLUE_BOLD + ("You are capped in Spirit and wont benefit from more") + RESET) ;
        }
        if (attacker.getAgility() == 72){
            println(BLUE_BOLD + "You are capped in Agility and wont benefit from more" + RESET);
        }
        else if(attacker.getAgility() == 72 && attacker.getStrength() == 80 && attacker.getSpirit() == 70){
            println(BLUE_BOLD + "You are capped in all physical stats and wont benefit from more" + RESET);
        }
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
            case 30,31,32,33,34,35,36,37,38,39 ->{
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

    public void spiritCap(AAttributes attacker){
        if (attacker.getSpirit() >= 70) attacker.setSpirit(70);

    }

    public void agilityCap(AAttributes attacker){
        if (attacker.getAgility() >= 72) attacker.setAgility(72);
    }

    public void strengthCap(AAttributes attacker){
        if(attacker.getStrength() >= 80)attacker.setStrength(80);
    }

    public void calcDmgDone(AAttributes attacker, AAttributes defender){


        if (this == attacker) {
             totalAttackerDamage += attacker.getDamage();
            attacker.setTotalAttackerDamage(totalAttackerDamage);
        } else {
            totalDefenderDamage += defender.getDamage();
            defender.setTotalDefenderDamage(totalDefenderDamage);


        }
    }




}






