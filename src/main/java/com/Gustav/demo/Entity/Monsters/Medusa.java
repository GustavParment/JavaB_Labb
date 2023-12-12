package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;

import static com.Gustav.demo.Resources.Print.PrintHandler.println;


public class Medusa extends AAttributes implements Colors {

    public Medusa() {

        super(0,0, 3, 45,
                0, 1, 5,20);
    }

    @Override
    public String attack() {
        return "Casts snakes!\n\uD83D\uDC0D ~~< ~~< ~~< ~~< ~~< ~~<";
    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return  RED + "Medusa" + RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Medusa";
    }


}
