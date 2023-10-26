package com.Gustav.demo;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Monsters.Medusa;


import static com.Gustav.demo.Paint.Colors.*;

import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Attributes hunter = new Hunter();


        /**TODO-Dungeon Run
         *  Creat a function for determine doge chance
         *  Creat a shop class / The shopkeeper and Lore-master Kristoffer
         *  Creat a start menu determine how the game is starting
         *  Creat a currency
         *  Creat a function for bossLoot()(gold drop)
         *  creat a function to see stats.
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
        fightMedusa(sc,hunter);
    }

    public static void fightMedusa(Scanner sc , Attributes player){

        Attributes medusa = new Medusa();
        boolean fightDone = false;




        System.out.println(YELLOW + "You engaged Medusa!" + RESET);

        do {

            System.out.println("1.Attack Medusa");
            System.out.println("2.flee the fight");

            switch (sc.nextLine()) {
                case "1" -> {


                    if (chanceToDoge(player,medusa)) {

                        System.out.println("Attack missed");
                        System.out.println(player.getHealth());
                        System.out.println(medusa.getHealth());


                    }
                    else {

                        System.out.println(player.getName() + " " + player.attack());
                        medusa.setHealth(medusa.getHealth() - player.getBaseDamage());
                        System.out.println(medusa.getName() + "'s hp is: " + medusa.getHealth());
                        System.out.println(medusa.getName() + " " + medusa.attack());
                        player.setHealth(player.getHealth() - medusa.getBaseDamage());
                        System.out.println(player.getName() + "'s hp is: " + player.getHealth());

                    }





                    if (medusa.getHealth() == 0) {

                        System.out.println(medusa.getName() + " is dead");

                        fightDone = true;


                    }
                    if (player.getHealth() == 0) {

                        System.out.println(player.getName() + " was defeated by " + medusa.getName());

                        System.out.println("Game over");

                        fightDone = true;


                    }
                }
                case "2" -> {

                    player.flee();
                    System.out.println(player.getHealth());
                    fightDone = true;
                }
            }

        }while (!fightDone);
    }

    public static boolean chanceToDoge(Attributes player, Attributes boss){

        int agilityDifference = player.getAgility() - boss.getAgility();
        int threshold = 20; // Justera detta värde efter dina behov

        // Skapa en slumpgenerator
        Random random = new Random();

        // Generera ett slumpmässigt tal mellan 1 och 100
        int randomNumber = random.nextInt(30) + 1;

        // Om det slumpmässiga talet är högre än tröskeln, missar attacken
        return (randomNumber > threshold + agilityDifference);


    }

}
