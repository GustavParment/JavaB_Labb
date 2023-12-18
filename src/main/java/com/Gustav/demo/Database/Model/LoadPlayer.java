package com.Gustav.demo.Database.Model;

import com.Gustav.demo.Database.DBConnection;
import com.Gustav.demo.Entity.Interface.AAttributes;


import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class LoadPlayer {
    private DBConnection db;
    private Scanner sc;

   public AAttributes enterPlayerID(AAttributes player) {
       db = new DBConnection();
       sc = new Scanner(System.in);

        db.openConnection();
        print("Enter Player id : ");


        return db.loadPlayerFromDB(sc.nextInt(),player);

    }
}


