package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;




public class Rogue extends AAttributes implements Colors {


    public Rogue() {
        super(10, 0, 10, 50,
                0, 0, 5, 0);


    }

    @Override
    public String attack() {

        return "Slice and dice!\n☠\uFE0F\uD83D\uDD2A ⚅〴 ⚅〴 ⚅〴 ⚅〴 ⚅〴 ⚅〴";

    }

    @Override
    public void flee() {

        System.out.println(getName() + YELLOW + " fled and lost 2 hp" + RESET);
        setHealth(getHealth() - 2);


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




