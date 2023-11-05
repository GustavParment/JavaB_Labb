package com.Gustav.Test;

import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Interface.AAttributes;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    @Test
    void chanceOnHealthReg(){

        AAttributes rouge = new Rogue();

        Random random = new Random();
        int ranNum = random.nextInt(20);
        int num = 20;

        rouge.setSpirit(rouge.getSpirit() + 70);

        if (ranNum < num && rouge.getSpirit() >= 30) rouge.calculateHealthReg(rouge);

        assertEquals(rouge.getHealth(), 70);
    }
}



