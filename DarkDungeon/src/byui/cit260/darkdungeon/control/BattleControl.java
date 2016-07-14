/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.control.GameControl.*;
import static byui.cit260.darkdungeon.control.GameControl.game;
import byui.cit260.darkdungeon.exception.MapControlException;
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
    public static int random(int min, int max) throws BattleControlException {
        if (min > max) {
            throw new BattleControlException("The minimum value " + min + " can not be greater than the maximum value "+ max);}
        if ((min < 0 || min > 200) || (max < 0 || max > 200)) {throw new BattleControlException("The minimum value " + min + "  and the maximum value" + max + " can not be less than zero or greater than 200");}
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        
        return randomNum;
    }
     //added by Greg for individual project
    public static int superAttack(int health, int defense, int damageAmount) throws BattleControlException {
        if (health < 1) {throw new BattleControlException("The minimum value for health " + health + " can not be less then zero");} 
        if (damageAmount < 5 || damageAmount > 100) {throw new BattleControlException("The minimum value for damage " + damageAmount + " can not be less then 5 or greater than 100");}
        if (damageAmount >= (health+defense)) { return 0;}
        else if (damageAmount<defense) {return health;}
        else {health -= (damageAmount-defense);}
        return health;
    }
    //added by Greg
    public static boolean flee(int min, int max) throws BattleControlException {
        if (min > max) {return Boolean.FALSE;}
        if ((min < 0 || min > 10) || (max < 0 || max > 10)) {return Boolean.FALSE;}
        int value = random(min, max);
        if (value>= 3) {return Boolean.TRUE;}
        else {return Boolean.TRUE;}
    }
        
    public static int attack(int min, int max, int defense, int health) throws BattleControlException {
        attackStrength = attackRand(min, max);
        if (attackStrength< defense) {shield=true;return health;}
        else {health=(attackStrength<(health+defense)) ? (health+defense) - attackStrength : 0;shield=false;
        return health;}
    }
    
    public static void heal(Inventory potion, CharacterSelection warrior) throws MapControlException {
        int amount = potion.getItemAmount();
        if (amount>0){System.out.println("*  You have used a potion  *\n");System.out.println("  `  `  \\ \\(`^')/ /  '  '\n");
            int health = warrior.getHealth() + potion.getItemHeal();
            amount--;
            potion.setItemAmount(amount);
            warrior.setHealth(health);
            System.out.println(warrior.getCharacterName()+" drinks a healing potion. You have "+potion.getItemAmount()+" left.");
            System.out.println(warrior.getStatus());
        } else {
            throw new MapControlException("*  You've exhausted your potion supply!  *\n");
            //System.out.println("*  You've exhausted your potion supply!  *\n");
        }
        System.out.println("*  You have " + amount + " potions left.  *\n");
    }
    
    public static void itemDefend(CharacterSelection character, Monster monster, Inventory item) throws MapControlException {
        int amount = item.getItemAmount();
        System.out.println(item.getItemAmount());
        if (item.getItemAmount()>0){
            System.out.println("*  You have activated the "+item.getItemName()+ " *\n");System.out.println(item.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            int health = (monster.getHealth()>item.getItemDamage()) ? monster.getHealth()-item.getItemDamage() :0;
            amount--;
            item.setItemAmount(amount);
            monster.setHealth(health);
            System.out.println("You have hit the "+ monster.getMonsterName()+" for "+item.getItemDamage()+" of Damage!!");
            if (health == 0) {
                System.out.println("\t" + game.getPlayer() + " transforms the skull of " + monster.getMonsterName()
                + " into dust to never be seen again");
            }
        }
        else {
            //System.out.println("You have exhausted your Mana amount, You have: "+character.getManaAmount()+" Mana");
            throw new MapControlException("You have exhausted your Mana amount, You have: "+character.getManaAmount()+" Mana");
        }
    }
    
    public static void abilityDefend(CharacterSelection character, Monster monster, Inventory item) throws MapControlException {
        int mana = character.getManaAmount();
        System.out.println(item.getItemAmount());
        if (mana>item.getItemAmount()){
            System.out.println("*  You have activated the "+item.getItemName()+ " *\n");System.out.println(item.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            mana = (mana-item.getItemAmount());
            character.setManaAmount(mana);
            int health = (monster.getHealth()>item.getItemDamage()) ? monster.getHealth()-item.getItemDamage() :0;
            System.out.println("You have hit the "+ monster.getMonsterName()+" for "+item.getItemDamage()+" of Damage!!");
            if (health == 0) {
                System.out.println("\t" + game.getPlayer() + " transforms the skull of " + monster.getMonsterName()
                + " into dust to never be seen again");
            }
            monster.setHealth(health);
        }
        else {
            //System.out.println("You have exhausted your Mana amount, You have: "+character.getManaAmount()+" Mana");
            throw new MapControlException("You have exhausted your Mana amount, You have: "+character.getManaAmount()+" Mana");
        }
    }
    
    public static int attackRand(int minAttackDamage, int maxAttackDamage) throws BattleControlException {
        return BattleControl.random(minAttackDamage, maxAttackDamage);
    }
    
    public static void addPotion(Inventory potion) throws MapControlException {
        potion.setItemAmount((potion.getItemAmount())+1);
        
    }

    public static void useEther(CharacterSelection warrior, Inventory ether) {
        int mana = warrior.getManaAmount();
        System.out.println("*  You have activated the "+ether.getItemName()+ " *\n");System.out.println(ether.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
        mana--;
        ether.setItemAmount(mana);
        warrior.setManaAmount(warrior.getManaAmount()+ether.getItemHeal());
        System.out.println(warrior.getManaStatus());
    }

    public static void addManatoMana(Inventory ether) {
        ether.setItemAmount(ether.getItemAmount()+1);
    }

    public static void addFirescroll(Inventory firescroll) {
        firescroll.setItemAmount((firescroll.getItemAmount())+1);
    }

    public static void useTent(CharacterSelection warrior, Inventory tent) {
        int mana = tent.getItemAmount();
        System.out.println("*  You have activated the "+tent.getItemName()+ " *\n");System.out.println(tent.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
        mana--;
        tent.setItemAmount(mana);
        warrior.setManaAmount(40);
        warrior.setHealth(100);
        System.out.println(warrior.getManaStatus()+" "+warrior.getStatus());
    }

    public static void addTent(Inventory tent) {
        tent.setItemAmount((tent.getItemAmount())+1);
    }
}
