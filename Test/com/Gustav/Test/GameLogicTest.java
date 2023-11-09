package com.Gustav.Test;

import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.Entity.Monsters.Benny;
import com.Gustav.demo.GameEngine.Menu.StartMenu;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;
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

    @Test
    void isFightDone() {
        AAttributes mage = new Mage();
        AAttributes benny = new Benny();

        mage.setHealth(mage.getHealth() - benny.getDamage());

        if (mage.getHealth() <= 0) {
            StartMenu start = new StartMenu();

            println(mage.getName() + " was defeated by "
                    + benny.getName() + RESET);

            println(BLACK + RED_BACKGROUND + "\uD83D\uDC80Game over\uD83D\uDC80" + RESET);
            printDelay(PURPLE_BOLD+"\nThanks for Playing better luck next time summoner...\n"
                    + RESET);


        }
        assertEquals(mage.getHealth(),-10);
    }


}



