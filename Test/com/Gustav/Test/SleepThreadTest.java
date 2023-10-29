package com.Gustav.Test;

import org.junit.jupiter.api.Test;

public class SleepThreadTest {

    @Test
    void sleepThread() {


        String text = "Detta är en text som skrivs ut bokstav för bokstav.";
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



