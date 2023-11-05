package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class BadDj extends AAttributes {
    public BadDj() {
        super(0, 0, 50, 200, 0, 5, 50, 30);
    }

    @Override
    public String attack() {
        return "Plays a terrible house song\n\uD83D\uDCBF\uD83C\uDFA7 ♫♪♬♪ ♫♪♬♪ ♫♪♬♪ ♫♪♬♪";
    }

    @Override
    public void flee() {
        println("The Bad Dj shuffles away");

    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED + "The Bad Dj" + RESET;
    }
}
