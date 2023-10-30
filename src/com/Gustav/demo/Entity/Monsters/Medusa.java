package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Resources.Paint.Colors;

import static com.Gustav.demo.Resources.Print.PrintHandler.println;


public class Medusa extends Attributes implements Colors {

    public Medusa() {

        super(30,30, 15, 5,
                0, 0, 5,5,20);
    }

    @Override
    public String attack() {

        return "Casts snakes!\n~~< ~~< ~~< ~~< ~~<";
    }

    @Override
    public void flee() {

       println(YELLOW + "Medusa fled" + RESET);
    }

    @Override
    public String dodge() {

    return GREEN + "dodged the attack and lost no HP" + RESET;

    }

    @Override
    public String getName() {

        return  RED + "Medusa" + RESET;
    }


}
