package com.Gustav.demo.Entity.Room;

import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.Menu.PlayerMenu;
import com.Gustav.demo.GameEngine.Menu.StartMenu;

import java.util.*;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.*;


public class TheRoomOfRiddles {

    public void roomOFRiddlesOption(AAttributes attacker, Scanner sc) {
        PlayerMenu returnTo = new PlayerMenu();
        List<String> riddleList = new ArrayList<>(riddles());

        println(PURPLE + BLACK_BACKGROUND + "❔ The Room Of Riddles ❔" + RESET);

        printDelay(PURPLE_BOLD + "Welcome "+ attacker.getName()+ PURPLE_BOLD +
                " to The Room of Riddles!\nThe rules are simple answer the riddle and get " +
                "passage to the next room. " +
                "\nIf you fail to answer lightning will strike you and it will be a"+ RED + " Game Over" + RESET);

        boolean notOne = true;
        do {


            println(PURPLE_BOLD + "\n1.To generate Riddle");
            switch (sc.nextLine()) {
                case "1" -> {
                    int temp = generateRiddle(riddleList);
                    String input = sc.nextLine().toLowerCase();
                    notOne = false;

                    switch (temp) {
                        case 0 -> {
                            if (input.contains("keyboard")) {
                                printDelay("\nGood jobb " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);
                            } else {
                                killAttacker(attacker);

                            }

                        }
                        case 1 -> {
                            if (input.contains("m")) {
                                printDelay("\nThat's correct " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);
                            } else {
                                killAttacker(attacker);

                            }
                        }
                        case 2 -> {
                            if (input.contains("fire")) {
                                printDelay("\nYou are so smart,that is correct " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);
                            } else {
                                killAttacker(attacker);
                            }
                        }
                        case 3 -> {
                            if (input.contains("clock")) {
                                printDelay("\nThat's correct " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);
                            } else {

                            }
                        }
                        case 4 -> {
                            if (input.contains("candle")) {
                                printDelay("\nThat's the right answer " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);

                            } else {
                                killAttacker(attacker);

                            }
                        }
                        case 5 -> {
                            if (input.contains("sponge")) {
                                printDelay("\nSuper that is correct " + attacker.getName());
                                reward(attacker);
                                returnTo.playerOption(attacker, sc);

                            } else {
                                killAttacker(attacker);

                            }
                        }
                    }

                }
                default -> println(RED + "Wrong notOne, try again" + RESET);
            }
        }while (notOne);
    }



    private void reward(AAttributes attacker) {
        println("\n"+ attacker.getName() + YELLOW +  " looted 20 gold" + RESET);
        println(attacker.getName() + YELLOW + " gained +100 xp" + RESET);
        println(attacker.getName() + YELLOW + " gained +10 Hp" + RESET);
        println(attacker.getName() + YELLOW + " gained +2 in all Attributes" + RESET);

        attacker.setExperience(attacker.getExperience() + 100);
        attacker.setHealth(attacker.getHealth() + 10);
        attacker.setGold(attacker.getGold() + 20);
        attacker.levelUp(attacker);
    }

    private List<String> riddles(){
        return Arrays.asList("I have keys but open no locks, I have space but no room, " +
                "and you can enter, but you can't go inside. What am I?",//0

                "What comes once in a minute, twice in a moment, but never in a thousand years?",//1

                "I'm not alive, but I can grow. I don't have lungs, but I need air. What am I?",//2

                "What has a face and two hands, but no arms or legs?",//3

                "I'm tall when I'm young, and short when I'm old. What am I?",//4

                "I'm full of holes, yet I still hold water. What am I?");//5
    }

    private int generateRiddle(List<String> riddleList){
        Random random = new Random();
        int ranNum = random.nextInt(0,6);

        println(riddleList.get(ranNum));

        return ranNum;


    }

    private void killAttacker(AAttributes attacker){
        StartMenu start = new StartMenu();
        attacker.setHealth(0);
        printDelay(RED + "Wrong Answer "+ attacker.getName() + PURPLE_BOLD +
                " to bad you will now be struck by lightning\n" +YELLOW_BOLD+
                "⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ ⚡ \uD83D\uDD25\uD83D\uDC80" + RESET);

        println("\n"+BLACK + RED_BACKGROUND + "\uD83D\uDC80Game over\uD83D\uDC80" + RESET);
        printDelay(PURPLE_BOLD+"\nThanks for Playing better luck next time summoner...\n"
                + RESET);
        start.options();

    }


}

