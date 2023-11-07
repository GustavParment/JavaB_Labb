package com.Gustav.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheRoomOfRelicsTest {

    @Test
    void countDown() {

        int[] seconds = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < seconds.length; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
