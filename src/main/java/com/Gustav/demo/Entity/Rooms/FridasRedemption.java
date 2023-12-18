package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Frida;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class FridasRedemption {
    public void fridaOption(AAttributes attacker, Scanner sc){
        AAttributes frida = new Frida();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        frida.setId(6);
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ Fridas Revenge ☰" + RESET);
            printDelay(RED + "\"Frida blows a kiss\"\nYou will never get passed me! " +
                    "I shall protect my noble king Benny " + RESET);
            println(RED + "\n1.Engage Frida " +
                    BLUE_BOLD +  "\n2.Fridas attributes "
                    + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, frida);fight = true;}
                case "2" -> {
                    println(GREEN + "Hp: " + frida.getHealth());
                    println(RED + "Damage: " + frida.getDamage());
                    println(BLUE + "Level: " + frida.getLevel());
                    println(BLUE_BOLD + "AGI: " + frida.getAgility());
                    println(YELLOW + "Gold: " + frida.getGold() + RESET);
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}


