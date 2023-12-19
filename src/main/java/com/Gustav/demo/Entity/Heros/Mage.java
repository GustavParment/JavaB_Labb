package com.Gustav.demo.Entity.Heros;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;

import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class Mage extends AAttributes implements Colors {
    public Mage() {
        super(0, 0, 8, 50, 0, 0, 5, 0);


    }

    @Override
    public String attack() {
        return "Casts a bolt of fire!\n\uD83D\uDD25 >>҉ >>҉ >>҉ >>҉ >>҉ >>҉";
    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return CYAN_BOLD + "Mage" + RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Mage";
    }


}
