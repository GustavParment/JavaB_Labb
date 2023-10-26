package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Attributes;

import static com.Gustav.demo.Paint.Colors.*;

public class Hunter extends Attributes {


    public Hunter() {
        super(10,5, 20, 50, 0, 0, 5);
    }

    @Override
    public String attack() {

        return "Shoots an Arrow";
    }

    @Override
    public void flee() {

        System.out.println(getName() + " fled and lost 2 hp");
        setHealth(getHealth()-2);


    }

    @Override
    public void dodge() {




    }

    @Override
    public String getName() {

        return GREEN + "Hunter" + RESET;
    }
}
