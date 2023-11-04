package com.Gustav.demo.Resources.ItemHandler.Items;

import com.Gustav.demo.Resources.ItemHandler.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.GREEN;
import static com.Gustav.demo.Resources.Paint.Colors.RESET;

public class HealthPotion extends AItemAttributes {


    public HealthPotion() {
        super(0, 0, 0, 20);
    }


    @Override
    public String getName() {
        return GREEN + "Health Potion" + RESET;
    }
}
