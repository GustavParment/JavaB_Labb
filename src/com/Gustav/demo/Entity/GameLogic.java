package com.Gustav.demo.Entity;

import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Monsters.*;
import com.Gustav.demo.Resources.Paint.Colors;

import java.util.Random;
import java.util.Scanner;

import static com.Gustav.demo.Resources.Print.MessageHandler.*;

public class GameLogic implements Colors {
    Scanner sc;

    Attributes medusa;

   public void chooseClass() {

     /*  sc = new Scanner(System.in);
       medusa = new Medusa();

       println("\nChoose class");
       println("1." + YELLOW + "Rogue" + RESET);
       println("2." + PURPLE + "Necromancer" + RESET);
       println("3." + GREEN + "Hunter" + RESET);


       Attributes player = null;
       switch (sc.nextLine()) {
           case "1" -> player = new Rogue();
           case "2" -> player = new Necromancer();
           case "3" -> player = new Hunter();

           default -> println("Wrong input");
       }

       println("---Enter a room---");
       println("1.Medusas Lair");
       println("2.");


       switch (sc.nextLine()){
           case "1" -> meduasLair(player);
       }

    }

    public void meduasLair(Attributes player){

        println(BLACK + RED_BACKGROUND + "---Medusas Lair---" + RESET);
        println(RED + "\nMedusa is angry be careful! " + RESET);

        println("1. Engage Medusa \n2. See Medusas attributes \n3. Exit Medusas lair");


        switch (sc.nextLine()) {
            case "1" -> fight(sc, player, medusa);
            case "2" -> {
                println("Hp: " + medusa.getHealth());
                println("Damage: " + medusa.getBaseDamage());
                println("Level: " + medusa.getLevel());
            }
            case "3" -> System.exit(0);

            default -> println(RED + "Wrong input, try again..." + RESET);
        } */

   }



    public void fight(Scanner sc , Attributes attacker, Attributes defender){
    try {
        boolean fightDone = false;

        println(YELLOW + "You engaged Medusa!" + RESET);

        do {

            println("1.Attack Medusa");
            println("2.flee the fight");

            switch (sc.nextLine()) {
                case "1" -> {

                    didDodge(attacker, defender);

                    didDodge(defender, attacker);

                    fightDone = isFightDone(attacker, defender, false);
                }
                case "2" -> {

                    attacker.flee();
                    println("" + attacker.getHealth());

                    fightDone = true;
                }

                default -> println(RED + "Wrong input try again..." + RESET);
            }

        } while (!fightDone);
    }catch (Exception e){
        e.printStackTrace();
    }
   }

    private static boolean isFightDone(Attributes attacker, Attributes defender, boolean fightDone) {

       if (defender.getHealth() == 0) {

            println(YELLOW + "Congratulations!" + RESET + " You have slayed "
                    + defender.getName());

            attacker.levelUp(attacker);

            fightDone = true;


        }
        if (attacker.getHealth() == 0) {

            println(attacker.getName() + " was defeated by "
                    + defender.getName() + RESET);

            println(BLACK + RED_BACKGROUND + "Game over" + RESET);

            fightDone = true;


        }
        return fightDone;
    }

    private void didDodge(Attributes attacker, Attributes defender) throws InterruptedException {

        if (chanceToDoge(attacker,defender)) {


                println(attacker.getName() + " " + attacker.attack());
                Thread.sleep(100);
                println(RED + "Attack missed!" + RESET);

        }
        else {

            //TODO-PLAYER ATTACK
            println(attacker.getName() + " " + attacker.attack());
            defender.setHealth(defender.getHealth() - attacker.getBaseDamage());
            println(YELLOW + "Attack successful" + RESET);
            println(defender.getName() + YELLOW_BOLD + " hp: "
                    + defender.getHealth() + RESET);

        }
    }

    private boolean chanceToDoge(Attributes attacker, Attributes defender){

        int agilityDifference = attacker.getAgility() - defender.getAgility();
        int threshold = 20;


        // Skapa en slumpgenerator
        Random random = new Random();

        // Generera ett slumpmässigt tal mellan 1 och 20
        int randomNumber = random.nextInt(30) + 1;


        // Om det slumpmässiga talet är högre än tröskeln, missar attacken
        return (randomNumber > threshold + agilityDifference);

   }



}
