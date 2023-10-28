package com.Gustav.demo;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.Resources.Paint.Colors;
import java.util.*;


public class Main implements Colors {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        Attributes hunter = new Hunter();
        Attributes medusa = new Medusa();


        /**TODO-Dungeon Run
         *  Creat a function for determine doge chance
         *  Creat a shop class / The shopkeeper and Lore-master Kristoffer
         *  Creat a start menu determine how the game is starting
         *  Creat a currency
         *  Creat a function for bossLoot()(gold drop)
         *  Creat a function to see stats.
         *  Implements stats how much is you chance to doge/hit
         *  Creat Argument fight(Attributes boss)
         *
         *
         *
         */


      /*  System.out.println("\nChoose class");

        System.out.println("1." + YELLOW + "Rogue" + RESET);
        System.out.println("2." + MAGENTA + "Necromancer" + RESET);
        System.out.println("3." + GREEN + "Hunter" + RESET);


        Attributes player = null;
        switch (sc.nextLine()) {
            case "1" -> player = new Rogue();
            case "2" -> player = new Necromancer();
            case "3" -> player = new Hunter();

            default -> System.out.println("Wrong input");
        }

        Attributes medusa = new Medusa();
        System.out.println(RED_BACKGROUND + BLACK +  "---Medusas Lair---" + RESET);
        System.out.println(RED + "\nMedusa is angry be careful! " + RESET);

        System.out.println("1. Engage Medusa \n2. See Medusas attributes \n3. Exit Medusas lair");


        switch (sc.nextLine()) {
            case "1" -> fightMedusa(sc, player);
            case "2" -> {
                System.out.println("Hp: " + medusa.getHealth());
                System.out.println("Damage: " + medusa.getBaseDamage());
                System.out.println("Level: " + medusa.getLevel());
            }
            case "3" -> System.exit(0);

            default -> System.out.println("Wrong input");
        }



    }*/

        fight(sc,hunter,medusa);

    }

    public static void fight(Scanner sc , Attributes attacker, Attributes defender){

        boolean fightDone = false;

        System.out.println(YELLOW + "You engaged Medusa!" + RESET);

        do {

            System.out.println("1.Attack Medusa");
            System.out.println("2.flee the fight");

            switch (sc.nextLine()) {
                case "1" -> {


                    if (chanceToDoge(attacker,defender)) {

                        System.out.println(attacker.getName() + " " + attacker.attack());
                        System.out.println(RED + "Attack missed!" + RESET);

                    }
                    else {

                        //TODO-PLAYER ATTACK
                        System.out.println(attacker.getName() + " " + attacker.attack());
                        defender.setHealth(defender.getHealth() - attacker.getBaseDamage());
                        System.out.println(defender.getName() + YELLOW_BOLD + " hp: "
                                + defender.getHealth() + RESET);

                    }

                    if (chanceToDoge(defender,attacker)){

                        System.out.println(defender.getName() + " " + defender.attack());
                        System.out.println(RED + "Attack missed!" + RESET);
                    }
                    else{

                        //TODO-BOSS ATTACK
                        System.out.println(defender.getName() + " " + defender.attack());
                        attacker.setHealth(attacker.getHealth() - defender.getBaseDamage());
                        System.out.println(attacker.getName() + YELLOW_BOLD + " hp: " +
                                attacker.getHealth() + RESET);

                    }





                    if (defender.getHealth() == 0) {

                        System.out.println(YELLOW + "Congratulations!" + RESET + " You have slayed "
                                + defender.getName());

                        attacker.setLevel(attacker.getLevel() + 1);
                        System.out.println(BLUE_BOLD + "You reached level: " + attacker.getLevel() + RESET);

                        fightDone = true;


                    }
                    if (attacker.getHealth() == 0) {

                        System.out.println(attacker.getName() + " was defeated by "
                                + defender.getName() + RESET);

                        System.out.println(BLACK + RED_BACKGROUND + "Game over" + RESET);

                        fightDone = true;


                    }
                }
                case "2" -> {

                    attacker.flee();
                    System.out.println(attacker.getHealth());

                    fightDone = true;
                }

                default -> System.out.println(RED + "Wrong input try again..." + RESET);
            }

        }while (!fightDone);
    }

    public static boolean chanceToDoge(Attributes attacker, Attributes defender){

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
