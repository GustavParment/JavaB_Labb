package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.Entity.Monsters.Titan;
import com.Gustav.demo.GameEngine.Menu.RoomMenu;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.print;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TitansCave {

    public void titansCaveOption(AAttributes attacker, Scanner sc){

        AAttributes titan = new Titan();
        GameLogic start = new GameLogic();
        RoomMenu menu = new RoomMenu();
        boolean fight = false;

        do {
            println(BLACK + RED_BACKGROUND + "☰ The Titan's Cave ☰" + RESET);
            printDelay(RED + "You woke upp the Titan..." + RESET);
            println("\n1.Engage Titan \n2.Titans attributes "+ PURPLE+"\n╰┈➤3.Back to Rooms"+RESET);

            switch (sc.nextLine()) {
                case "1" -> {start.fight(sc, attacker, titan);fight = true;}
                case "2" -> {
                    println("Hp: " + titan.getHealth());
                    println("Damage: " + titan.getDamage());
                    println("Level: " + titan.getLevel());
                    println("AGI: " + titan.getAgility());
                    print("Gold: " + titan.getGold());
                }
                case "3" -> menu.roomChooser(attacker, sc);
                default -> println(RED + "Wrong input, try again..." + RESET);
            }
        }while(!fight);

    }
}
