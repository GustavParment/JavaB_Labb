package com.Gustav.demo.Entity.ItemHandler.Items;

import com.Gustav.demo.Entity.Interface.AItemAttributes;

import static com.Gustav.demo.Resources.Paint.Colors.*;

public class LungBreakerDagger extends AItemAttributes {


    public LungBreakerDagger() {
        super(40, 40, 40, 0);
    }


    @Override
    public String getName() {
        return YELLOW + "Lung Breaker Dagger" + RESET ;
    }

    @Override
    public String getNameNoColor() {
        return "Lung Breaker Dagger";
    }
}
