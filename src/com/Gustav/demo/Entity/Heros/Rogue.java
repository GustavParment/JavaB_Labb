package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;




public class Rogue extends AAttributes implements Colors {


    public Rogue() {
        super(10, 0, 20, 50,
                0, 0, 10, 0, 0);


    }

    @Override
    public String attack() {

        return "Slice and dice!\n`/ `/ `/ `/ `/ `/ ";

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




