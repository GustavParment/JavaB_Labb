package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;

import static com.Gustav.demo.Resources.Print.PrintHandler.println;


public class Rogue extends AAttributes implements Colors {
    public Rogue() {
        super(0, 0, 8, 50,
                0, 0, 5, 0);


    }

    @Override
    public String attack() {
        return "Slice and dice!\n☠\uFE0F\uD83D\uDD2A ⚅〴 ⚅〴 ⚅〴 ⚅〴 ⚅〴 ⚅〴";

    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return YELLOW_BOLD + "Rouge" + RESET;
    }
}




