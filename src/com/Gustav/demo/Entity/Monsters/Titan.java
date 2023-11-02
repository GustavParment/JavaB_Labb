package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.AAttributes;
import static com.Gustav.demo.Resources.Paint.Colors.*;


public class Titan extends AAttributes {

    public Titan() {
        super(0,0, 30, 80,
                0, 1, 15,10,30);
    }

    @Override
    public String attack() {

        return "Throws a big Rock\n ^ * ^ * ^ * ^ * ^ *";
    }

    @Override
    public void flee() {

        System.out.println("Titan runs away");

    }

    @Override
    public String dodge() {

        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {

        return RED + "Titan" + RESET;
    }


}
