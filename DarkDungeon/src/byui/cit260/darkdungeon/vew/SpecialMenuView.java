/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.model.*;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class SpecialMenuView {
    private String menu;
    public Item omniSlash = new Item("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
    public Item armageddon = new Item("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);

    public SpecialMenuView() {
        this.menu = "\n"
                + "\n===================================="
                + "\n|       Specials/Abilities         |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        O. OmniSlash              |"
                + "\n|        A. Armaggeddon            |"
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
            done = this.doAction(menuOption, character, monster);
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
    

    private boolean doAction(String choice, CharacterSelection character, Monster monster) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "O": //OmniSlash
                this.useOmniSlash(character, monster);
                return true;
            case "A": //Armageddon
                this.useArmageddon(character, monster);
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
     private void useOmniSlash(CharacterSelection character, Monster monster) {
         monster.abilityDefend(character, omniSlash);
         
    }
     private void useArmageddon(CharacterSelection character, Monster monster) {
         monster.abilityDefend(character, armageddon);
    }
    
    
}
