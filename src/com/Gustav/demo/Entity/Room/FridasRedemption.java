package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Frida;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class FridasRedemption {

    public static void fridaOption(AAttributes attacker, Scanner sc){

        AAttributes frida = new Frida();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ Fridas Revenge ☰" + RESET);
            printDelay(RED + "Frida blows a kiss" + RESET);
            println("\n1.Engage Frida \n2.Fridas attributes " + PURPLE + "\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, frida);fight = true;}
                case "2" -> {
                    println("Hp: " + frida.getHealth());
                    println("Damage: " + frida.getDamage());
                    println("Level: " + frida.getLevel());
                    println("AGI: " + frida.getAgility());
                    println("Gold: " + frida.getGold());
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}


