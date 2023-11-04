package com.Gustav.demo.Entity.Heros;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;


public class Hunter extends AAttributes implements Colors {


    public Hunter() {
        super(10, 0, 10, 50,
                0, 0, 5,0);


    }

    @Override
    public String attack() {

        return "Shoots arrows!\n\uD83C\uDFF9 »-► »-► »-► »-► »-► »-►";
    }

    @Override
    public void flee() {

        System.out.println(YELLOW + getName() + " fled and lost 2 hp" + RESET);
        setHealth(getHealth() - 2);


    }

    @Override
    public String dodge() {


        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {

        return GREEN_BOLD + "Hunter" + RESET;
    }

}





