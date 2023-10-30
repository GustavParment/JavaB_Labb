package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.GameLogic;
import com.Gustav.demo.Entity.Monsters.Medusa;

import java.util.Objects;
import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class MedusasLair {

    public static void medusasLairOptions(Attributes attacker, Scanner sc){

        Attributes medusa = new Medusa();
        GameLogic start = new GameLogic();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "---Medusas Lair---" + RESET);
            printDelay(RED + "Medusa is angry be careful! " + RESET);
            println("\n1.Engage Medusa \n2.Medusas attributes \n3.Back to Rooms");

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, medusa);fight = true;}
                case "2" -> {
                    println("Hp: " + medusa.getHealth());
                    println("Damage: " + medusa.getDamage());
                    println("Level: " + medusa.getLevel());
                }
                case "3" -> start.roomChooser(attacker,sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);
    }
}
