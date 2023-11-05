package com.Gustav.demo;

import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.*;
import com.Gustav.demo.GameEngine.GameLogic;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.GameEngine.Menu.StartMenu;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /**TODO-Dungeon Run
            Creat more bosses - IN PROGRESS
         *  Creat 3 more rooms that will be different from boss rooms-
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

        AAttributes medusa = new Medusa();
        AAttributes hunter = new Hunter();
        GameLogic play = new GameLogic();
        Scanner sc = new Scanner(System.in);
        play.fight(sc,hunter,medusa);







    }
}
