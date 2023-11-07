package com.Gustav.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class TheRoomOfRiddlesTest {

    @Test
    void roomOFRiddlesOption() {

        List<String> riddleList = new ArrayList<>(riddles());
        Random random = new Random();
        int ranNum = random.nextInt(0,6);

        for (int i = 0; i < 1 ; i++) {

            System.out.println(riddleList.get(ranNum));
            System.out.println(ranNum);


        }









    }
    private List<String> riddles(){

        return Arrays.asList("I have keys but open no locks, I have space but no room," +
                        "and you can enter, but you can't go inside. What am I?",//0

                "What comes once in a minute, twice in a moment, but never in a thousand years?", //1

                "I'm not alive, but I can grow. I don't have lungs, but I need air. What am I?",// 2

                "What has a face and two hands, but no arms or legs?",// 3

                "I'm tall when I'm young, and short when I'm old. What am I?", // 4

                "I'm full of holes, yet I still hold water. What am I?"); // 5
    }


}