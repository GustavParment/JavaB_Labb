package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.Paint.Colors;


public class Medusa extends Attributes implements Colors {

    public Medusa() {

        super(30,30, 15, 5, 0, 0, 5,5);
    }


    @Override
    public String attack() {

        return "Casts snakes! ~~< ~~< ";
    }

    @Override
    public void flee() {

        System.out.println(YELLOW + "Medusa fled" + RESET);
    }

    @Override
    public void  dodge() {



    }

    @Override
    public String getName() {

        return  RED + "Medusa" + RESET;
    }


}
