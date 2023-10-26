package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;

public class Medusa extends Attributes {

    public Medusa() {

        super(30,30, 25, 60, 0, 0, 5);
    }


    @Override
    public String attack() {

        return "Casts snakes";
    }

    @Override
    public void flee() {

        System.out.println("Medusa fleed");
    }

    @Override
    public void  dodge() {



    }

    @Override
    public String getName() {

        return "Medusa";
    }
}
