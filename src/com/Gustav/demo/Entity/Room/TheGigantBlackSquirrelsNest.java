package com.Gustav.demo.Entity.Room;


import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.Entity.Monsters.BlackSquirrel;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheGigantBlackSquirrelsNest {

    public void gigantBlackSquirrelOptions(AAttributes attacker, Scanner sc){

        AAttributes blackSquirrel = new BlackSquirrel();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Gigant Black Squirrel's Nest ☰" + RESET);
            printDelay(RED + "The Gigant Squirrel thinks you look like a delicious nut...." + RESET);
            println("\n1.Engage The Gigant Black Squirrel \n2.Squirrel's attributes "
                    + PURPLE + "\n╰┈➤3.Back to Rooms"+ RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, blackSquirrel);fight = true;}
                case "2" -> {
                    println("Hp: " + blackSquirrel.getHealth());
                    println("Damage: " + blackSquirrel.getDamage());
                    println("Level: " + blackSquirrel.getLevel());
                    println("AGI: " + blackSquirrel.getAgility());
                    println("Gold: " + blackSquirrel.getGold());
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}



