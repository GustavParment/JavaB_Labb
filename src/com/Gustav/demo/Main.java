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
         *  Creat a function for determine doge chance-Done
         *  Creat a shop class / The shopkeeper and Lore-master Kristoffer-DONE
         *  Creat a start menu determine how the game is starting-DONE
         *  Creat a currency - DONE
         *  Creat a function for bossLoot()(gold drop) - GOLD DROP DONE/ADD ITEM DROP?? - DONE
         *  Creat a function to see stats-Done
         *  Implements stats how much is you chance to doge/hit -DONE
         *  Creat Argument fight(Attributes boss)-DONE
         *  Make purchase item available - DONE
         *  Creat more bosses - IN PROGRESS
         *  Creat a damage calculator function which stats gives damage/Magical damage -DONE
         *  Fix fight method/When boss hp is 0 then fight is over
         *  Implement magicalDamage in fight method
         *  Display gold
         *
         *
         *
         *
         *
         */
        /*StartMenu startMenu = new StartMenu();
            startMenu.options();*/

        AAttributes medusa = new Medusa();
        AAttributes hunter = new Rogue();
        GameLogic play = new GameLogic();
        Scanner sc = new Scanner(System.in);
        play.fight(sc,hunter,medusa);







    }
}
