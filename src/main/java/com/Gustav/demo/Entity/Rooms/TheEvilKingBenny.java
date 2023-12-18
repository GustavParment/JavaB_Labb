package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Benny;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheEvilKingBenny {

    public void bennyOption(AAttributes attacker, Scanner sc){

        AAttributes benny = new Benny();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        benny.setId(7);
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Evil King Benny ☰" + RESET);
            printDelay(RED + "What have you done to my beloved Frida " +
                    attacker.getName() + " you will pay for this scum!!!" + RESET);
            println(RED + "\n1.Engage Benny " +
                            BLUE_BOLD + "\n2.Bennys attributes " +
                    PURPLE +"\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, benny);fight = true;}
                case "2" -> {
                    println(GREEN + "Hp: " + benny.getHealth());
                    println(RED + "Damage: " + benny.getDamage());
                    println(BLUE + "Level: " + benny.getLevel());
                    println(BLUE_BOLD + "AGI: " + benny.getAgility());
                    println(YELLOW + "Gold: " + benny.getGold() + RESET);
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
