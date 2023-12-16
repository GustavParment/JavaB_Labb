package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;

import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class CharacterMenu {
    Scanner sc;
    PlayerMenu menu;

    public void characterChooser() {
        sc = new Scanner(System.in);
        menu = new PlayerMenu();
        StartMenu start = new StartMenu();

        println(BLUE + BLACK_BACKGROUND + "☰ Choose class ☰" + RESET);
        println("1." + YELLOW + "Rogue" + RESET);
        println("2." + PURPLE + "Necromancer" + RESET);
        println("3." + GREEN + "Hunter" + RESET);
        println("4." + CYAN_BOLD + "Mage" + RESET);
        println(PURPLE + "╰┈➤5.Back to Start Menu" + RESET);

        AAttributes player = null;
        switch (sc.nextLine()) {
            case "1" -> {player = new Rogue(); writeNewPlayerToDB(player);}
            case "2" -> {player = new Necromancer(); writeNewPlayerToDB(player);}
            case "3" -> {player = new Hunter(); writeNewPlayerToDB(player);}
            case "4" -> {player = new Mage(); writeNewPlayerToDB(player);}
            case "5" -> start.options();
            default -> println("Wrong input");
        }

        menu.playerOption(player,sc);

    }

    private void writeNewPlayerToDB(AAttributes attacker){
        DBConnection db = new DBConnection();
        db.openConnection();
        db.insertPlayer(attacker);
    }
}
