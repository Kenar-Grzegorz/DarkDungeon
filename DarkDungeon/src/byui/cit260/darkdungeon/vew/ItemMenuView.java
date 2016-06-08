/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Item;
import byui.cit260.darkdungeon.model.Monster;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class ItemMenuView {
 private String menu;
        public Item fireScroll = new Item("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);
        public Item potion = new Item("Potion", "A devine glow covers your body", 0,25,3);
    public ItemMenuView() {
                this.menu = "\n"
                + "\n===================================="
                + "\n|             Battle               |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        P. Potion                 |"
                + "\n|        f. Fire Scroll            |"
                + "\n|        X. Exit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ";
        
   }

    public void displayMainMenuView(CharacterSelection character, Monster monster) {
   
         boolean done = false; // set to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("X")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption, character,monster);
        } while (!done);
        
       
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.print(this.menu);
            value = keyboard.nextLine(); //get next line typed
            value = value.trim(); //trim off leading and trailing blanks
            if (value.length() <1) { //value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            break; //end of loop
            
        }
        return value; // return the value
    }
    

    private boolean doAction(String choice,CharacterSelection character, Monster monster) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "P": //potion
                this.usePotion(character);
                return true;
            case "F": //Fire Scroll
                this.useFireScroll(character,monster);
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    private void usePotion(CharacterSelection character) {
    
    if (potion.getItemAmount()>0){System.out.println("*  You have used a potion  *\n");System.out.println("  `  `  \\ \\(`^')/ /  '  '\n");}
                        int potionAmount = character.heal(potion.getItemAmount(),potion.getItemHeal());
                        potion.setItemAmount(potionAmount);
                        System.out.println("*  You have " + potion.getItemAmount() + " potions left.  *\n");
    }
    private void useFireScroll(CharacterSelection character, Monster monster) { 
    monster.abilityDefend(character, fireScroll);
    }
}
