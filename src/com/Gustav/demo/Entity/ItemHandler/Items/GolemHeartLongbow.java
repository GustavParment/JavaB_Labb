package com.Gustav.demo.Entity.ItemHandler.Items;

import com.Gustav.demo.Entity.Interface.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class GolemHeartLongbow extends AItemAttributes {

    public GolemHeartLongbow() {
        super(30, 10, 20,0);
    }


    @Override
    public String getName() {
        return YELLOW + "Golem Heart Longbow" + RESET;

    }
}
