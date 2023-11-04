package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Frida;
import com.Gustav.demo.Entity.Monsters.LaChancla;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class LaChanclasCastle {

    public static void laChanclaOption(AAttributes attacker, Scanner sc){

        AAttributes laChancla = new LaChancla();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ La Chanclas Castle ☰" + RESET);
            printDelay(RED + "La Chancla  " + RESET);
            println("\n1.Engage La Chancla \n2.La Chanclas attributes " + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, laChancla);fight = true;}
                case "2" -> {
                    println("Hp: " + laChancla.getHealth());
                    println("Damage: " + laChancla.getDamage());
                    println("Level: " + laChancla.getLevel());
                    println("AGI: " + laChancla.getAgility());
                    println("Gold: " + laChancla.getGold());
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
