package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Rooms.*;

import java.util.*;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class RoomMenu {

    public void roomChooser(AAttributes attacker, Scanner sc) {
        PlayerMenu returnTo = new PlayerMenu();
        FridasRedemption frida = new FridasRedemption();
        LaChanclasCastle laChancla = new LaChanclasCastle();
        MedusasLair medusasLair =  new MedusasLair();
        TheEvilKingBenny theEvilKingBenny = new TheEvilKingBenny();
        TheGiantBlackSquirrelsNest squirrelsNest = new TheGiantBlackSquirrelsNest();
        TitansCave titansCave = new TitansCave();
        TheBadDj badDj = new TheBadDj();
        TheRoomOfRiddles riddles = new TheRoomOfRiddles();
        TheRoomOfRelics relics = new TheRoomOfRelics();


        boolean rightInput;
        do {

            roomDisplayer(attacker);
            rightInput = getRoom(attacker, sc,
                    medusasLair, titansCave, squirrelsNest,
                    laChancla, frida, theEvilKingBenny,
                    badDj, returnTo,riddles,relics
            );

        }while(!rightInput);
    }

    private boolean getRoom(AAttributes attacker, Scanner sc, MedusasLair medusasLair,
                            TitansCave titansCave, TheGiantBlackSquirrelsNest squirrelsNest,
                            LaChanclasCastle laChancla, FridasRedemption frida,
                            TheEvilKingBenny theEvilKingBenny,TheBadDj badDj ,
                            PlayerMenu returnTo,TheRoomOfRiddles riddles,
                            TheRoomOfRelics relics
    )
    {
        switch (sc.nextLine()) {
            case "1" ->{
                if (attacker.getLevel() >= 2){
                    println(GREEN + "To high level for this room..." + RESET);

                }else{
                    medusasLair.medusasLairOptions(attacker, sc);
                }
            }

            case "2" ->{
                if (attacker.getLevel() < 1){
                    println(RED + "To low level for this room...");

                }else if (attacker.getLevel() >= 3){
                    println(GREEN + "To high level for this room..." + RESET);
                }
                else {
                    titansCave.titansCaveOption(attacker, sc);
                }
                
            }
            case "3" -> {
                if (attacker.getLevel() < 3){
                    println(RED + "To low level for this room");

                } else if (attacker.getLevel() >= 5){
                    println(GREEN + "To high level for this room..." + RESET);
                    
                } else{
                    squirrelsNest.gigantBlackSquirrelOptions(attacker, sc);
                }
            }
            case "4" -> {
                if (attacker.getLevel() < 4) {
                    println(RED + "To low level for this room");

                }else if (attacker.getLevel() >= 6){
                    println(GREEN + "To high level for this room..." + RESET);
                    
                }else{
                    laChancla.laChanclaOption(attacker, sc);
                }
            }
            case "5" ->{
                if (attacker.getLevel() < 5) {
                    println(RED + "To low level for this room");

                }else if (attacker.getLevel() >= 7){
                    println(GREEN + "To high level for this room..." + RESET);

                }else{
                    badDj.badDjOption(attacker,sc);
                }

            }
            case "6" ->{
                if (attacker.getLevel() < 6){
                    println(RED + "To low level for this room" + RESET);

                } else{
                    relics.roomOfRelicsOption(attacker,sc);

                }
            }

            case "7" ->{
                if(attacker.getLevel() < 6) {
                    println(RED + "To low level for this room");

                }else{
                    riddles.roomOFRiddlesOption(attacker, sc);
                }
            }
            case "8" ->{
                if (attacker.getLevel() < 9){
                    println(RED + "To low level for this room");

                }else if (attacker.getLevel() >= 11){
                    println(GREEN + "To high level for this room..." + RESET);

                }else{
                    frida.fridaOption(attacker, sc);
                }
            }
            case "9" ->{
                if (attacker.getLevel() < 10) {
                    println(RED + "To low level for this room");

                }else{
                    theEvilKingBenny.bennyOption(attacker, sc);
                }
            }
            case "10" -> returnTo.playerOption(attacker, sc);
            // case "4" ->
            default -> println(RED + "Wrong input, try again... " + RESET);
        }

        return false;
    }

    private void roomDisplayer(AAttributes attacker) {
        println(BLUE + BLACK_BACKGROUND + "☰ Room's ☰" + RESET);
        switch(attacker.getLevel()) {
            case 0 ->{
                println(YELLOW + "1.Medusas Lair" + RESET);
                println("2. ☠️☠️☠️"+ RED + "???" + RESET);
                println("3. ☠️☠️☠️"+ RED + "???" + RESET);
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }
            case 1 -> {
                println(GREEN + "1.Medusas Lair" + RESET);
                println(YELLOW + "2.The Titan's Cave" + RESET);
                println("3. ☠️☠️☠️"+ RED + "???" + RESET);
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);

            }
            case 2 -> {
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(YELLOW + "2.The Titan's Cave" + RESET);
                println(RED + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println("4. ☠️☠️☠️"+ RED + "???" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);

            }
            case 3 -> {
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(YELLOW + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(RED + "4.La Chancla's Castle" + RESET);
                println("5. ☠️☠️☠️"+ RED + "???" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }
            case 4 ->{
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(GREEN + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(YELLOW + "4.La Chancla's Castle" + RESET);
                println(RED + "5.The Bad DJ" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);

            }
            case 5 ->{
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(BLACK_BOLD_BRIGHT + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(GREEN + "4.La Chancla's Castle" + RESET);
                println(YELLOW + "5.The Bad DJ" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);

            }
            case 6 -> {
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(BLACK_BOLD_BRIGHT + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(BLACK_BOLD_BRIGHT + "4.La Chancla's Castle" + RESET);
                println(GREEN + "5.The Bad DJ" + RESET);
                println("6. ☠️☠️☠️"+ RED + "???" + RESET);
                println("7. ☠️☠️☠️"+ RED + "???" + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }
            case 7,8 ->{
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(BLACK_BOLD_BRIGHT + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(BLACK_BOLD_BRIGHT + "4.La Chancla's Castle" + RESET);
                println(BLACK_BOLD_BRIGHT + "5.The Bad DJ" + RESET);
                println(PURPLE + "6.Room of Relics" + RESET);
                println(PURPLE + "7.Room of Riddles " + RESET);
                println("8. ☠️☠️☠️"+ RED + "???" + RESET);
                println("9. ☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }
            case 9 ->{
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(BLACK_BOLD_BRIGHT + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(BLACK_BOLD_BRIGHT + "4.La Chancla's Castle" + RESET);
                println(BLACK_BOLD_BRIGHT + "5.The Bad DJ" + RESET);
                println(PURPLE + "6.Room of Relics" + RESET);
                println(PURPLE + "7.Room of Riddles " + RESET);
                println(YELLOW + "8.Fridas Redemption" + RESET);
                println("9.☠️☠️☠️"+ RED + "???" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }
            case 10,11,12 ->{
                println(BLACK_BOLD_BRIGHT + "1.Medusas Lair" + RESET);
                println(BLACK_BOLD_BRIGHT + "2.The Titan's Cave" + RESET);
                println(BLACK_BOLD_BRIGHT + "3.The Gigant Black Squirrel´s Nest" + RESET);
                println(BLACK_BOLD_BRIGHT + "4.La Chancla's Castle" + RESET);
                println(BLACK_BOLD_BRIGHT + "5.The Bad DJ" + RESET);
                println(PURPLE + "6.Room of Relics" + RESET);
                println(PURPLE + "7.Room of Riddles " + RESET);
                println(YELLOW + "8.Fridas Redemption" + RESET);
                println(RED + "9.Benny The Evil King" + RESET);
                println(PURPLE + "╰┈➤10.Back to Player Menu" + RESET);
            }

        }
    }

}
