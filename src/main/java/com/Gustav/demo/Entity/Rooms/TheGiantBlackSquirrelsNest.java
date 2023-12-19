package com.Gustav.demo.Entity.Rooms;


import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.Entity.Monsters.BlackSquirrel;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheGiantBlackSquirrelsNest {

    public void gigantBlackSquirrelOptions(AAttributes attacker, Scanner sc) {

        AAttributes blackSquirrel = new BlackSquirrel();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        blackSquirrel.setId(3);
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Giant Black Squirrel's Nest ☰" + RESET);
            printDelay(RED + "The Giant Squirrel thinks you look like a delicious nut...." + RESET);
            println(RED + "\n1.Engage The Giant Black Squirrel" +
                    BLUE_BOLD + "\n2.Squirrel's attributes "
                    + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {
                    start.fight(sc, attacker, blackSquirrel);
                    fight = true;
                }
                case "2" -> {
                    println(GREEN + "Hp: " + blackSquirrel.getHealth());
                    println(RED + "Damage: " + blackSquirrel.getDamage());
                    println(BLUE + "Level: " + blackSquirrel.getLevel());
                    println(BLUE_BOLD + "AGI: " + blackSquirrel.getAgility());
                    println(YELLOW + "Gold: " + blackSquirrel.getGold() + RESET);
                }
                case "3" -> menu.roomChooser(attacker, sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        } while (!fight);
    }
}



