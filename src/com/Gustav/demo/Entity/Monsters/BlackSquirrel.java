package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class BlackSquirrel extends AAttributes {
    public BlackSquirrel() {
        super(0,0, 25, 110, 100, 3, 30,  20);
    }

    @Override
    public String attack() {
        return "Shoots lasers!\n\uD83C\uDF20 ==) ==) ==) ==) ==) ==)";
    }

    @Override
    public void flee() {
        println(YELLOW + "The Gigant Black Squirrel fled" + RESET);

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
