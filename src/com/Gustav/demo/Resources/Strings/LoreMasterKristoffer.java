package com.Gustav.demo.Resources.Strings;



import com.Gustav.demo.Entity.MainMenu;
import com.Gustav.demo.Resources.ItemHandler.Shop;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.MessageHandler.*;
import static com.Gustav.demo.Resources.Strings.Lore.tellTheLore;







import java.util.Scanner;

public class LoreMasterKristoffer extends Shop{

    public void loreMastersIn(){
        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();


        println(YELLOW + PURPLE_BACKGROUND + "---Lore Master Kristoffer's Inn---" + RESET);
        println("1.Purchase Kristoffer´s items");
        println("2.Learn Lore Master Kristoffer's wisdom");
        println("3.Back to main menu ");

        switch (sc.nextLine()){
            case "1" -> buyItems();
            case "2" -> println(tellTheLore);
            case "3" -> menu.options();

            default  -> println(RED + "Wrong input" + RESET);
        }

    }


}
