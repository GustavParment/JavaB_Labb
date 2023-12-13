package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class MedusasLair {

    public void medusasLairOptions(AAttributes attacker, Scanner sc){

        AAttributes medusa = new Medusa();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;




        do {
            println(BLACK + RED_BACKGROUND + "☰ Medusas Lair ☰" + RESET);
            printDelay(RED + "Medusa is angry be careful! " + RESET);
            println(RED + "\n1.Engage Medusa " +
                    BLUE_BOLD + "\n2.Medusas attributes "+
                    PURPLE + "\n╰┈➤3.Back to Rooms"+RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, medusa);fight = true;}
                case "2" -> {
                    println(GREEN + "Hp: " + medusa.getHealth());
                    println(RED + "Damage: " + medusa.getDamage());
                    println(BLUE + "Level: " + medusa.getLevel());
                    println(BLUE_BOLD + "AGI: " + medusa.getAgility());
                    println(YELLOW + "Gold: " + medusa.getGold() + RESET);
                }
                case "3" -> menu.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
