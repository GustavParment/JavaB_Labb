package com.Gustav.demo.Entity;

import com.Gustav.demo.Resources.Paint.Colors;
import com.Gustav.demo.Resources.Strings.LoreMasterKristoffer;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.MessageHandler.*;

public class MainMenu implements Colors {

    public void options(){

        GameLogic game = new GameLogic();
        LoreMasterKristoffer kristoffer = new LoreMasterKristoffer();
        Scanner sc = new Scanner(System.in);

        println(BLACK_BACKGROUND + "--Main Menu--" + RESET );
        println("1.Start a new Game");
        println("2.Enter The Lore Masters inn");
        println("3.Exit app");

        switch (sc.nextLine()){
            case "1" -> game.chooseClass();
            case "2" -> kristoffer.loreMastersIn();
            case "3" -> System.exit(0);

            default -> println(RED + "Wrong input, try again..." + RESET);
        }


    }
}
