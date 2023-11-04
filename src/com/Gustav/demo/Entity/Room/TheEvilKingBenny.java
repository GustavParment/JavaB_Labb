package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Benny;
import com.Gustav.demo.Entity.Monsters.Frida;
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
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Evil King Benny ☰" + RESET);
            printDelay(RED + "Benny " + RESET);
            println("\n1.Engage Benny \n2.Bennys attributes "+ PURPLE +"\n╰┈➤3.Back to Rooms" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, benny);fight = true;}
                case "2" -> {
                    println("Hp: " + benny.getHealth());
                    println("Damage: " + benny.getDamage());
                    println("Level: " + benny.getLevel());
                    println("AGI: " + benny.getAgility());
                    println("Gold: " + benny.getGold());
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
