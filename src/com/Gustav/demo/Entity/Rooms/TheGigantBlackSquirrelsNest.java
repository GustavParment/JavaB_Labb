package com.Gustav.demo.Entity.Rooms;


import com.Gustav.demo.Entity.AAttributes;
import com.Gustav.demo.Entity.GameLogic;
import com.Gustav.demo.Entity.Monsters.BlackSquirrel;
import com.Gustav.demo.Entity.Monsters.Medusa;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheGigantBlackSquirrelsNest {

    public static void gigantBlackSquirrelOptions(AAttributes attacker, Scanner sc){

        AAttributes blackSquirrel = new BlackSquirrel();
        GameLogic start = new GameLogic();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "---The Gigant Black Squirrel's Nest---" + RESET);
            printDelay(RED + "The Gigant Squirrel thinks you looks like a delicious nut...." + RESET);
            println("\n1.Engage The Gigant Black Squirrel \n2.Squirrel's attributes \n3.Back to Rooms");

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, blackSquirrel);fight = true;}
                case "2" -> {
                    println("Hp: " + blackSquirrel.getHealth());
                    println("Damage: " + blackSquirrel.getDamage());
                    println("Level: " + blackSquirrel.getLevel());
                    println("Gold: " + blackSquirrel.getGold());
                }
                case "3" -> start.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}



