package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;

public class Titan extends Attributes {


    public Titan() {
        super(10,20, 20, 100, 0, 1, 20);
    }

    @Override
    public String attack() {


        return "Stomps the ground";
    }

    @Override
    public void flee() {

        System.out.println("Titan runs away");

    }

    @Override
    public void dodge() {


    }

    @Override
    public String getName() {

        return "Titan";
    }


}
