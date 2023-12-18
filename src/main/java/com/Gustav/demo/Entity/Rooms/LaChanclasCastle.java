package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.LaChancla;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class LaChanclasCastle {

    public void laChanclaOption(AAttributes attacker, Scanner sc){

        AAttributes laChancla = new LaChancla();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        laChancla.setId(4);
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ La Chanclas Castle ☰" + RESET);
            printDelay(RED + "Here but not further " + attacker.getName()  +
                    RED + " i will do anything to protect the queen Frida "+ RESET);
            println(RED + "\n1.Engage La Chancla"+
                    BLUE_BOLD + "\n2.La Chanclas attributes "
                    + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, laChancla);fight = true;}
                case "2" -> {
                    println(GREEN + "Hp: " + laChancla.getHealth());
                    println(RED + "Damage: " + laChancla.getDamage());
                    println(BLUE + "Level: " + laChancla.getLevel());
                    println(BLUE_BOLD + "AGI: " + laChancla.getAgility());
                    println(YELLOW + "Gold: " + laChancla.getGold()  + RESET);
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
