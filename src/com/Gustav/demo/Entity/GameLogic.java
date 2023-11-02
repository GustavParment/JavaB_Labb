package com.Gustav.demo.Entity;

import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Resources.Paint.Colors;
import com.Gustav.demo.Resources.TheLoreMaster.LoreMasterKristoffer;
import java.util.Random;
import java.util.Scanner;

import static com.Gustav.demo.Entity.Rooms.MedusasLair.medusasLairOptions;
import static com.Gustav.demo.Entity.Rooms.TitansCave.titansCaveOption;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class GameLogic implements Colors {
    Scanner sc;

    public void characterChooser() {

       sc = new Scanner(System.in);

       println(BLACK_BACKGROUND + "---Choose class---" + RESET);
       println("1." + YELLOW + "Rogue" + RESET);
       println("2." + PURPLE + "Necromancer" + RESET);
       println("3." + GREEN + "Hunter" + RESET);
       println("4." + CYAN_BOLD + "Mage" + RESET);

       AAttributes player = null;
       switch (sc.nextLine()) {
           case "1" -> player = new Rogue();
           case "2" -> player = new Necromancer();
           case "3" -> player = new Hunter();
           case "4" -> player = new Mage();
           default -> println("Wrong input");
       }

        roomChooser(player,sc);


    }

    public void roomChooser(AAttributes attacker, Scanner sc) {
        println(BLACK + RED_BACKGROUND + "---Room's---" + RESET);
        println("1.Medusas Lair");
        println("2.The Titan's Cave");
        println("3.The Gigant Black Squirrel´s Nest");
        println("4.La Chancla");
        println("4.Fridas Revenge");
        println("5.Benny The Evil King");

        switch (sc.nextLine()){
            case "1" -> medusasLairOptions(attacker,sc);
            case "2" -> titansCaveOption(attacker,sc);
            default -> println(RED + "Wrong input, try again... " + RESET);
        }
    }

    public void fight(Scanner sc, AAttributes attacker, AAttributes defender){

            boolean fightDone = false;


            println(YELLOW + "You Engaged " + defender.getName()+ RESET);

            do {

                println("\n1.Attack " + defender.getName());
                println("2.Flee the fight");

                switch (sc.nextLine()) {
                    case "1" -> {


                        attack(attacker,defender);
                        didDodge(attacker,defender);
                        attack(defender,attacker);
                        didDodge(defender,attacker);
                        if (defender.getHealth() <= 0 || attacker.getHealth() <= 0){
                            fightDone = isFightDone(attacker, defender,false);
                            attacker.levelUp(attacker);}





                    }
                    case "2" -> {

                        attacker.flee();
                        println("" + attacker.getHealth());

                        fightDone = true;

                    }

                    default -> println(RED + "Wrong input, try again..." + RESET);
                }

            } while (!fightDone);

        playerMenu(attacker,sc); ;
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

            fightDone = true;

            defender = null;

        }
        if (attacker.getHealth() <= 0) {

            println(attacker.getName() + " was defeated by "
                    + defender.getName() + RESET);

            println(BLACK + RED_BACKGROUND + "Game over" + RESET);
            printDelay(PURPLE_BOLD+"Thanks for Playing better luck next time summoner..."
                    + RESET);
            fightDone = true;

            System.exit(0);


        }
        return fightDone;
    }

    private void didDodge (AAttributes attacker, AAttributes defender){

        if (calculateDodge(attacker, defender)) {

            print(RED + " MISS!" + RESET);
                println("\n"+defender.getName() + " " + defender.dodge());

                defender.setHealth(defender.getHealth() + attacker.getDamage());




        }else{
            print(GREEN + " HIT FOR "+ attacker.getDamage() + " DAMAGE!" + RESET);
            println("\n" + defender.getName() + YELLOW_BOLD + " remaining HP: "
                    + defender.getHealth() + RESET);

            System.out.println(attacker.getName() +" HP " + attacker.getHealth());

        }





    }

    private void attack(AAttributes attacker, AAttributes defender) {

        printDelay(attacker.getName() + " " + attacker.attack());
        attacker.setDamage((attacker.getDamage() + attacker.calculateDamage()));
        defender.setHealth(defender.getHealth() - attacker.getDamage());

        System.out.println("DMG ATTACKER: " + attacker.getDamage());
        System.out.println("Calculated DMG: " + attacker.calculateDamage());



    }

    private boolean calculateDodge(AAttributes attacker, AAttributes defender){

            int agilityDifference = attacker.getAgility() - defender.getAgility();
            int threshold = 20;

          
            Random random = new Random();
            int randomNumber = random.nextInt(30) + 1;


            return (randomNumber > threshold + agilityDifference);

        }

    public void playerMenu(AAttributes attacker, Scanner sc) {

        LoreMasterKristoffer enter = new LoreMasterKristoffer();
        boolean input = false;

        do {
            println("\n" + BLUE_BACKGROUND + "---Player Menu---" + RESET);
            println("1.Lore Master Kristoffer's Inn");
            println("2.Enter new Room");
            println("3.Player Attributes");

            switch (sc.nextLine()) {
                case "1" -> {enter.loreMastersInn(attacker,sc); input = true;}
                case "2" -> {roomChooser(attacker,sc); input = true;}
                case "3" -> attacker.getStatus(attacker);

                default -> println(RED + "Wrong input try again..." + RESET);
            }

        } while (!input);
    }


    }

