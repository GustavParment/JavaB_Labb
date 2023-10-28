package com.Gustav.Test;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Rogue;
import com.Gustav.demo.Entity.Monsters.Medusa;
import org.junit.jupiter.api.Test;


import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.MessageHandler.*;
import static org.junit.jupiter.api.Assertions.*;


class LevelUpTest {

    @Test
    void levelUp() {

        Attributes rogue = new Rogue();

        for (int i = 0; i < 5; i++) {

            rogue.setExperience(rogue.getExperience() + 500);
            rogue.setLevel(rogue.getLevel() + 1);
            System.out.println(i);
            println(YELLOW_BOLD + "you gained 100 xp" + RESET);
            println(BLUE_BOLD + "You reached level: " + rogue.getLevel() + RESET);


        }
        println("Total xp Gained: " + rogue.getExperience());
        assertEquals(rogue.getLevel(), 5);
    }

    @Test
    void bossKillExp() {

        Attributes medusa = new Medusa();
        Attributes hunter = new Hunter();

        hunter.setLevel(0);
        medusa.setHealth(0);

        println("BEFORE " + hunter.getLevel());

        if (medusa.getHealth() == 0) {

            hunter.setExperience(hunter.getExperience() + 100);

            hunter.levelUp(hunter);
            println("AFTER " + hunter.getLevel());

            assertEquals(hunter.getLevel(), 1);
        }

    }
}





