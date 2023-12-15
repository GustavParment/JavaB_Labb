package com.Gustav.demo;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Medusa;
import com.Gustav.demo.Entity.Rooms.TheRoomOfRelics;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Rooms.TheRoomOfRiddles;
import com.Gustav.demo.GameEngine.DungeonRun;
import com.Gustav.demo.GameEngine.Menu.StartMenu;
import com.Gustav.demo.GameEngine.ScoreFile;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DungeonRun.runGame();
    }
}
