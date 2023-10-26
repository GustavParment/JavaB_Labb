package demo.Gustav.demo.Entity.Heros;


import demo.Gustav.demo.Entity.Attributes;

public class Rogue extends Attributes {


    public Rogue() {
        super(20,5, 10, 50, 0, 0, 20);
    }

    @Override
    public String attack() {

        return "Slice and dice";

    }

    @Override
    public void flee() {

        System.out.println("Rouge fled");

    }

    @Override
    public String getName() {

        return "Rouge";
    }
}
