package com.Gustav.demo.GameEngine;

import com.Gustav.demo.Entity.Interface.AAttributes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ScoreFile {

    public void writeScoreFile(AAttributes attacker) {

        try(
            Writer writer =
                    new BufferedWriter(
                    new OutputStreamWriter(
                    new FileOutputStream("ScoreFile.txt"), StandardCharsets.UTF_8)
                    )){


            int numOfRoomsCompleted = numOfRoomsCompleted(attacker);

            writer.write(
                        "Player Attributes on death" +
                            "\nRemaining Health: " + attacker.getHealth()+
                            "\nAgility: " + attacker.getAgility() +
                            "\nStrength: " + attacker.getStrength()+
                            "\nSpirit: " + attacker.getSpirit()+
                            "\nDamage: " + attacker.getDamage()+
                            "\nNumber of rooms completed: " + numOfRoomsCompleted +
                            "\nGold: " + attacker.getGold()+
                            "\n"

            );

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }
    public int numOfRoomsCompleted(AAttributes attacker) {
        List<AAttributes> roomCompList = new ArrayList<>();

        for (int i = 0; i < attacker.getLevel(); i++) {

            roomCompList.add(attacker);


        }
        return roomCompList.size();
    }
}
