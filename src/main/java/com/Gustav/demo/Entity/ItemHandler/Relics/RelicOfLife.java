package com.Gustav.demo.Entity.ItemHandler.Relics;

import com.Gustav.demo.Entity.Interface.AItemAttributes;
import com.Gustav.demo.Entity.Interface.ARelics;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Paint.Colors.RESET;

public class RelicOfLife extends ARelics {

    public RelicOfLife() {
        super(200, 0, 0, 0);
    }

    @Override
    public String getName() {
        return BLUE_BOLD + "Relic Of Life" + RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Relic Of Life";
    }
}
