package com.Gustav.demo.GameEngine.Menu;

import com.Gustav.demo.Resources.Paint.Colors;
import com.Gustav.demo.Entity.TheLoreMaster.LoreMasterKristoffer;
import java.util.Scanner;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.Print.TextDelay.printDelay;
import static com.Gustav.demo.Entity.TheLoreMaster.Lore.tellTheLore;

public class StartMenu implements Colors {

    public void options(){

        CharacterMenu characterMenu = new CharacterMenu();
        LoreMasterKristoffer kristoffer = new LoreMasterKristoffer();
        Scanner sc = new Scanner(System.in);

        println(BLUE + BLACK_BACKGROUND + "☰ Start Menu ☰" + RESET );
        println("1.Start a new Game");
        println("2.Learn the Lore Masters wisdom");
        println("3.Exit app");


        switch (sc.nextLine()){
            case "1" -> characterMenu.characterChooser();
            case "2" -> printDelay(tellTheLore);
            case "3" -> System.exit(0);

            default -> println(RED + "Wrong input, try again..." + RESET);
        }


    }
}
