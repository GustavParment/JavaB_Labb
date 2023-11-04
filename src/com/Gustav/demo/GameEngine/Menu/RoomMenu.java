package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Room.*;

import java.util.Scanner;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.print;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class RoomMenu {

    public void roomChooser(AAttributes attacker, Scanner sc) {
        PlayerMenu returnTo = new PlayerMenu();
        FridasRedemption frida = new FridasRedemption();
        LaChanclasCastle laChancla = new LaChanclasCastle();
        MedusasLair medusasLair =  new MedusasLair();
        TheEvilKingBenny theEvilKingBenny = new TheEvilKingBenny();
        TheGigantBlackSquirrelsNest squirrelsNest = new TheGigantBlackSquirrelsNest();
        TitansCave titansCave = new TitansCave();
        boolean rightInput;
        do {

            roomDisplayer(attacker);
            rightInput = getRoom(attacker, sc, medusasLair, titansCave, squirrelsNest,
                    laChancla, frida, theEvilKingBenny, returnTo);

        }while(!rightInput);
    }

    private boolean getRoom(AAttributes attacker, Scanner sc, MedusasLair medusasLair,
                            TitansCave titansCave, TheGigantBlackSquirrelsNest squirrelsNest,
                            LaChanclasCastle laChancla, FridasRedemption frida,
                            TheEvilKingBenny theEvilKingBenny, PlayerMenu returnTo) {
        switch (sc.nextLine()) {
            case "1" -> medusasLair.medusasLairOptions(attacker, sc);
            case "2" ->{
                if (attacker.getLevel() < 2){
                    println(RED + "To low level for this room");
                }else{
                    titansCave.titansCaveOption(attacker, sc);
                }
            }
            case "3" -> {
                if (attacker.getLevel() < 3){
                    println(RED + "To low level for this room");

                }
                else{
                    squirrelsNest.gigantBlackSquirrelOptions(attacker, sc);
                }
            }

            case "4" -> {
                if (attacker.getLevel() < 4) {
                    println(RED + "To low level for this room");
                } else {
                    laChancla.laChanclaOption(attacker, sc);
                }
            }
            case "5" ->{
                if (attacker.getLevel() < 10) {
                    println(RED + "To low level for this room");

                }else{
                    frida.fridaOption(attacker, sc);
                }
            }
            case "10" ->{
                if (attacker.getLevel() < 10){
                    println(RED + "To low level for this room");

                }else{
                    theEvilKingBenny.bennyOption(attacker, sc);
                }
            }
            case "11" -> returnTo.playerOption(attacker, sc);
            // case "4" ->
            default -> println(RED + "Wrong input, try again... " + RESET);
        }

        return false;
    }

    private void roomDisplayer(AAttributes attacker) {
        println(BLUE + BLACK_BACKGROUND + "☰ Room's ☰" + RESET);
        switch(attacker.getLevel()) {
            case 0 ->{
                println("1.Medusas Lair");
                println("2. ☠️☠️☠️"+ RED + "???" + RESET);
                println("3. ☠️☠️☠️"+ RED + "???" + RESET);
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println("10.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 1 -> {
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3. ☠️☠️☠️"+ RED + "???" + RESET);
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println("10.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);

            }
            case 2 -> {
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println("10.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);

            }
            case 3 -> {
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println("10.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 4 ->{
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.In Construction");
                println("7. ☠️☠️☠️" + RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println("10.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);

            }
            case 5 ->{
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.In Construction");
                println("7.In Construction");
                println("8.☠️☠️☠️"+ RED + "???" + RESET);
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println("10☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);

            }
            case 6 -> {
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.☠️☠️☠️"+ RED + "???" + RESET);
                println("7.☠️☠️☠️"+ RED + "???" + RESET);
                println("8.☠️☠️☠️"+ RED + "???" + RESET);
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println("10☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 7 ->{
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.in progress");
                println("7.☠️☠️☠️"+ RED + "???" + RESET);
                println("8.☠️☠️☠️"+ RED + "???" + RESET);
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println("10☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 8 ->{
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.");
                println("7.");
                println("8.☠️☠️☠️"+ RED + "???" + RESET);
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println("10☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 9 ->{
                println("1.Medusas Lair");
                println("2.The Titan's Cave");
                println("3.The Gigant Black Squirrel´s Nest");
                println("4.La Chancla's Castle");
                println("5.The Bad DJ");
                println("6.");
                println("7.");
                println("8.");
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println("10☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤11.Back to Player Menu" + RESET);
            }
            case 10 ->{
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
            }
        }
    }

}
