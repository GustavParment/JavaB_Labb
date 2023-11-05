package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class LaChancla extends AAttributes {
    public LaChancla() {
        super(0, 60, 40, 150, 0, 4, 45,30);
    }

    @Override
    public String attack() {
        return  "Throws a cat and a rat\n\uD83D\uDC08\uD83D\uDC01.ೃ࿔* .ೃ࿔* .ೃ࿔* .ೃ࿔* .ೃ࿔* .ೃ࿔* ";
    }

    @Override
    public void flee() {
        println(YELLOW + "La Chancla fled" + RESET);

    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED + "La Chancla" + RESET;
    }


}
