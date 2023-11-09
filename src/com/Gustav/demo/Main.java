package com.Gustav.demo;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Rooms.TheRoomOfRelics;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Rooms.TheRoomOfRiddles;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /**TODO-Dungeon Run
            Creat more bosses - IN PROGRESS - done
         *  Creat 3 more rooms that will be different from boss rooms-
         *  Remove e.PrintStackTrace() Deguging souts -
         *  Balans the game -
         *  Finish the Digging Room -
         *  WRITE LORE!!!
         *
         *
         *
         *
         *
         *
         *
         *
         */
        /*StartMenu startMenu = new StartMenu();
            startMenu.options();*/


        /*AAttributes medusa = new Medusa();
        AAttributes hunter = new Hunter();
        GameLogic play = new GameLogic();
        Scanner sc = new Scanner(System.in);
        play.fight(sc,hunter,medusa);*/

        Scanner sc = new Scanner(System.in);
        AAttributes hunter = new Hunter();
        TheRoomOfRelics r = new TheRoomOfRelics();
        r.roomOfRelicsOption(hunter,sc);








    }
}
