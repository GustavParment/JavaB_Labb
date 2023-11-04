package com.Gustav.demo.Resources.ItemHandler.Items;

import com.Gustav.demo.Resources.ItemHandler.AItemAttributes;

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
