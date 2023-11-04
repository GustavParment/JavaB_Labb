package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Room.LaChanclasCastle;

import java.util.Scanner;

import static com.Gustav.demo.Entity.Room.FridasRedemption.fridaOption;
import static com.Gustav.demo.Entity.Room.LaChanclasCastle.laChanclaOption;
import static com.Gustav.demo.Entity.Room.MedusasLair.medusasLairOptions;
import static com.Gustav.demo.Entity.Room.TheEvilKingBenny.bennyOption;
import static com.Gustav.demo.Entity.Room.TheGigantBlackSquirrelsNest.gigantBlackSquirrelOptions;
import static com.Gustav.demo.Entity.Room.TitansCave.titansCaveOption;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class RoomMenu {

    public void roomChooser(AAttributes attacker, Scanner sc) {
        PlayerMenu returnTo = new PlayerMenu();

        println(BLUE + BLACK_BACKGROUND + "☰ Room's ☰" + RESET);
        println("1.Medusas Lair");
        println("2.The Titan's Cave");
        println("3.The Gigant Black Squirrel´s Nest");
        println("4.La Chancla's Castle");
        println("5.The Bad DJ");
        println("6.In Construction");
        println("7.In Construction");
        println("8.In Construction");
        println("9.Fridas Redemption");
        println("10.Benny The Evil King");
        println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);

        switch (sc.nextLine()){
            case "1" -> medusasLairOptions(attacker,sc);
            case "2" -> titansCaveOption(attacker,sc);
            case "3" -> gigantBlackSquirrelOptions(attacker,sc);
            case "4" -> laChanclaOption(attacker, sc);
            case "5" -> fridaOption(attacker,sc);
            case "6" -> bennyOption(attacker,sc);
            case "11" -> returnTo.playerOption(attacker,sc);
            // case "4" ->
            default -> println(RED + "Wrong input, try again... " + RESET);
        }
    }
}
