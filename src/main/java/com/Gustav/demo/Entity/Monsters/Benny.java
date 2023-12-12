package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class Benny extends AAttributes {
    public Benny() {
        super(0, 70, 70, 400, 0, 7, 60, 100);
    }

    @Override
    public String attack() {
        return "Waves he's mighty sword!\n\uD83D\uDD2Aˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ ";
    }

    @Override
    public String dodge() {
        return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED+"\uD83D\uDC78Benny The Evil King\uD83D\uDC78"+RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Benny";
    }


}
