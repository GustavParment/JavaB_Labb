package demo.Gustav.demo.Entity.Heros;


import demo.Gustav.demo.Entity.Attributes;

public class Necromancer extends Attributes {


    public Necromancer() {
        super(10,20, 5, 50, 0, 0, 20);
    }

    @Override
    public String attack() {

        return "Casted a death bolt";
    }

    @Override
    public void flee() {

        System.out.println("Necromancer fled");

    }

    @Override
    public String getName() {

        return "Necromancer";
    }


}
