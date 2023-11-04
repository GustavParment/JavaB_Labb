package com.Gustav.demo.Resources.ItemHandler.Items;

import com.Gustav.demo.Resources.ItemHandler.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class GolemHeartLongbow extends AItemAttributes {

    public GolemHeartLongbow() {
        super(20, 10, 20,0);
    }


    @Override
    public String getName() {
        return YELLOW + "Golem Heart Longbow" + RESET;

    }
}
