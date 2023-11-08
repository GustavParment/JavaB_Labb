package com.Gustav.demo.Entity.Rooms;

import com.Gustav.demo.Entity.Interface.AAttributes;
import java.util.Random;
import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class TheRoomOfRelics {

    public void roomOfRelicsOption(AAttributes attacker, Scanner sc) {
        println(PURPLE + BLACK_BACKGROUND + "♃♅♆ Room Of Relics ♆♅♃" + RESET);
        /*printDelay(PURPLE +  "Welcome " + attacker.getName() + PURPLE +
                " to pass this level you need to digg for certain relics to " +
                "\complete the puzzle. If you Complete the puzzle you will be abel to enter the next room...");

        */
        print("1.");

        digForRelic(sc);


    }

    private void digForRelic(Scanner sc) {
        boolean relicFound;

        do {

            println("Press \"Enter\" to dig! ");
            sc.nextLine();
            countTimeForDig();
            relicFound = chanceToFindRelic();

        }while (!relicFound);
    }

    protected int countTimeForDig() {


        for ( int i = 0; i < 5; i++) {

            println(" \uD83D\uDDFF⛏\uFE0F \uD83D\uDC77\uD83C\uDFFC\u200D♂\uFE0F");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    protected boolean chanceToFindRelic(){
        Random random = new Random();

        int ranNum = random.nextInt(5)+1;
        int num = 5;
        boolean relicFound;
        System.out.println("RANNUM: " + ranNum);
        System.out.println("NUM: " + num);
        if (ranNum < num){
            println(PURPLE + "You found a Relic" + RESET);
            relicFound = true;
        }else{
            println(RED + "No relic where found, Try another digging site" + RESET);
            relicFound = false;
        }

        return relicFound;
    }




}
