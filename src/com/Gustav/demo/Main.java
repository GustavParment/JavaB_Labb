package com.Gustav.demo;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.GameLogic;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.MainMenu;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.Resources.Paint.Colors;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        /**TODO-Dungeon Run
         *  Creat a function for determine doge chance-Done
         *  Creat a shop class / The shopkeeper and Lore-master Kristoffer-DONE
         *  Creat a start menu determine how the game is starting-DONE
         *  Creat a currency
         *  Creat a function for bossLoot()(gold drop)
         *  Creat a function to see stats-Done
         *  Implements stats how much is you chance to doge/hit
         *  Creat Argument fight(Attributes boss)-DONE
         *
         *
         *
         */

        /*MainMenu mainMenu = new MainMenu();
        mainMenu.options();*/
        Scanner sc = new Scanner(System.in);
        Attributes medusa = new Medusa();
        Attributes hunter = new Hunter();
        GameLogic game = new GameLogic();

        game.fight(sc,hunter,medusa);

    }
}
