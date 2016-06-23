/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.control.GameControl.*;
import static byui.cit260.darkdungeon.control.GameControl.game;
import byui.cit260.darkdungeon.model.Inventory;
import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.view.TreasureChestView;
import darkdungeongame.DarkDungeonGame;
import java.util.Random;


/**
 *
 * @author Greg K, Bill M, Florian K
 */
// Added by the team
public class BattleControl {
    
    public static int attackStrength;
    public static boolean shield=false;
    
    public static int getAttackStrength() {
        return attackStrength;
    }

    public static boolean isShield() {
        return shield;
    }
    
    //Added by Greg for individual project
    public static int random(int min, int max) {
        if (min > max) {return -1;}
        if ((min < 0 || min > 200) || (max < 0 || max > 200)) {return -1;}
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        
        return randomNum;
    }
     //added by Greg for individual project
    public static int superAttack(int health, int defense, int damageAmount) {
        if (health < 1) {return -1;} 
        if (damageAmount < 5 || damageAmount > 100) {return -1;}
        if (damageAmount >= (health+defense)) { return 0;}
        else if (damageAmount<defense) {return health;}
        else {health -= (damageAmount-defense);}
        return health;
    }
    //added by Greg
    public static boolean flee(int min, int max) {
        if (min > max) {return Boolean.FALSE;}
        if ((min < 0 || min > 10) || (max < 0 || max > 10)) {return Boolean.FALSE;}
        int value = random(min, max);
        if (value>= 3) {return Boolean.TRUE;}
        else {return Boolean.TRUE;}
    }
        
    public static int attack(int min, int max, int defense, int health) {
        attackStrength = attackRand(min, max);
        if (attackStrength< defense) {shield=true;return health;}
        else {health=(attackStrength<(health+defense)) ? (health+defense) - attackStrength : 0;shield=false;
        return health;}
    }
    
    public static void heal(Inventory potion, CharacterSelection warrior) {
        int amount = potion.getItemAmount();
        if (amount>0){System.out.println("*  You have used a potion  *\n");System.out.println("  `  `  \\ \\(`^')/ /  '  '\n");
            int health = warrior.getHealth() + potion.getItemHeal();
            System.out.println("before"+potion.getItemAmount());
            amount--;
            potion.setItemAmount(amount);
            warrior.setHealth(health);
            System.out.println("after"+potion.getItemAmount());
            System.out.println(game.getPlayer()+" drinks a healing potion.");
            System.out.println(warrior.getStatus());
        } else {
            System.out.println("*  You've exhausted your potion supply!  *\n");
        }
        System.out.println("*  You have " + amount + " potions left.  *\n");
    }
    
    public static void abilityDefend(CharacterSelection character, Monster monster, Inventory item) {
        System.out.println(item.getItemAmount());
        if (character.getManaAmount()>item.getItemAmount()){
            System.out.println("*  You have activated the "+item.getItemName()+ " *\n");System.out.println(item.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            character.setManaAmount(character.getManaAmount()-item.getItemAmount());
            int health = (character.getHealth()>item.getItemDamage()) ? character.getHealth()-item.getItemDamage() :0;
            System.out.println("You have hit the "+ monster.getMonsterName()+" for "+item.getItemDamage()+" of Damage!!");
            if (health == 0) {
                System.out.println("\t" + game.getPlayer() + " transforms the skull of " + monster.getMonsterName()
                + " into dust to never be seen again");
                
            }
        }
        else {
            System.out.println("You have exhausted your Mana amount, You have: "+character.getManaAmount()+" Mana");
        }
    }
    
    public static int attackRand(int minAttackDamage, int maxAttackDamage) {
        return BattleControl.random(minAttackDamage, maxAttackDamage);
    }
}
