package com.Gustav.demo.Database;

import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Interface.AItemAttributes;
import com.Gustav.demo.Entity.Interface.ARelics;
import com.Gustav.demo.GameEngine.Menu.CharacterMenu;

import java.sql.*;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class DBConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/dungeonrun";
    private static final String USER = "root";
    private static final String PASSWORD = "2gfv77f6";
    private Connection connection;
    private CharacterMenu menu = new CharacterMenu();
    private static DBConnection instance;

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            println("Connection successful");

        } catch (SQLException error) {
            error.printStackTrace();
        }

    }

    public void closeConnection() {
        try {
            if (connection != null && connection.isClosed()) {

                connection.close();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertPlayer(AAttributes player) {
        String sql = "INSERT INTO player(" +
                "player_id," +
                "classname, " +
                "health, " +
                "spirit, " +
                "strength, " +
                "agility," +
                "damage," +
                "level," +
                "gold," +
                "RoomsCompleted," +
                "date " +
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
                "?," +
                "?," +
                "? " +
                ")";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setInt(1, player.getId());
            preparedStatement.setString(2, player.getNameNoColor());
            preparedStatement.setInt(3, player.getHealth());
            preparedStatement.setInt(4, player.getSpirit());
            preparedStatement.setInt(5, player.getStrength());
            preparedStatement.setInt(6, player.getAgility());
            preparedStatement.setInt(7, player.getDamage());
            preparedStatement.setInt(8, player.getLevel());
            preparedStatement.setInt(9, player.getGold());
            preparedStatement.setInt(10, player.getLevel());
            preparedStatement.setDate(11, java.sql.Date.valueOf(java.time.LocalDate.now()));
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if (returnedGeneratedKeys.next()) {
                player.setId(returnedGeneratedKeys.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePlayer(AAttributes player) {
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
                    "roomscompleted = ?," +
                    "date = ? " +
                    "WHERE player_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement
                    (
                            updateQuery,
                            Statement.RETURN_GENERATED_KEYS)
            ) {

                preparedStatement.setString(1, player.getNameNoColor());
                preparedStatement.setInt(2, player.getHealth());
                preparedStatement.setInt(3, player.getSpirit());
                preparedStatement.setInt(4, player.getStrength());
                preparedStatement.setInt(5, player.getAgility());
                preparedStatement.setInt(6, player.getDamage());
                preparedStatement.setInt(7, player.getLevel());
                preparedStatement.setInt(8, player.getGold());
                preparedStatement.setInt(9, player.getLevel());
                preparedStatement.setDate(10, java.sql.Date.valueOf(java.time.LocalDate.now()));
                preparedStatement.setInt(11, player.getId());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    println(BLUE + "Player updated successfully to player_id: " + player.getId() + RESET);

                } else {
                    println(RED + "Player not found or no changes made" + RESET);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public void insertItem(AItemAttributes item, AAttributes player) {
        String sql = "INSERT INTO itemhistory(player_id, item_id) VALUES (?,?)";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setInt(1, player.getId());
            preparedStatement.setInt(2, item.getId());
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if (returnedGeneratedKeys.next()) {
                item.setId(returnedGeneratedKeys.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRelic(ARelics relic, AAttributes player) {
        String sql = "INSERT INTO itemhistory(player_id, item_id) VALUES (?,?)";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)
        ) {

            preparedStatement.setInt(1, player.getId());
            preparedStatement.setInt(2, relic.getId());
            preparedStatement.executeUpdate();

            ResultSet returnedGeneratedKeys = preparedStatement.getGeneratedKeys();
            if (returnedGeneratedKeys.next()) {
                relic.setId(returnedGeneratedKeys.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void insertFightHistory(AAttributes player, AAttributes monster, String result) {
        String sql = "INSERT INTO fighthistory" +
                "(" +
                "DefenderHealth," +
                "DamageDoneByDefender," +
                "DamageDoneByAttacker, " +
                "Result," +
                "Time, " +
                "monster_id," +
                "player_id" +
                ")" +
                "VALUES " +
                "(" +
                "?," +
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
        ) {
            preparedStatement.setInt(1, monster.getHealth());
            preparedStatement.setInt(2, monster.getDamageDone());
            preparedStatement.setInt(3, player.getDamageDone());
            preparedStatement.setString(4, result);
            preparedStatement.setTime(5, java.sql.Time.valueOf(java.time.LocalTime.now()));
            preparedStatement.setInt(6, monster.getId());
            preparedStatement.setInt(7, player.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                println("Fight history added successfully");
            } else {
                println("Failed to add fight history");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public AAttributes loadPlayerFromDB(int id, AAttributes player) {
        String sql = "SELECT * FROM player WHERE player_id = ? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int health = resultSet.getInt("Health");

                if (health > 0) {
                    switch (resultSet.getString("ClassName")) {
                        case "Rogue" -> player = new Rogue();
                        case "Necromancer" -> player = new Necromancer();
                        case "Hunter" -> player = new Hunter();
                        case "Mage" -> player = new Mage();
                    }

                    player.setId(resultSet.getInt("player_id"));
                    player.setClassName(resultSet.getString("ClassName"));
                    player.setHealth(health); // Set health only if the player is alive
                    player.setSpirit(resultSet.getInt("Spirit"));
                    player.setStrength(resultSet.getInt("Strength"));
                    player.setAgility(resultSet.getInt("Agility"));
                    player.setDamage(resultSet.getInt("Damage"));
                    player.setLevel(resultSet.getInt("level"));
                    player.setGold(resultSet.getInt("Gold"));
                    player.setLevel(resultSet.getInt("RoomsCompleted"));
                } else {
                    println(RED + "This Character is dead start a new Class" + RESET);
                    menu.characterChooser();
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return player;
        }
        return player;
    }
}






