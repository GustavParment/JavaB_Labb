package com.Gustav.demo;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.GameLogic;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.Entity.StartMenu;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /**TODO-Dungeon Run
         *  Creat a function for determine doge chance-Done
         *  Creat a shop class / The shopkeeper and Lore-master Kristoffer-DONE
         *  Creat a start menu determine how the game is starting-DONE
         *  Creat a currency - DONE
         *  Creat a function for bossLoot()(gold drop) - GOLD DROP DONE/ADD ITEM DROP??
         *  Creat a function to see stats-Done
         *  Implements stats how much is you chance to doge/hit -DONE
         *  Creat Argument fight(Attributes boss)-DONE
         *  Make purchase item available - DONE
         *  Creat more bosses
         *  Creat a damage calculator function which stats gives damage/Magical damage
         *
         *
         *
         *
         */
        /* StartMenu startMenu = new StartMenu();
            startMenu.options();*/

        Attributes medusa = new Medusa();
        Attributes hunter = new Hunter();
        GameLogic play = new GameLogic();
        Scanner sc = new Scanner(System.in);
        play.fight(sc,hunter,medusa);






    }
}
