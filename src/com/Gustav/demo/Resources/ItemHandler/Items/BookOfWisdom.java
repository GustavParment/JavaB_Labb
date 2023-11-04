package com.Gustav.demo.Resources.ItemHandler.Items;

import com.Gustav.demo.Resources.ItemHandler.AItemAttributes;
import static com.Gustav.demo.Resources.Paint.Colors.*;

public class BookOfWisdom extends AItemAttributes {

    public BookOfWisdom() {
        super(10, 10, 10, 10);
    }

    @Override
    public String getName() {
        return YELLOW + "Book Of Wisdom" + RESET;

    }
}
