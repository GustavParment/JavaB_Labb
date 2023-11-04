package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Resources.Paint.Colors;

public class Necromancer extends AAttributes implements Colors {


    public Necromancer() {
        super(0,10, 10, 50,
                0, 0,5,0);


    }

    @Override
    public String attack() {

        return "Casts a death bolt!\n\uD83C\uDF00☠\uFE0F ─•~☠ ─•~☠ ─•~☠ ─•~☠ ─•~☠ ─•~☠";
    }

    @Override
    public void flee() {

        System.out.println( getName() +  " fled and lost 2 hp");
        setHealth(getHealth()-2);

    }

    @Override
    public String dodge() {


        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {

        return PURPLE_BOLD + "Necromancer" + RESET;
    }

}
