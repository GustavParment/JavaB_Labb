package com.Gustav.demo.Resources.ItemHandler;



import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.ItemHandler.Items.*;
import com.Gustav.demo.Resources.TheLoreMaster.LoreMasterKristoffer;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class Shop {

    public void buyItems(Attributes attacker,Scanner sc) {

        boolean wrongInput = true;

        ItemAttributes item;
        do {

            LoreMasterKristoffer returnTo = new LoreMasterKristoffer();

            println("1.Book of Wisdom " + YELLOW_BOLD + " 20 gold " + RESET);
            println("2.Health Potion " + YELLOW_BOLD + " 20 gold " + RESET);
            println("3.Golem Heart Longbow " + YELLOW_BOLD + " 35 gold " + RESET);
            println("4.High Scholars Grand Staff " + YELLOW_BOLD + " 35 gold " + RESET);
            println("5.Lung Breaker Dagger" + YELLOW_BOLD + " 35 gold " + RESET);
            println("6.Return to Lore Master's Inn");

            item = null;
            switch (sc.nextLine()) {
                case "1" -> {
                    item = new BookOfWisdom();

                    if(attacker.getGold() < 20){
                        System.out.println("Inefficient funds");
                    }
                    else{
                        attacker.setStrength(attacker.getStrength() + item.getStrength());
                        attacker.setAgility(attacker.getStrength() + item.getAgility());
                        attacker.setIntelligence(attacker.getStrength() + item.getIntelligence());
                    }


                }
                case "2" -> {
                    item = new HealthPotion();

                    if(attacker.getGold() < 35){
                        System.out.println("Inefficient funds");
                    }else{
                        attacker.setHealth(attacker.getStrength() + item.getHealth());
                    }

                }
                case "3" -> {
                    item = new GolemHeartLongbow();

                    if(attacker.getGold() < 35){
                        System.out.println("Inefficient funds");
                    }else{
                        attacker.setStrength(attacker.getStrength() + item.getStrength());
                        attacker.setAgility(attacker.getStrength() + item.getAgility());
                        attacker.setIntelligence(attacker.getStrength() + item.getIntelligence());
                    }

                }
                case "4" -> {
                    item = new HighScholarsGrandStaff();

                    if(attacker.getGold() < 35){
                        System.out.println("Inefficient funds");
                    }else{

                        attacker.setStrength(attacker.getStrength() + item.getStrength());
                        attacker.setAgility(attacker.getStrength() + item.getAgility());
                        attacker.setIntelligence(attacker.getStrength() + item.getIntelligence());
                    }


                }
                case "5" -> {
                    item = new LungBreakerDagger();

                  if (attacker.getGold() < 35){
                        System.out.println("Inefficient funds");
                    }else{
                      attacker.setStrength(attacker.getStrength() + item.getStrength());
                      attacker.setAgility(attacker.getStrength() + item.getAgility());
                      attacker.setIntelligence(attacker.getStrength() + item.getIntelligence());
                  }


                }
                case "6" -> {returnTo.loreMastersInn(attacker,sc); wrongInput = false;}

                default -> println(RED + "Wrong input" + RESET);
            }

        }
        while (wrongInput);



    }
}