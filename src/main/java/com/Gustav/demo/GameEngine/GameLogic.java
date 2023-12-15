package com.Gustav.demo.GameEngine;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.Menu.PlayerMenu;
import com.Gustav.demo.GameEngine.Menu.StartMenu;
import com.Gustav.demo.Resources.Paint.Colors;

import java.util.Random;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class GameLogic implements Colors {
    DBConnection db = new DBConnection();



    public void fight(Scanner sc, AAttributes attacker, AAttributes defender) {
        PlayerMenu menu = new PlayerMenu();
        insertMonsterData(defender);
        boolean fightDone = false;


        println(YELLOW + "You Engaged " + defender.getName() + RESET);
        do {
            println("\n1.Attack " + defender.getName());
            println("2.Player Attributes");
            println(PURPLE + "╰┈➤3.Flee the fight" + RED + " and lose 2 hp" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {
                    attack(attacker, defender);

                    if (attacker.getHealth() > 0) {
                        didDodge(attacker, defender);

                    }
                    if (defender.getHealth() <= 0) {
                        fightDone = isFightDone(attacker, defender, false);
                        attacker.levelUp(attacker);
                        updatePlayerData(attacker,defender);
                        db.insertFightHistory(attacker,defender);

                    } else{
                        attack(defender, attacker);


                    }
                    if (defender.getHealth() > 0) {
                        didDodge(defender, attacker);

                    }
                    if (attacker.getHealth() <= 0){
                        fightDone = isFightDone(attacker, defender, false);
                        updatePlayerData(attacker,defender);
                        db.insertFightHistory(attacker,defender);
                    }

                }
                case "2" -> attacker.getStatus(attacker);
                case "3" -> {
                    attacker.flee(attacker);
                    println(YELLOW + "\nNow you have " + attacker.getHealth() + " hp" +  RESET);
                    fightDone = true;
                }
                default -> println(RED + "Wrong input, try again..." + RESET);
            }



        } while (!fightDone);

        System.out.println(attacker.getDamageDone());
        menu.playerOption(attacker, sc);
        

    }

    private boolean isFightDone(AAttributes attacker, AAttributes defender,
                                boolean fightDone) {


        if (defender.getHealth() <= 0) {

            printDelay(YELLOW + "\nCongratulations!" + RESET + " You have slayed "
                    + defender.getName());
            println("\n" + attacker.getName() + YELLOW + " looted " + defender.getGold() + " gold" + RESET);
            println(attacker.getName() + YELLOW + " gained +100 xp" + RESET);
            println(attacker.getName() + YELLOW + " gained +10 Hp" + RESET);
            println(attacker.getName() + YELLOW + " gained +2 in all Attributes" + RESET);

            attacker.setExperience(attacker.getExperience() + 100);
            attacker.setGold(attacker.getGold() + defender.getGold());
            attacker.setHealth(attacker.getHealth() + 10);


            fightDone = true;

            defender = null;

        }
        if (attacker.getHealth() <= 0) {
            StartMenu start = new StartMenu();
            ScoreFile scoreFile = new ScoreFile();


            println(attacker.getName() + " was defeated by "
                    + defender.getName() + RESET);

            println(BLACK + RED_BACKGROUND + "\uD83D\uDC80Game over\uD83D\uDC80" + RESET);
            printDelay(PURPLE_BOLD + "\nThanks for Playing better luck next time summoner...\n"
                    + RESET);
            fightDone = true;
            scoreFile.writeScoreFile(attacker);

            start.options();



        }
        return fightDone;
    }

    private void didDodge(AAttributes attacker, AAttributes defender) {

        if (calculateDodge(attacker, defender)) {

            print(RED + " ❌MISS❌" + RESET);
            println("\n" + defender.getName() + " " + defender.dodge());

            defender.setHealth(defender.getHealth() + attacker.getDamage());

        } else {
            print(GREEN + " HIT FOR " + attacker.getDamage() + " DAMAGE ✔" + RESET);
            println("\n" + defender.getName() + YELLOW_BOLD + " remaining HP: "
                    + defender.getHealth() + RESET);
            chanceOnHealthReg(defender);


        }
    }

    private void attack(AAttributes attacker, AAttributes defender) {
        printDelay(attacker.getName() + " " + attacker.attack());
        attacker.calculateDamage(attacker);

        defender.setHealth(defender.getHealth() - attacker.getDamage());

        attacker.calcDmgDone(attacker,defender);


        System.out.println("DMG total attacker: " + attacker.getDamageDone() +
                " DMG total defender: " + defender.getDamageDone() );
    }





    private boolean calculateDodge(AAttributes attacker, AAttributes defender) {

        int agilityDifference = attacker.getAgility() - defender.getAgility();
        int threshold = 20;

        Random random = new Random();
        int randomNumber = random.nextInt(30) + 1;


        return (randomNumber > threshold + agilityDifference);

    }

    private void chanceOnHealthReg(AAttributes attacker) {

        Random random = new Random();
        int ranNum = random.nextInt(100) + 1;
        int num = 40;

        if (ranNum < num && attacker.getSpirit() >= 30) attacker.calculateHealthReg(attacker);
    }

    private void updatePlayerData(AAttributes player, AAttributes monster){
        db.updatePlayer(player,monster);
    }

    private void insertMonsterData(AAttributes monster){
        db.openConnection();
        db.insertMonster(monster);
    }











}

