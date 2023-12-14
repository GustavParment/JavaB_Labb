package com.Gustav.demo.Database;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Interface.AItemAttributes;

import java.sql.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

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
        if (connection != null && connection.isClosed()){

            connection.close();

        }


    }catch (SQLException e){
        e.printStackTrace();
    }
    }

   /* public void createPlayerTable() {
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
                "primary KEY(player_id)" +
                ")";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

        }
    }         */

    public void insertPlayer(AAttributes player){
        String sql = "INSERT INTO player(" +
                "player_id," +
                "classname, " +
                "health, " +
                "spirit, " +
                "strength, " +
                "agility," +
                "damage," +
                "level," +
                "gold,"+
                "monsterskilled,"+
                "date,"+
                "time"+
                ") " +
                "VALUES(" +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?,"  +
                "?,"  +
                "?,"  +
                "?"+
                ")";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1, player.getId());
            preparedStatement.setString(2,player.getNameNoColor());
            preparedStatement.setInt(3,player.getHealth());
            preparedStatement.setInt(4,player.getSpirit());
            preparedStatement.setInt(5,player.getStrength());
            preparedStatement.setInt(6,player.getAgility());
            preparedStatement.setInt(7,player.getDamage());
            preparedStatement.setInt(8,player.getLevel());
            preparedStatement.setInt(9,player.getGold());
            preparedStatement.setInt(10,player.getLevel());
            preparedStatement.setDate(11,java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.setTime(12,java.sql.Time.valueOf(java.time.LocalTime.now()));
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if(returnedGeneratedKeys.next())
            {
                player.setId(returnedGeneratedKeys.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePlayer(AAttributes player, AAttributes monster) {
            try {
                openConnection();

                String updateQuery = "UPDATE player SET " +
                        "classname = ?," +
                        "health = ?," +
                        "spirit = ?, " +
                        "strength = ?," +
                        "agility = ?, " +
                        "damage = ?," +
                        "level = ?, " +
                        "gold = ?, " +
                        "monsterskilled = ?,"+
                        "date = ?, "+
                        "time = ?, " +
                        "monster_id = ? " +
                        "WHERE player_id = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement
                        (
                        updateQuery,
                        Statement.RETURN_GENERATED_KEYS)
                ) {

                    preparedStatement.setString(1,player.getNameNoColor());
                    preparedStatement.setInt(2,player.getHealth());
                    preparedStatement.setInt(3,player.getSpirit());
                    preparedStatement.setInt(4,player.getStrength());
                    preparedStatement.setInt(5,player.getAgility());
                    preparedStatement.setInt(6,player.getDamage());
                    preparedStatement.setInt(7,player.getLevel());
                    preparedStatement.setInt(8,player.getGold());
                    preparedStatement.setInt(9,player.getLevel());
                    preparedStatement.setDate(10, java.sql.Date.valueOf(java.time.LocalDate.now()));
                    preparedStatement.setTime(11,java.sql.Time.valueOf(java.time.LocalTime.now()));
                    preparedStatement.setInt(12,monster.getId());
                    preparedStatement.setInt(13,player.getId());

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        println("Player updated successfully to player_id: " + player.getId());

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


    /*public void createPlayerHistoryTable(AAttributes player){
        String sql = "CREATE TABLE IF NOT EXISTS playerhistory " +
                "(" +
                "playerhistory_id INT NOT NULL AUTO_INCREMENT, classname varchar(50), )";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {

            System.out.println(e);

        }


    }  */

    public void insertMonster(AAttributes monster) {
        println("monster_id " + monster.getId());
        String sql = "INSERT INTO monster(" +
                "name," +
                "damage," +
                "health)" +
                "VALUES (" +
                "?," +
                "?," +
                "?)";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, monster.getNameNoColor());
            preparedStatement.setInt(2, monster.getDamage());
            preparedStatement.setInt(3, monster.getHealth());
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if (returnedGeneratedKeys.next()) {
                monster.setId(returnedGeneratedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateMonster(AAttributes monster){
        String sql = "UPDATE monster " +
                "SET " +
                "name = ?, " +
                "damage = ?, " +
                "health = ? " +
                "WHERE monster_id = ?";
     try(
             PreparedStatement preparedStatement = connection.prepareStatement(
             sql,Statement.RETURN_GENERATED_KEYS)
     ){
            preparedStatement.setString(1,monster.getNameNoColor());
            preparedStatement.setInt(2,monster.getDamage());
            preparedStatement.setInt(3,monster.getHealth());
            preparedStatement.setInt(4,monster.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0){
                println("Monster updated successfully to monster_id: " + monster.getId());

            }else{
                 println("Monster not found or no changes made");
            }

     }catch (SQLException e){
         e.printStackTrace();

     }



    }

    public void updateItems(AItemAttributes item){
        String sql = "UPDATE playeritem SET ItemsPurchased " +
                "WHERE item_id = ?";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setString(2,item.getNameNoColor());
            preparedStatement.setInt(2,item.getId());

            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if(returnedGeneratedKeys.next())
            {
                item.setId(returnedGeneratedKeys.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }


