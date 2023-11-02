package com.Gustav.Test;

import com.Gustav.demo.Entity.AAttributes;
import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Resources.ItemHandler.ItemAttributes;
import com.Gustav.demo.Resources.ItemHandler.Items.*;
import org.junit.jupiter.api.Test;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Paint.Colors.RESET;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void buyItems() {

        AAttributes attacker = new Mage();

        attacker.setGold(attacker.getGold() + 20);
        println("GOLD BEFORE PURCHASE: " + attacker.getGold());


        int input = 1;
        ItemAttributes item;


                item = null;
                switch (input) {
                    case 1 -> {

                        item = new BookOfWisdom();

                        if(attacker.getGold() < 20){
                            System.out.println("Inefficient funds");
                        }
                        else{
                            attacker.setStrength(attacker.getStrength() + item.getStrength());
                            attacker.setAgility(attacker.getStrength() + item.getAgility());
                            attacker.setIntelligence(attacker.getStrength() + item.getIntelligence());
                            attacker.setGold(attacker.getGold() - 20);
                            println("GOLD AFTER PURCHASE: " + attacker.getGold());

                            assertEquals(attacker.getGold(), 0);
                        }

                    }
                    default -> println(RED + "Wrong input" + RESET);
                }





        }
    }

