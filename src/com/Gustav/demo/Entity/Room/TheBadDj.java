package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.BadDj;
import com.Gustav.demo.Entity.Monsters.LaChancla;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheBadDj {
    public static void badDjOption(AAttributes attacker, Scanner sc){

        AAttributes badDj = new BadDj();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Bad DJ ☰" + RESET);
            printDelay(RED + " The Bad Dj plays a horrible song  " + RESET);
            println("\n1.Engage The Bad Dj \n2.Bad Djs attributes " + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, badDj);fight = true;}
                case "2" -> {
                    println("Hp: " + badDj.getHealth());
                    println("Damage: " + badDj.getDamage());
                    println("Level: " + badDj.getLevel());
                    println("AGI: " + badDj.getAgility());
                    println("Gold: " + badDj.getGold());
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
