package com.Gustav.demo.Entity.Monsters;

import com.Gustav.demo.Entity.Attributes;

public class LaChancla extends Attributes {
    public LaChancla(int strength, int intelligence, int agility, int health, int experience, int level, int damage, int magicDamage, int gold) {
        super(strength, intelligence, agility, health, experience, level, damage, magicDamage, gold);
    }

    @Override
    public String attack() {
        return null;
    }

    @Override
    public void flee() {

    }

    @Override
    public String dodge() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
