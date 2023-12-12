package com.Gustav.demo.Entity.ItemHandler.Items;

import com.Gustav.demo.Entity.Interface.AItemAttributes;
import static com.Gustav.demo.Resources.Paint.Colors.*;

public class BookOfWisdom extends AItemAttributes {

    public BookOfWisdom() {
        super(10, 10, 10, 20);
    }

    @Override
    public String getName() {
        return YELLOW + "Book Of Wisdom" + RESET;

    }
}
