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
                "date "+
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
                "? "  +
                ")";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)
           )
        {
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
                        "date = ? "+
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
                    preparedStatement.setInt(11,player.getId());

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

    public void insertMonster(AAttributes monster) {
        String sql = "INSERT INTO monster(" +
                "MonsterName," +
                "MonsterDamage," +
                "MonsterBaseHealth," +
                "MonsterSpirit," +
                "MonsterAgility," +
                "MonsterGold" +
                ")" +
                "VALUES (" +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?" +
                ")";
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(
                        sql, Statement.RETURN_GENERATED_KEYS)
            )
        {
            preparedStatement.setString(1, monster.getNameNoColor());
            preparedStatement.setInt(2, monster.getDamage());
            preparedStatement.setInt(3, monster.getHealth());
            preparedStatement.setInt(4,monster.getSpirit());
            preparedStatement.setInt(5,monster.getAgility());
            preparedStatement.setInt(6,monster.getGold());
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if (returnedGeneratedKeys.next()) {
                monster.setId(returnedGeneratedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void insertItem(AItemAttributes item,AAttributes player){
        String sql = "INSERT INTO itemhistory(ItemPurchased, player_id, item_id) VALUES (?,?,?)";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setString(1,item.getNameNoColor());
            preparedStatement.setInt(2,player.getId());
            preparedStatement.setInt(3,item.getId());

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

    public void insertFightHistory(AAttributes player, AAttributes monster){
        String sql = "INSERT INTO fighthistory(" +
                "Defender,"+
                "MonsterHealth,"+
                "DamageDoneByMonster," +
                "DamageDoneByPlayer, " +
                "Attacker," +
                "TimeOfFight," +
                "monster_id," +
                "player_id" +
                ")" +
                "VALUES (" +
                "?,"+
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?)";

        try(
                PreparedStatement preparedStatement = connection.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)
           )
        {
                preparedStatement.setString(1,monster.getNameNoColor());
                preparedStatement.setInt(2,monster.getHealth());
                preparedStatement.setInt(3,monster.getDamageDone());
                preparedStatement.setInt(4,player.getDamageDone());
                preparedStatement.setString(5,player.getNameNoColor());
                preparedStatement.setTime(6,java.sql.Time.valueOf(java.time.LocalTime.now()));
                preparedStatement.setInt(7,monster.getId());
                preparedStatement.setInt(8,player.getId());


                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                println("Fight history added successfully");
                } else {
                println("Failed to add fight history");
                }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    }


