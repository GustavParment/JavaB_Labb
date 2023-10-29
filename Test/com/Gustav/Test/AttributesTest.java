package com.Gustav.Test;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Heros.Necromancer;
import com.Gustav.demo.Entity.Heros.Rogue;
import org.junit.jupiter.api.Test;

import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static org.junit.jupiter.api.Assertions.*;

class AttributesTest {

    @Test
    void calculateDamageStrength() {

        Attributes attacker = new Rogue();

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

        Attributes attacker = new Necromancer();

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

}