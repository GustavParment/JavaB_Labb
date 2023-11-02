package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class BlackSquirrel extends AAttributes {
    public BlackSquirrel() {
        super(0,0, 30, 110, 100, 3, 30, 0, 40);
    }

    @Override
    public String attack() {

        return "Shoots a laser canon!\n ==) ==) ==) ==) ==)";
    }

    @Override
    public void flee() {

    }

    @Override
    public String dodge() {

        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED + "The Gigant Black Squirrel" + RESET;
    }


}
