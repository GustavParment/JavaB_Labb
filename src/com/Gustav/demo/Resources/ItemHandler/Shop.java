package com.Gustav.demo.Resources.ItemHandler;

import com.Gustav.demo.Resources.ItemHandler.Items.*;
import com.Gustav.demo.Resources.Strings.LoreMasterKristoffer;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.MessageHandler.*;

public class Shop {

    public void buyItems() {

        boolean wrongInput = true;

        do {

            LoreMasterKristoffer returnTo = new LoreMasterKristoffer();
            Scanner sc = new Scanner(System.in);

            println("1.Book of Wisdom " + YELLOW_BOLD + " 20 gold " + RESET);
            println("2.Health Potion " + YELLOW_BOLD + " 20 gold " + RESET);
            println("3.Golem Heart Longbow " + YELLOW_BOLD + " 20 gold " + RESET);
            println("4.High Scholars Grand Staff " + YELLOW_BOLD + " 20 gold " + RESET);
            println("5.Lung Breaker Dagger" + YELLOW_BOLD + " 20 gold " + RESET);
            println("6.Return to Lore Master's Inn");

            ItemAttributes item = null;
            switch (sc.nextLine()) {
                case "1" -> {item = new BookOfWisdom();wrongInput = false;}
                case "2" -> {item = new HealthPotion();wrongInput = false;}
                case "3" -> {item = new GolemHeartLongbow();wrongInput = false;}
                case "4" -> {item = new HighScholarsGrandStaff();wrongInput = false;}
                case "5" -> {item = new LungBreakerDagger();wrongInput = false;}
                case "6" -> returnTo.loreMastersIn();

                default -> println(RED + "Wrong input" + RESET);
            }

        }
        while (wrongInput);


    }
}