package com.Gustav.Test;

import com.Gustav.demo.Entity.Interface.AAttributes;
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
    void calculateHealthReg() {

        AAttributes necro = new Necromancer();

        necro.setSpirit(necro.getSpirit()+60);
        necro.setHealth(necro.getHealth());

        System.out.println("SPIRIT: " + necro.getSpirit());
        System.out.println("OLD HEALTH: " + necro.getHealth());

        int health = necro.getHealth();
        int maxIncrease = necro.getSpirit();

        if (necro.getSpirit() >= 10 ){
            while (necro.getSpirit() % 10 == 0 && health < maxIncrease ){

                health += 2;


                necro.setHealth(health);
                necro.setHealth(necro.getHealth() - 10);



            }

            System.out.println("NEW HEALTH: " + necro.getHealth());
        }


    }
}


