package com.Gustav.demo.Resources.Print;


public class TextDelay {

    public static void printDelay(String text) {

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