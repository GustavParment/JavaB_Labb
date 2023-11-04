package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Interface.AAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public class Benny extends AAttributes {
    public Benny() {
        super(0, 20, 70, 300, 0, 6, 60, 100);
    }

    @Override
    public String attack() {

        return "waves he's mighty sword\n\uD83D\uDD2Aˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ˋ•⁀/ ";
    }

    @Override
    public void flee() {

        println(YELLOW + "Benny fled" + RESET);

    }

    @Override
    public String dodge() {
      return GREEN + "dodged the attack and lost no HP" + RESET;
    }

    @Override
    public String getName() {
        return RED+"\uD83D\uDC78Benny The Evil King\uD83D\uDC78"+RESET;
    }


}
