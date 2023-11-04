package com.Gustav.demo.Resources.TheLoreMaster;



import com.Gustav.demo.Entity.Interface.AAttributes;
import com.Gustav.demo.GameEngine.Menu.PlayerMenu;
import com.Gustav.demo.Resources.ItemHandler.Shop;
import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.*;
import static com.Gustav.demo.Resources.TheLoreMaster.Lore.tellTheLore;







import java.util.Scanner;

public class LoreMasterKristoffer extends Shop{

    public void loreMastersInn(AAttributes attacker, Scanner sc) {

        PlayerMenu menu = new PlayerMenu();
        boolean wrongInput = false;

        do {
            println(YELLOW + BLACK_BACKGROUND + "☰ Lore Master Kristoffer's Inn ☰" + RESET);
            println("1.Purchase Kristoffer´s items");
            println("2.Learn The Lore Master wisdom");
            println(PURPLE + "╰┈➤3.Back to Player menu"+ RESET);

            switch (sc.nextLine()) {
                case "1" -> buyItems(attacker, sc);
                case "2" -> println(tellTheLore);
                case "3" -> menu.playerOption(attacker, sc);
                default ->{println(RED + "Wrong input" + RESET); wrongInput = true;}
            }

        }while(wrongInput);
    }

}
