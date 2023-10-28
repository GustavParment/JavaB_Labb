package com.Gustav.Test;

import com.Gustav.demo.Entity.Attributes;
import com.Gustav.demo.Entity.Heros.Hunter;
import com.Gustav.demo.Entity.Monsters.Medusa;
import org.junit.jupiter.api.Test;

import java.util.Random;

class DodgeTest {

    @Test
    void missTest() {

      Attributes attacker = new Hunter();
      Attributes defender = new Medusa();

        int agilityDifference = attacker.getAgility() - defender.getAgility();
        int threshold = 20;
        System.out.println("Agi Diff + Threshold: " + (agilityDifference + threshold));


        // Skapa en slumpgenerator
        Random random = new Random();

        // Generera ett slumpmässigt tal mellan 1 och 20
        int randomNumber = random.nextInt(20) + 20;
        System.out.println("Random Num: " + randomNumber);



        if (randomNumber > threshold + agilityDifference){

            System.out.println("Miss");
        }
        else{
            System.out.println("Hit");
        }



        }

        @Test
        void hitTest(){

            Attributes attacker = new Hunter();
            Attributes defender = new Medusa();

            int agilityDifference = attacker.getAgility() - defender.getAgility();
            int threshold = 40;
            System.out.println("Agi Diff + Threshold: " + (threshold + agilityDifference) );

            // Skapa en slumpgenerator
            Random random = new Random();

            // Generera ett slumpmässigt tal mellan 1 och 20
            int randomNumber = random.nextInt(30) + 1;
            System.out.println("Random Num: " + randomNumber);



            if (randomNumber > threshold + agilityDifference){

                System.out.println("Miss");
            }
            else{
                System.out.println("Hit");
            }

        }

    }
