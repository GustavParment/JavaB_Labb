package com.Gustav.demo.Entity;

import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.Resources.Paint.Colors;
import com.Gustav.demo.Resources.TheLoreMaster.LoreMasterKristoffer;

import java.util.Random;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class GameLogic implements Colors {
    Scanner sc;

    public void chooseClass() {

       sc = new Scanner(System.in);

       println(BLACK_BACKGROUND + "---Choose class---" + RESET);
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

        roomChooser(player,sc);

    }

    private void roomChooser(Attributes player,Scanner sc) {
        println(BLUE_BACKGROUND + "---Enter a room---" + RESET);
        println("1.Medusas Lair");
        println("2.Clash of the Titan");
        println("3.The Gigant Black Squirrel´s Nest");
        println("4.");
        println("5.Benny The Evil King");


        switch (sc.nextLine()){
            case "1" -> medusasLairOptions(player,sc);
            default -> println(RED + "Wrong input, try again... " + RESET);
        }
    }

    public void medusasLairOptions(Attributes attacker,Scanner sc){

        Attributes medusa = new Medusa();
        boolean fight = false;

    do {


        println(BLACK + RED_BACKGROUND + "---Medusas Lair---" + RESET);
        println(RED + "Medusa is angry be careful! " + RESET);

        println("1. Engage Medusa \n2. See Medusas attributes \n3. Exit Medusas lair");

        switch (sc.nextLine()) {
            case "1" -> {fight(sc, attacker, medusa);fight = true;}
            case "2" -> {
                println("Hp: " + medusa.getHealth());
                println("Damage: " + medusa.getDamage());
                println("Level: " + medusa.getLevel());

            }
            case "3" -> System.exit(0);

            default -> println(RED + "Wrong input, try again..." + RESET);
        }
    }while(!fight);
    }

    public void fight (Scanner sc, Attributes attacker, Attributes defender){

            boolean fightDone = false;

            println(YELLOW + "You engaged " + defender.getName()+"!" + RESET);

            do {

                println("1.Attack " + defender.getName());
                println("2.flee the fight");

                switch (sc.nextLine()) {
                    case "1" -> {

                        didDodge(attacker, defender);

                        didDodge(defender, attacker);

                        fightDone = isFightDone(attacker, defender, false);
                        attacker.levelUp(attacker);

                    }
                    case "2" -> {

                        attacker.flee();
                        println("" + attacker.getHealth());

                        fightDone = true;
                    }

                    default -> println(RED + "Wrong input try again..." + RESET);
                }

            } while (!fightDone);

            playerMenu(attacker,sc);
        }

    private static boolean isFightDone (Attributes attacker, Attributes defender,
                                        boolean fightDone){

            if (defender.getHealth() == 0) {

                printDelay(YELLOW + "\nCongratulations!" + RESET + " You have slayed "
                        + defender.getName());
                println("\n"+attacker.getName() + YELLOW +  " looted 20 gold" + RESET);
                println(attacker.getName() + YELLOW + " gained 100 xp" + RESET);

                attacker.setExperience(attacker.getExperience() + 100);
                attacker.setGold(attacker.getGold() + 20);

                fightDone = true;

                defender = null;

            }
            if (attacker.getHealth() == 0) {

                println(attacker.getName() + " was defeated by "
                        + defender.getName() + RESET);

                println(BLACK + RED_BACKGROUND + "Game over" + RESET);

                fightDone = true;


            }
            return fightDone;
        }

    private void didDodge (Attributes attacker, Attributes defender){

            if (chanceToDodge(attacker, defender)) {

                printDelay(attacker.getName() + " " + attacker.attack() );
                println(RED + " ATTACK MISSED!" + RESET);
                println( defender.getName() + " " + defender.dodge());


            } else {

                printDelay(attacker.getName() + " " + attacker.attack());
                defender.setHealth(defender.getHealth() - attacker.getDamage());
                println(GREEN + " ATTACK SUCCESSFUL!" + RESET);
                println(defender.getName() + YELLOW_BOLD + " lost HP and has now "
                        + defender.getHealth() + " HP"+  RESET);

            }
        }

    private boolean chanceToDodge (Attributes attacker, Attributes defender){

            int agilityDifference = attacker.getAgility() - defender.getAgility();
            int threshold = 20;

            // Skapa en slumpgenerator
            Random random = new Random();

            // Generera ett slumpmässigt tal mellan 1 och 30
            int randomNumber = random.nextInt(30) + 1;

            // Om det slumpmässiga talet är högre än tröskeln, missar attacken
            return (randomNumber > threshold + agilityDifference);

        }

    public void playerMenu(Attributes attacker, Scanner sc) {
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
                case "3" -> attacker.getStatus();

                default -> println(RED + "Wrong input try again..." + RESET);
            }

        } while (!input);
    }



}

