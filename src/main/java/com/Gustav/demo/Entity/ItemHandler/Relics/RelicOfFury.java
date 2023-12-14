package com.Gustav.demo.Entity.ItemHandler.Relics;

import com.Gustav.demo.Entity.Interface.ARelics;

import static com.Gustav.demo.Resources.Paint.Colors.BLUE_BOLD;
import static com.Gustav.demo.Resources.Paint.Colors.RESET;

public class RelicOfFury extends ARelics {

    public RelicOfFury() {
        super(0, 0, 0, 20);
    }

    @Override
    public String getName() {
        return BLUE_BOLD + "Relic Of Fury" + RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Relic Of Fury";
    }
}
