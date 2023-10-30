package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;
import static com.Gustav.demo.Resources.Paint.Colors.*;


public class Titan extends Attributes {

    public Titan() {
        super(25,25, 30, 80,
                0, 1, 10,10,20);
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
