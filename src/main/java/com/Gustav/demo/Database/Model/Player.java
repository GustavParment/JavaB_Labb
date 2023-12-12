package com.Gustav.demo.Database.Model;

import com.Gustav.demo.Entity.Interface.AAttributes;

public class Player {

    private int playerID;
    private AAttributes playerClass;
    private AAttributes playerHealth;

    public Player(AAttributes playerClass,AAttributes playerHealth) {
        this.playerClass = playerClass;
        this.playerHealth = playerHealth;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public AAttributes getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(AAttributes playerClass) {
        this.playerClass = playerClass;
    }

    public AAttributes getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(AAttributes playerHealth) {
        this.playerHealth = playerHealth;
    }
}
