package com.Gustav.demo.Entity.ItemHandler.Relics;

import com.Gustav.demo.Entity.Interface.AItemAttributes;
import com.Gustav.demo.Entity.Interface.ARelics;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class RelicOfProtection extends ARelics {

    public RelicOfProtection() {
        super(0, 30, 0, 0);
    }

    @Override
    public String getName() {
        return BLUE_BOLD + "Relic Of Protection" + RESET;
    }

    @Override
    public String getNameNoColor() {
        return "Relic Of Protection";
    }
}
