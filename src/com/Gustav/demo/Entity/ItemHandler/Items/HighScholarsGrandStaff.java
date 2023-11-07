package com.Gustav.demo.Entity.ItemHandler.Items;

import com.Gustav.demo.Entity.ItemHandler.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class HighScholarsGrandStaff extends AItemAttributes {


    public HighScholarsGrandStaff() {
        super(10, 30, 20, 0);
    }

    @Override
    public String getName() {
        return YELLOW + "High Scholar Grand Staff" + RESET;
    }
}
