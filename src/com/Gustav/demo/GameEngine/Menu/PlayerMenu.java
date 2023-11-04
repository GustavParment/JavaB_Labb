package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.TheLoreMaster.LoreMasterKristoffer;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class PlayerMenu {

    RoomMenu menu;

    public void playerOption(AAttributes attacker, Scanner sc) {

        menu = new RoomMenu();
        LoreMasterKristoffer enter = new LoreMasterKristoffer();
        boolean input = false;

        do {
            println("\n"+ PURPLE + BLACK_BACKGROUND + "☰ Player Menu ☰" + RESET);
            println("1.Lore Master Kristoffer's Inn");
            println("2.Enter new Room");
            println("3.Player Attributes");

            switch (sc.nextLine()) {
                case "1" -> {enter.loreMastersInn(attacker,sc); input = true;}
                case "2" -> {menu.roomChooser(attacker,sc); input = true;}
                case "3" -> attacker.getStatus(attacker);

                default -> println(RED + "Wrong input try again..." + RESET);
            }

        } while (!input);
    }

}
