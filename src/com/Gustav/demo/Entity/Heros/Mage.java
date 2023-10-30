package com.Gustav.demo.Entity.Heros;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.Paint.Colors;

import static com.Gustav.demo.Resources.Print.PrintHandler.*;

public class Mage extends Attributes implements Colors {
    public Mage() {
        super(0, 20, 20, 50,
                0, 0, 5, 5, 0);
    }

    @Override
    public String attack() {
        return "Casts a bolt of fire!\n>>* >>* >>* >>* >>*";
    }

    @Override
    public void flee() {

        println(getName() +  " fled and lost 2 hp");
        setHealth(getHealth()-2);

    }

    @Override
    public String dodge() {


        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {

        return CYAN_BOLD + "Mage" + RESET;
    }
}
