package com.Gustav.demo.Entity.ItemHandler.Items;

import com.Gustav.demo.Entity.Interface.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class SuperHealthPotion extends AItemAttributes {
    public SuperHealthPotion() {
        super(0, 0, 0, 100);
    }

    @Override
    public String getName() {
        return GREEN_BOLD + "Super Health Potion" + RESET;
    }
}
