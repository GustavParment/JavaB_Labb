package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.TheLoreMaster.LoreMasterKristoffer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.print;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class PlayerMenu {
    private RoomMenu menu;
    private DBConnection db;
    private StartMenu start;

    public void playerOption(AAttributes attacker, Scanner sc) {
        db = new DBConnection();
        menu = new RoomMenu();
        start = new StartMenu();

        LoreMasterKristoffer enter = new LoreMasterKristoffer();
        boolean input = false;

        do {
            println("\n" + PURPLE + BLACK_BACKGROUND + "☰ Player Menu ☰" + RESET);
            println("1.Lore Master Kristoffer's Inn");
            println("2.Enter new Room");
            println("3.Player Attributes");
            println("4.View Fight History");
            println(PURPLE + "╰┈➤5.Back to Start Menu" + RESET);

            switch (sc.nextLine()) {
                case "1" -> {
                    enter.loreMastersInn(attacker, sc);
                    input = true;
                }
                case "2" -> {
                    menu.roomChooser(attacker, sc);
                    input = true;
                }
                case "3" -> attacker.getStatus(attacker);
                case "4" -> viewFightHistory(attacker.getId());
                case "5" -> start.options();

                default -> println(RED + "Wrong input try again..." + RESET);
            }

        } while (!input);
    }

    private void viewFightHistory(int playerId) {
        db.openConnection();
        try {
            String sql = "SELECT * FROM fighthistory WHERE player_id = ?";
            try (PreparedStatement preparedStatement = db.getConnection().prepareStatement(sql)) {
                preparedStatement.setInt(1, playerId);

                ResultSet resultSet = preparedStatement.executeQuery();
                println("\n" + PURPLE + BLACK_BACKGROUND + "☰ Fight History ☰" + RESET);

                while (resultSet.next()) {
                    println(BLUE_BOLD + "Fight ID: " + resultSet.getInt("fighthistory_id"));
                    println("Defender Health: " + resultSet.getInt("DefenderHealth"));
                    println("Damage Done by Defender: " + resultSet.getInt("DamageDonebyDefender"));
                    println("Attacker Health: " + resultSet.getInt("AttackerHealth"));
                    println("Damage Done by Attacker: " + resultSet.getInt("DamageDoneByAttacker"));
                    println("Result: " + resultSet.getString("Result"));
                    println("Times: " + resultSet.getString("Time"));
                    println("Date of fight: " + resultSet.getString("Date"));
                    println("Monster ID: " + resultSet.getInt("monster_id"));
                    println("Player ID: " + resultSet.getInt("player_id"));

                    println(RED + "--------------------------------------" + RESET);

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





