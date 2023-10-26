package demo.Gustav.demo.Entity;



public abstract class Attributes implements Combat {

   private int strength;
   private int intelligence;
   private int agility;
   private int health;
   private int experience;
   private int level;
   private int baseDamage;

    public Attributes(int strength, int intelligence, int agility, int health, int experience, int level, int baseDamage) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.experience = experience;
        this.level = level;
        this.baseDamage = baseDamage;
    }

    public int getStrength() {
        return strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getIntelligence() {
        return intelligence;
    }


    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public int getAgility() {
        return agility;
    }


    public void setAgility(int agility) {
        this.agility = agility;
    }


    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public int getExperience() {
        return experience;
    }


    public void setExperience(int experience) {
        this.experience = experience;
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public int getBaseDamage() {
        return baseDamage;
    }


    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }


    void levelUp(){


    }

    void act(){



    }

    void getStatus(){


    }

    void calculateDamage(){

    }

    void didDoge(){


    }


}
