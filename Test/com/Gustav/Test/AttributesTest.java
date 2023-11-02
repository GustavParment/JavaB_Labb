package com.Gustav.Test;

import com.Gustav.demo.Entity.AAttributes;
import com.Gustav.demo.Entity.Heros.Mage;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import org.junit.jupiter.api.Test;

import static com.Gustav.demo.Resources.Print.PrintHandler.*;

class AttributesTest {

    @Test
    void calculateDamageStrength() {

        AAttributes attacker = new Rogue();

        int damage = attacker.getDamage();

        println("ORIGINAL STRENGTH " + attacker.getStrength());
        println("DAMAGE BEFORE STRENGTH ADD:" + attacker.getDamage());

            attacker.setStrength(attacker.getStrength() + 10);

            if (attacker.getStrength() > 10 && attacker.getStrength() % 10 == 0){

                damage += 10;

                attacker.setDamage(damage);

            }
        println("NEW STRENGTH " + attacker.getStrength());
        println("DAMAGE AFTER STRENGTH ADD " + attacker.getDamage());

    }
    @Test
    void calculateDamageIntelligence(){

        AAttributes attacker = new Necromancer();

        int magicalDamage = attacker.getMagicDamage();

        println("ORIGINAL INTELLIGENCE " + attacker.getIntelligence());
        println("MAGICAL DAMAGE BEFORE INTELLIGENCE ADD:" + attacker.getMagicDamage());

        attacker.setIntelligence(attacker.getIntelligence() + 10);

        if (attacker.getIntelligence() > 10 && attacker.getIntelligence() % 10 == 0){

            magicalDamage += 10;

            attacker.setMagicDamage(magicalDamage);

        }
        println("NEW INTELLIGENCE " + attacker.getIntelligence());
        println("MAGICAL DAMAGE AFTER INTELLIGENCE ADD " + attacker.getMagicDamage());


    }
    @Test
    void checkDamageIncrease(){

        AAttributes mage = new Mage();
        AAttributes rogue = new Rogue();

        System.out.println("INTEL BEFORE LOOP: " + mage.getIntelligence());
        System.out.println("STRNG BEFORE LOOP: " + rogue.getStrength());
        System.out.println("DAMAGE: " + rogue.getDamage());
        System.out.println("MAGICAL DMG: " + mage.getMagicDamage());
        int damage = rogue.getDamage();

        int magicalDamage = mage.getMagicDamage();
        for (int i = 1; i < 2 ; i++){

            mage.setIntelligence(mage.getIntelligence() + 10);
            rogue.setStrength(rogue.getStrength() + 10);

            if (mage.getIntelligence() > 10 && mage.getIntelligence() % 10 == 0){

                magicalDamage += 10;
                mage.setMagicDamage(magicalDamage);

            }if (rogue.getStrength() > 10 && rogue.getStrength() % 10 == 0){

                damage += 10;
                rogue.setDamage(damage);

            }
        }

        System.out.println("\nDAMAGE AFTER INCREASE: " + rogue.getDamage());
        System.out.println("MAGICAL DMG AFTER INCREASE: " + mage.getMagicDamage());
        System.out.println("INTEL AFTER LOOP: " + mage.getIntelligence());
        System.out.println("STRNG AFTER LOOP: " + rogue.getStrength());

        //assertEquals(rogue.getDamage(),35);
        //assertEquals(mage.getMagicDamage(),35);



    }
}

