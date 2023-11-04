package com.Gustav.demo.GameEngine;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.Menu.PlayerMenu;
import com.Gustav.demo.Resources.Paint.Colors;
import java.util.Random;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class GameLogic implements Colors {
    public void fight(Scanner sc, AAttributes attacker, AAttributes defender){
        PlayerMenu menu = new PlayerMenu();

            boolean fightDone = false;

            println(YELLOW + "You Engaged " + defender.getName()+ RESET);

            do {

                println("\n1.Attack " + defender.getName());
                println("2.Flee the fight");

                switch (sc.nextLine()) {
                    case "1" -> {

                        attack(attacker, defender);

                        if(attacker.getHealth() > 0)didDodge(attacker, defender);

                        if (defender.getHealth() <= 0){
                            fightDone = isFightDone(attacker, defender,false);
                            attacker.levelUp(attacker);}

                        else attack(defender, attacker);

                        if(defender.getHealth() > 0){didDodge(defender, attacker);chanceOnHealthReg(attacker);}

                        if (attacker.getHealth() <= 0) fightDone = isFightDone(attacker, defender, false);

                    }
                    case "2" -> {attacker.flee();println("" + attacker.getHealth());fightDone = true;}
                    default -> println(RED + "Wrong input, try again..." + RESET);
                }

            } while (!fightDone);

        menu.playerOption(attacker,sc); ;

        }

    private boolean isFightDone (AAttributes attacker, AAttributes defender,
                                        boolean fightDone){

        if (defender.getHealth() <= 0) {

            printDelay(YELLOW + "\nCongratulations!" + RESET + " You have slayed "
                    + defender.getName());
            println("\n"+attacker.getName() + YELLOW +  " looted " + defender.getGold() + " gold" + RESET);
            println(attacker.getName() + YELLOW + " gained 100 xp" + RESET);
            println(attacker.getName() + YELLOW + " gained 10 Hp" + RESET);
            println(attacker.getName() + YELLOW + " gained +2 in all Attributes" + RESET);

            attacker.setExperience(attacker.getExperience() + 100);
            attacker.setGold(attacker.getGold() + defender.getGold());
            attacker.setHealth(attacker.getHealth() + 10);

            fightDone = true;

            defender = null;

        }
        if (attacker.getHealth() <= 0) {

            println(attacker.getName() + " was defeated by "
                    + defender.getName() + RESET);

            println(BLACK + RED_BACKGROUND + "\uD83D\uDC80Game over\uD83D\uDC80" + RESET);
            printDelay(PURPLE_BOLD+"Thanks for Playing better luck next time summoner..."
                    + RESET);
            fightDone = true;

            System.exit(0);


        }
        return fightDone;
    }

    private void didDodge (AAttributes attacker, AAttributes defender){

        if (calculateDodge(attacker, defender)){

                print(RED + " ❌MISS❌" + RESET);
                println("\n" + defender.getName() + " " + defender.dodge());

                defender.setHealth(defender.getHealth() + attacker.getDamage());

        }
           else{
                print(GREEN + " HIT FOR " + attacker.getDamage() + " DAMAGE ✔" + RESET);
                println("\n" + defender.getName() + YELLOW_BOLD + " remaining HP: "
                        + defender.getHealth() + RESET);


            }





    }

    private boolean attack(AAttributes attacker, AAttributes defender) {

        boolean attackerHealth = true;


            printDelay(attacker.getName() + " " + attacker.attack());
            attacker.calculateDamage(attacker);
            defender.setHealth(defender.getHealth() - attacker.getDamage());





        return attackerHealth;
    }

    private boolean calculateDodge(AAttributes attacker, AAttributes defender){

            int agilityDifference = attacker.getAgility() - defender.getAgility();
            int threshold = 20;

          
            Random random = new Random();
            int randomNumber = random.nextInt(30) + 1;


            return (randomNumber > threshold + agilityDifference);

        }

    private void chanceOnHealthReg(AAttributes attacker){

       Random random = new Random();
       int ranNum = random.nextInt(100)+ 1;
       int num = 20;

        println("NUM: " + num);
        println("RAN NUM: " + ranNum);


       if (ranNum < num && attacker.getSpirit() >= 70){


           attacker.calculateHealthReg(attacker);
           println(attacker.getName() + YELLOW +  " regenerated health new hp: " + attacker.getHealth() + RESET);

       }
    }


    }

