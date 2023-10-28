package com.Gustav.demo.Entity.Heros;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.Paint.Colors;



public class Hunter extends Attributes implements Colors {


    public Hunter() {
        super(10, 5, 20, 50, 0, 0, 5,0);
    }

    @Override
    public String attack() {

        return  "Shoots an arrow! >-> >->";
    }

    @Override
    public void flee() {

        System.out.println(YELLOW + getName() + " fled and lost 2 hp" + RESET);
        setHealth(getHealth() - 2);


    }

    @Override
    public void dodge() {


    }

    @Override
    public String getName() {

        return GREEN_BOLD + "Hunter" + RESET;
    }


}


