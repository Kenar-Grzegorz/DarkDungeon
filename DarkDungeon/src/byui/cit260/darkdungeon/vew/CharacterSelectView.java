/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.model.*;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class CharacterSelectView {
    CharacterSelection warrior = GameControl.createWarrior();
    private String menu;

    public CharacterSelectView() {
        this.menu = "\n"
                + "\n===================================="
                + "\n|   Please Choose your Character   |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        1. Warrior                |"
                + "\n|        2. Paladin                |"
                + "\n|        Q. Quit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ";
                
   }

    public void characterMenuView() {
        boolean done = false; // set to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
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
    

    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "1": //Warrior
                this.doNext();
                warrior = GameControl.createWarrior();
                break;
            case "2": //Paladin
                this.doNext();
                warrior = GameControl.createPaladin();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void doNext() {
        
        
        System.out.println("You have chosen a " + warrior.getCharacterName() +" "+ warrior.getCharacterClass());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
    }

    
   
}
