package demo.Gustav.demo.Entity.Monsters;

import demo.Gustav.demo.Entity.Attributes;

public class Medusa extends Attributes {

    public Medusa() {

        super(30,30, 30, 50, 0, 0, 30);
    }


    @Override
    public String attack() {

        return "Casts snakes";
    }

    @Override
    public void flee() {

    }

    @Override
    public String getName() {

        return "Medusa";
    }
}
