package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.AAttributes;
import com.Gustav.demo.Entity.GameLogic;
import com.Gustav.demo.Entity.Monsters.Titan;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.print;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TitansCave {

    public static void titansCaveOption(AAttributes attacker, Scanner sc){

        AAttributes titan = new Titan();
        GameLogic start = new GameLogic();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "---The Titan's Cave---" + RESET);
            printDelay(RED + "You woke upp the titan..." + RESET);
            println("\n1.Engage Titan \n2.Titans attributes \n3.Back to Rooms");

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, titan);fight = true;}
                case "2" -> {
                    println("Hp: " + titan.getHealth());
                    println("Damage: " + titan.getDamage());
                    println("Level: " + titan.getLevel());
                    print("Gold: " + titan.getGold());
                }
                case "3" -> start.roomChooser(attacker, sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);

    }
}
