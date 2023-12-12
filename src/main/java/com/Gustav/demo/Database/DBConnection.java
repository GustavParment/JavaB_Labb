package com.Gustav.demo.Database;

import com.Gustav.demo.Database.Model.Player;
import com.Gustav.demo.Entity.Interface.AAttributes;

import java.sql.*;

import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class DBConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/dungeonrun";
    private static final String USER = "root";
    private static final String PASSWORD = "2gfv77f6";

    Connection connection;

    public void openConnection(){
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            println("Connection successful");

        }catch(SQLException error){
            error.printStackTrace();
        }

    }

    public void closeConnection(){
    try{
        if (connection != null && connection.isClosed()) connection.close();

    }catch (SQLException e){
        e.printStackTrace();
    }
    }



    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS player " +
                "(" +
                "player_id INT NOT NULL AUTO_INCREMENT, " +
                "classname VARCHAR(100), " +
                "health INT, " +
                "spirit INT," +
                "strength INT," +
                "agility INT," +
                "damage INT," +
                "level INT," +
                "gold INT," +
                "primary KEY(player_id))";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

        }
    }

    public void insertPlayer(AAttributes player){
        int incrementID = 0;
        String sql = "INSERT INTO player (player_id," +
                "classname, " +
                "health, " +
                "spirit, " +
                "strength, " +
                "agility," +
                "damage," +
                "level," +
                "gold" +
                ") " +
                "VALUES " +
                "(" +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?" +
                ")";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1, player.getPlayer_id());
            preparedStatement.setString(2,player.getNameNoColor());
            preparedStatement.setInt(3,player.getHealth());
            preparedStatement.setInt(4,player.getSpirit());
            preparedStatement.setInt(5,player.getStrength());
            preparedStatement.setInt(6,player.getAgility());
            preparedStatement.setInt(7,player.getDamage());
            preparedStatement.setInt(8,player.getLevel());
            preparedStatement.setInt(9,player.getGold());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            while(generatedKeys.next()) incrementID = generatedKeys.getInt(1);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void updatePlayer(AAttributes player) {
            try {
                openConnection();

                String updateQuery = "UPDATE player SET " +
                        "health = ?, " +
                        "spirit = ?, " +
                        "strength = ?," +
                        "agility = ?," +
                        "damage = ?," +
                        "level = ?," +
                        "gold = ?," +
                        "WHERE player_id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                    preparedStatement.setInt(1, player.getPlayer_id());
                    preparedStatement.setString(2,player.getNameNoColor());
                    preparedStatement.setInt(3,player.getHealth());
                    preparedStatement.setInt(4,player.getSpirit());
                    preparedStatement.setInt(5,player.getStrength());
                    preparedStatement.setInt(6,player.getAgility());
                    preparedStatement.setInt(7,player.getDamage());
                    preparedStatement.setInt(8,player.getLevel());
                    preparedStatement.setInt(9,player.getGold());
                    preparedStatement.executeUpdate();

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        println("Player updated successfully");
                    } else {
                        println("Player not found or no changes made");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

    }


