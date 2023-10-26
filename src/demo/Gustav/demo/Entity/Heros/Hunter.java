package demo.Gustav.demo.Entity.Heros;


import demo.Gustav.demo.Entity.Attributes;

public class Hunter extends Attributes {


    public Hunter() {
        super(10,5, 20, 50, 0, 0, 20);
    }

    @Override
    public String attack() {

        return "Shoots an Arrow";
    }

    @Override
    public void flee() {

        System.out.println("Hunter fled");

    }

    @Override
    public String getName() {

        return "Hunter";
    }
}
