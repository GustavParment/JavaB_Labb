package com.Gustav.demo.Entity.ItemHandler;



import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Interface.AItemAttributes;

import com.Gustav.demo.Entity.ItemHandler.Items.*;
import com.Gustav.demo.Entity.TheLoreMaster.LoreMasterKristoffer;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class Shop {
    DBConnection db = DBConnection.getInstance();

    public void buyItems(AAttributes attacker, Scanner sc) {
        boolean wrongInput = true;
        AItemAttributes item;

        do {

            LoreMasterKristoffer returnTo = new LoreMasterKristoffer();
            println(YELLOW + BLACK_BACKGROUND + "☰ Kristoffer's Shop ☰" + RESET);

            println("📖" + "1.Book of Wisdom: " + YELLOW_BOLD + "20 gold" + RESET + "/"
                    + BLUE + "AGI:+10 SPIRIT:+10 STRNG:+10 HP:+20" + RESET);

            println("💗" + "2.Health Potion: " + YELLOW_BOLD + "20 gold" + RESET +
                    "/" + BLUE + "HP:+20" + RESET);

            println("🏹"+"3.Golem Heart Longbow: " + YELLOW_BOLD + "40 gold" + RESET + "/" +
                    BLUE + "AGI:+20 STRNG:+30 SPIRIT:+10" + RESET);

            println("✨"+ "4.High Scholars Grand Staff: " + YELLOW_BOLD + "40 gold" + RESET + "/" +
                    BLUE + "STRNG:+10 AGI:+20 SPIRIT:+30" + RESET);

            println("🔪" + "5.Lung Breaker Dagger: " + YELLOW_BOLD + "80 gold" + RESET + "/" +
                    BLUE + "AGI:+40 STRNG:+40 SPIRIT:40" + RESET);

            println("💗" + "6.Super Health Potion: " + YELLOW_BOLD + "80 gold" + RESET + "/" +
                    BLUE + "HP:+100" + RESET);
            println(BLUE + "7. [DEVELOPER TOOL]" + RESET);

            println(PURPLE + "╰┈➤8.Return to Lore Master's Inn" + RESET);

            switch (sc.nextLine()){
                case "1" -> {item = new BookOfWisdom();
                    item.setId(1);
                    withdraw20GoldAndAddStats(attacker, item);
                }
                case "2" -> {item = new HealthPotion();
                    item.setId(2);
                    withdraw20GoldAndAddStats(attacker, item);}
                case "3" -> {item = new GolemHeartLongbow();
                    item.setId(3);
                    withdraw40GoldAndAddStats(attacker, item);}
                case "4" -> {item = new HighScholarsGrandStaff();
                    item.setId(4);
                    withdraw40GoldAndAddStats(attacker, item);}
                case "5" -> {item = new LungBreakerDagger();
                    item.setId(5);
                    withdraw80GoldAndAddStats(attacker, item);}
                case "6" ->{item = new SuperHealthPotion();
                    item.setId(6);
                    withdraw80GoldAndAddStats(attacker,item);}
                case "7" -> devTool(attacker);
                case "8" -> {updatePlayerToDB(attacker);
                    returnTo.loreMastersInn(attacker, sc);
                    wrongInput = false;}
                default -> println(RED + "Wrong input" + RESET);
            }
        }
        while (wrongInput);


    }
    private void devTool(AAttributes attacker){
        attacker.setHealth(1000);
        attacker.setGold(1000);
        attacker.setStrength(80);
        attacker.setSpirit(70);
        attacker.setAgility(72);
        println(BLUE + "You are now in Developer mode" + RESET);
    }

    private void withdraw20GoldAndAddStats(AAttributes attacker, AItemAttributes item){
        if (attacker.getGold() < 20) {
            println("Inefficient funds");

        } else {
                writeItemToDB(item,attacker);
                attacker.setStrength(attacker.getStrength() + item.getStrength());
                attacker.setAgility(attacker.getAgility() + item.getAgility());
                attacker.setSpirit(attacker.getSpirit() + item.getSpirit());
                attacker.setHealth(attacker.getHealth() + item.getHealth());
                attacker.setGold(attacker.getGold() - 20);
                attacker.spiritCap(attacker);
                attacker.agilityCap(attacker);
                attacker.strengthCap(attacker);

                println(YELLOW + "You purchased " + item.getName());
                println(YELLOW + "Gold: "+ attacker.getGold() + RESET);

        }

    }

    private void withdraw40GoldAndAddStats(AAttributes attacker, AItemAttributes item){
        if (attacker.getGold() < 40) {
            println("Inefficient funds");

        } else {
            writeItemToDB(item,attacker);
            attacker.setStrength(attacker.getStrength() + item.getStrength());
            attacker.setAgility(attacker.getAgility() + item.getAgility());
            attacker.setSpirit(attacker.getSpirit() + item.getSpirit());
            attacker.setHealth(attacker.getHealth() + item.getHealth());
            attacker.setGold(attacker.getGold() - 40);
            attacker.spiritCap(attacker);
            attacker.agilityCap(attacker);
            attacker.strengthCap(attacker);

            println(YELLOW + "You purchased " + item.getName());
            println(YELLOW + "Gold: " + attacker.getGold() + RESET);


        }

    }

    private void withdraw80GoldAndAddStats(AAttributes attacker, AItemAttributes item){
        if (attacker.getGold() < 80) {
            println("Inefficient funds");

        } else {
            writeItemToDB(item,attacker);
            attacker.setStrength(attacker.getStrength() + item.getStrength());
            attacker.setAgility(attacker.getAgility() + item.getAgility());
            attacker.setSpirit(attacker.getSpirit() + item.getSpirit());
            attacker.setHealth(attacker.getHealth() + item.getHealth());
            attacker.setGold(attacker.getGold() - 80);
            attacker.spiritCap(attacker);
            attacker.agilityCap(attacker);
            attacker.strengthCap(attacker);


            println(YELLOW + "You purchased " + item.getName());
            println(YELLOW + "Gold: " + attacker.getGold() + RESET);

        }
    }

    private void writeItemToDB(AItemAttributes item, AAttributes player){
        db.openConnection();
        db.insertItem(item,player);

    }

    private void updatePlayerToDB(AAttributes player){
        db.updatePlayer(player);
    }
}


