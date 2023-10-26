package demo.Gustav.demo;

import demo.Gustav.demo.Entity.Attributes;
import demo.Gustav.demo.Entity.Heros.Rogue;
import demo.Gustav.demo.Entity.Heros.Hunter;
import demo.Gustav.demo.Entity.Heros.Necromancer;
import demo.Gustav.demo.Entity.Monsters.Medusa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        /**TODO-Dungeon Run
         *  Creat a function for determine doge chance
         *  Creat a shop class
         *  Creat a start menu determine how the game is starting
         *  Creat a currency
         *  Creat a function for bossLoot()
         *  creat a function to see stats.
         *
         *
         *
         */


        System.out.println("\nChoose class");

        System.out.println("1.Rogue");
        System.out.println("2.Necromancer");
        System.out.println("3.Hunter");
        int input = sc.nextInt();

        Attributes player = null;
        switch (input){


            case 1: player = new Rogue();
            break;
            case 2: player = new Necromancer();
            break;
            case 3: player = new Hunter();
            default:

                return;


        }

        System.out.println("---Medusas Lair---");
        System.out.println("\nMedusa is angry be careful! ");
        System.out.println("1. to engage Medusa \n2. to flee");

        input = sc.nextInt();
        switch (input){
            case 1: fight(sc,player);
                break;
            case 2: player.flee();
                break;
        }



    }

    public static void fight(Scanner sc , Attributes player){

        Attributes medusa = new Medusa();
        boolean boskill = false;

        System.out.println("You engaged Medusa!");

        do {

            System.out.println("press 1 to Attack Medusa");

           switch (sc.nextInt()) {
               case 1:

                   System.out.println(player.getName() + " " + player.attack());
                   medusa.setHealth(medusa.getHealth() -5);
                   System.out.println(medusa.getName() + "'s hp is: " + medusa.getHealth());
                   System.out.println(medusa.getName() + " " + medusa.attack() );
                   player.setHealth(player.getHealth() -5);
                   System.out.println(player.getName() +  "'s hp is: " + player.getHealth());

                   if (medusa.getHealth() == 0) {

                       System.out.println(medusa.getName() + " is dead");

                       boskill = true;

                       break;
                   }

                   if (player.getHealth() == 0){

                       System.out.println(player.getName() + " was defeted by" + medusa.getName());
                   }

           }

        }while (!boskill);
    }


}
