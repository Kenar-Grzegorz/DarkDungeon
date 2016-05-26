/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Bill
 */
public class Battle implements Serializable {
    
    //class instance variables
    public Item fireScroll = new Item("The power of Fire surges throughout your body", 45, 0, 5);
    public Item potion = new Item("A devine glow covers your body", 0,25,3);
    public Item omniSlash = new Item("You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
    public Item armageddon = new Item("Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);
    private Boolean isAlive;

    public Battle() {
    }
        
    public Boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(Boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.isAlive);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Battle other = (Battle) obj;
        if (!Objects.equals(this.isAlive, other.isAlive)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Battle{" + "isAlive=" + isAlive + '}';
    }
    
    public void battleStart(Player player, CharacterSelection character, Monster monster) {  
        Monster.newMonsterInstance();
        Scanner input = new Scanner(System.in);
        System.out.println(player.getName() + " has encountered a " + monster.getMonsterName()+ "\n");
        System.out.println("You intiate the Battle with " +monster.getMonsterName() + "(" + character.getStatus() + " / "
                + monster.getStatus() + ")");
        
        OUTER:
        while (character.isAlive() && monster.isAlive()) {
            System.out.println("====================================");
            System.out.println("|             Battle               |");
            System.out.println("====================================");
            System.out.println("| Options:                         |");
            System.out.println("|            a. Attack             |");
            System.out.println("|            s. Specials/Abilities |");
            System.out.println("|            i. Item Sack          |");
            System.out.println("|            r. Run Away           |");
            System.out.println("====================================");
            System.out.print("Make your Selection ~~~>");
            String action = input.nextLine();
            switch (action) {
                case "s":
                    System.out.println("====================================");
                    System.out.println("|         Specials/Abilities       |");
                    System.out.println("====================================");
                    System.out.println("| Options:                         |");
                    System.out.println("|            o. OmniSlash         |");
                    System.out.println("|            b. Armaggeddon        |");
                    System.out.println("|            x. Exit               |");
                    System.out.println("====================================");
                    System.out.print("Make your Selection ~~~>");
                    String action3 = input.nextLine();
                    if (action3.equals("o")) {
                        if (character.getManaAmount()>omniSlash.getItemAmount()){
                            System.out.println("*  You have activated OmniSlash  *\n");System.out.println(omniSlash.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
                            character.setManaAmount(character.getManaAmount()-omniSlash.getItemAmount());
                            if (omniSlash.getItemDamage()>monster.getHealth()) {monster.setHealth(0);}
                            else {monster.setHealth(monster.getHealth()-omniSlash.getItemDamage());
                            }
                            System.out.println("You have hit the "+monster.getMonsterName()+" for "+omniSlash.getItemDamage()+" of Damage!!\n");
                            System.out.println("*  You have " + character.getManaAmount() + " mana left.  *\n");
                        }
                    }
                    else if (action3.equals("b")) {
                        if (character.getManaAmount()>armageddon.getItemAmount()){
                            System.out.println("*  You have activated Armageddon  *\n");System.out.println(armageddon.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
                            character.setManaAmount(character.getManaAmount()-armageddon.getItemAmount());
                            if (armageddon.getItemDamage()>monster.getHealth()) {monster.setHealth(0);}
                            else {monster.setHealth(monster.getHealth()-armageddon.getItemDamage());
                            }
                            System.out.println("You have hit the "+monster.getMonsterName()+" for "+armageddon.getItemDamage()+" of Damage!!\n");
                            System.out.println("*  You have " + character.getManaAmount() + " mana left.  *\n");
                        }
                    }
                    break;
                case "i":
                    System.out.println("====================================");
                    System.out.println("|             ITEMS                |");
                    System.out.println("====================================");
                    System.out.println("| Options:                         |");
                    System.out.println("|            p. Potion             |");
                    System.out.println("|            f. Fire Scroll        |");
                    System.out.println("|            x. Exit               |");
                    System.out.println("====================================");
                    System.out.print("Make your Selection ~~~>");
                    String action2 = input.nextLine();
                    if (action2.equals("p")) {
                        //character.heal();
                        if (potion.getItemAmount()>0){System.out.println("*  You have used a potion  *\n");System.out.println("  `  `  \\ \\(`^')/ /  '  '\n");}
                        int potionAmount = character.heal(potion.getItemAmount(),potion.getItemHeal());
                        potion.setItemAmount(potionAmount);
                        System.out.println("*  You have " + potion.getItemAmount() + " potions left.  *\n");
                    }
                    else if (action2.equals("f")) {
                        if (character.getManaAmount()>fireScroll.getItemAmount()){
                            System.out.println("*  You have used a firescroll  *\n");System.out.println(fireScroll.getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
                            character.setManaAmount(character.getManaAmount()-fireScroll.getItemAmount());
                            if (fireScroll.getItemDamage()>monster.getHealth()) {monster.setHealth(0);}
                            else {monster.setHealth(monster.getHealth()-fireScroll.getItemDamage());
                            }
                            System.out.println("You have hit the "+monster.getMonsterName()+" for "+fireScroll.getItemDamage()+" of Damage!!\n");
                            System.out.println("*  You have " + character.getManaAmount() + " mana left.  *\n");
                        }
                    }
                    break;
                case "a":
                    monster.defend(character);
                    break;
                case "r":
                    System.out.println("\tYou run away from the " + monster.getMonsterName() + "!");
                    break OUTER;
                default:
                    System.out.println("\tInvalid command!");
                    break;
            }
            if (monster.isAlive()) {
                character.defend(monster);
            }
            System.out.println("(" + character.getStatus() + " / " + monster.getStatus() + ")");
        }
    }
}
