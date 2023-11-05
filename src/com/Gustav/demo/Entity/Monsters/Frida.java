package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class Frida extends AAttributes {
    public Frida() {
        super(0,70, 65, 300,0, 6, 55, 70);
    }

    @Override
    public String attack() {
        return "Throws flowers!\n\uD83C\uDF37⋆₊˚❀⋆₊˚❀⋆₊˚❀⋆₊˚❀⋆₊˚❀⋆₊˚❀";
    }

    @Override
    public void flee() {
        println(YELLOW + "Frida fled" + RESET);
    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED + "\uD83D\uDC78Frida\uD83D\uDC78" + RESET;
    }


}
