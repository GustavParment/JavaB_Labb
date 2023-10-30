package com.Gustav.demo.Resources.ItemHandler;



import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.ItemHandler.Items.*;
import com.Gustav.demo.Resources.TheLoreMaster.LoreMasterKristoffer;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class Shop {

    public void buyItems(Attributes attacker, Scanner sc) {

        boolean wrongInput = true;
        ItemAttributes item;

        do {

            LoreMasterKristoffer returnTo = new LoreMasterKristoffer();
            println(CYAN_BACKGROUND_BRIGHT + "---Kristoffer's Shop---" + RESET);
            println("1.Book of Wisdom: " + YELLOW_BOLD + "20 gold" + RESET + "/"
                    + BLUE + "AGI:+10 INTEL:+10 STRNG:+10" + RESET);
            println("2.Health Potion: " + YELLOW_BOLD + "20 gold" + RESET +
                    "/" + BLUE + "HP:+10" + RESET);
            println("3.Golem Heart Longbow: " + YELLOW_BOLD + "35 gold" + RESET + "/" +
                    BLUE + "AGI:+20 STRNG:+20" + RESET);
            println("4.High Scholars Grand Staff: " + YELLOW_BOLD + "35 gold" + RESET + "/" +
                    BLUE + "INTEL:+20 AGI:+20" + RESET);
            println("5.Lung Breaker Dagger: " + YELLOW_BOLD + "35 gold" + RESET + "/" +
                    BLUE + "AGI:+20 STRNG:+20" + RESET);
            println("6.Return to Lore Master's Inn");

            item = null;
            switch (sc.nextLine()){
                case "1" -> {item = new BookOfWisdom();
                    withdraw20Gold(attacker, item);}
                case "2" -> {item = new HealthPotion();
                    withdraw20Gold(attacker, item);}
                case "3" -> {item = new GolemHeartLongbow();
                    withdraw30Gold(attacker, item);}
                case "4" -> {item = new HighScholarsGrandStaff();
                    withdraw30Gold(attacker, item);}
                case "5" -> {item = new LungBreakerDagger();
                    withdraw30Gold(attacker, item);}
                case "6" -> {returnTo.loreMastersInn(attacker, sc);wrongInput = false;}
                default -> println(RED + "Wrong input" + RESET);
            }
        }
        while (wrongInput);


    }

    private void withdraw20Gold(Attributes attacker, ItemAttributes item){

        if (attacker.getGold() < 20) {

            println("Inefficient funds");

        } else {
                attacker.setStrength(attacker.getStrength() + item.getStrength());
                attacker.setAgility(attacker.getStrength() + item.getAgility());
                attacker.setIntelligence(attacker.getIntelligence() + item.getIntelligence());
                attacker.setGold(attacker.getGold() - 20);

        }
    }

    private void withdraw30Gold(Attributes attacker, ItemAttributes item){
        if (attacker.getGold() < 35) {

            println("Inefficient funds");

        }
        else {
            attacker.setStrength(attacker.getStrength() + item.getStrength());
            attacker.setAgility(attacker.getStrength() + item.getAgility());
            attacker.setIntelligence(attacker.getIntelligence() + item.getIntelligence());
            attacker.setGold(attacker.getGold() - 35);

        }
    }
    }


