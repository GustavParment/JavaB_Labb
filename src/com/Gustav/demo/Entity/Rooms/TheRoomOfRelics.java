package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Interface.ARelics;
import com.Gustav.demo.Entity.ItemHandler.Relics.RelicOfFury;
import com.Gustav.demo.Entity.ItemHandler.Relics.RelicOfLife;
import com.Gustav.demo.Entity.ItemHandler.Relics.RelicOfProtection;

import java.util.*;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;

public class TheRoomOfRelics {
    RelicOfLife relicOfLife;
    RelicOfProtection relicOfProtection;
    RelicOfFury relicOfFury;

    public void roomOfRelicsOption(AAttributes attacker, Scanner sc) {
        println(PURPLE + BLACK_BACKGROUND + "♃♅♆ Room Of Relics ♆♅♃" + RESET);
        printDelay(PURPLE + "Welcome to the Room Of Relics " + attacker.getName()+"."
                + PURPLE +
                "\nHere you can dig for Relics that will will be beneficial for your Attributes" +
                "\nBut be aware travelers have dug these grounds for years without finding anything ");
        digForRelic(attacker,sc);
    }

    private void digForRelic(AAttributes attacker,Scanner sc) {
        boolean relicFound;

        do {
            println("\nPress \"Enter\" to dig! ");
            println("╰┈➤1.Return to Rooms");
            sc.nextLine();
            countTimeForDig();
            relicFound = chanceToFindRelic(attacker);
            if (sc.nextLine().contains("1")){

            }


        }while (!relicFound);
    }


    private void countTimeForDig() {
        for ( int i = 0; i < 5; i++) {
            println("\uD83D\uDDFF⛏\uFE0F \uD83D\uDC77\uD83C\uDFFC\u200D♂\uFE0F");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean chanceToFindRelic(AAttributes attacker){
        Random random = new Random();
        int ranNum = random.nextInt(5)+1;
        int num = 5;
        boolean relicFound;

        println("RANNUM: " + ranNum);
        println("NUM: " + num);

        if (ranNum < num){
            println(PURPLE + "You found "+ RESET);
            switch(generateRelics()){
                case 0 ->{attacker.setStrength(attacker.getStrength() +
                        relicOfFury.getRelicStrength());}
                case 1 ->{attacker.setHealth(attacker.getHealth() +
                        relicOfProtection.getRelicHealth());}
                case 2 -> attacker.setSpirit(attacker.getSpirit() +
                        relicOfLife.getRelicSpirit());
            }

            relicFound = true;
        }else{
            println(RED + "No relic where found, Try another digging site" + RESET);
            relicFound = false;
        }

        return relicFound;
    }

    public int generateRelics(){
        List<ARelics> relicList = new ArrayList<>(relics());
        Random random = new Random();
        int ranNum = random.nextInt(3);

        println(relicList.get(ranNum).getName());

       return ranNum;
    }

    public List<ARelics> relics(){
        relicOfFury = new RelicOfFury();
        relicOfLife = new RelicOfLife();
        relicOfProtection = new RelicOfProtection();

        return Arrays.asList(relicOfFury,relicOfLife,relicOfProtection);
    }
}
