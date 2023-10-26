package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Attributes;

import static com.Gustav.demo.Paint.Colors.*;

public class Necromancer extends Attributes {


    public Necromancer() {
        super(10,20, 5, 50, 0, 0, 5);
    }

    @Override
    public String attack() {

        return "Casted a death bolt";
    }

    @Override
    public void flee() {

        System.out.println( getName() +  " fled and lost 2 hp");
        setHealth(getHealth()-2);

    }

    @Override
    public void dodge() {


    }

    @Override
    public String getName() {

        return MAGENTA + "Necromancer" + RESET;
    }


}
