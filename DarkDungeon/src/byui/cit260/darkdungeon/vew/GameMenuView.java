/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;


import byui.cit260.darkdungeon.model.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Bill
 */
public class GameMenuView implements Serializable {
    
    //class instance variables
    
    
    
    private Boolean isAlive;
    private String gameMenu;
    
    public GameMenuView() {
        this.gameMenu = "\n"
                + "\n===================================="
                + "\n|             Battle               |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        A. Attack                 |"
                + "\n|        S. Specials / Abilities   |"
                + "\n|        I. Item Sack              |"
                + "\n|        Q. Run Away               |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ";
        
    }

   
    
    
    
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            //System.out.print(this.gameMenu);
            value = keyboard.nextLine(); //get next line typed
            value = value.trim(); //trim off leading and trailing blanks
            if (value.length() <1) { //value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            break; //end of loop
            
        }
        value = value.toUpperCase();
        return value; // return the value
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
        final GameMenuView other = (GameMenuView) obj;
        if (!Objects.equals(this.isAlive, other.isAlive)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Battle{" + "isAlive=" + isAlive + '}';
    }
    
    public void battleStart(Player playerName, CharacterSelection character, Monster monster) {
        
        Monster.newMonsterInstance();
        System.out.println(playerName + " has encountered a " + monster.getMonsterName()+ "\n");
        System.out.println("You intiate the Battle with " +monster.getMonsterName() + "(" + character.getStatus() + " / "
                + monster.getStatus() + ")");
        
        OUTER:
        while (character.isAlive() && monster.isAlive()) {
            System.out.print(this.gameMenu);
            String action = this.getMenuOption();
            switch (action) {
                case "S":
                    SpecialMenuView specialView = new SpecialMenuView();
                    specialView.displayMainMenuView(character, monster);
                    break;
                case "I":
                    ItemMenuView itemView = new ItemMenuView();
                    itemView.displayMenuView(character, monster);
                    break;
                case "A":
                    monster.defend(character);
                    break;
                case "Q":
                    System.out.println("\tYou run away from the " + monster.getMonsterName() + "!");
                    return;
                    //break OUTER;
                default:
                    System.out.println("\tInvalid command!");
                    break;
            }
            if (monster.isAlive()) {
                character.defend(monster);
            }
            System.out.println("(" + character.getStatus() + " / " + character.getManaStatus() + " / " + monster.getStatus() + ")");
        }
    }
}
