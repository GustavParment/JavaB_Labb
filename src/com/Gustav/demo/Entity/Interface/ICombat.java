package com.Gustav.demo.Entity.Interface;

import static com.Gustav.demo.Resources.Paint.Colors.*;
import static com.Gustav.demo.Resources.Print.PrintHandler.println;

public interface ICombat {

   String attack();

   String dodge();

   String getName();

   default void flee(AAttributes attacker){
      println(YELLOW + getName() + " fled and lost 2 hp" + RESET);
      attacker.setHealth(attacker.getHealth() - 2);

   }



}
