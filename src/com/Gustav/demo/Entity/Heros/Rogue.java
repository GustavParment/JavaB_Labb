package com.Gustav.demo.Entity.Heros;


import com.Gustav.demo.Entity.Attributes;


import static com.Gustav.demo.Paint.Colors.*;

public class Rogue extends Attributes {


    public Rogue() {
        super(20,5, 10, 50, 0, 0, 5);
    }

    @Override
    public String attack() {

        return "Slice and dice";

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

        return YELLOW + "Rouge" + RESET;
    }
}
