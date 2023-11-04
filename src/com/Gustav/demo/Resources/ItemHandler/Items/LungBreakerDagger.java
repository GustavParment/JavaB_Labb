package com.Gustav.demo.Resources.ItemHandler.Items;

import com.Gustav.demo.Resources.ItemHandler.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class LungBreakerDagger extends AItemAttributes {


    public LungBreakerDagger() {
        super(30, 30, 30, 0);
    }


    @Override
    public String getName() {
        return YELLOW + "Lung Breaker Dagger" + RESET ;
    }
}
