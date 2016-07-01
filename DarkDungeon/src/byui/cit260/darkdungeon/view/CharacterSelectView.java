/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.model.*;
import darkdungeongame.DarkDungeonGame;
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

   
    public void displayCharacterSelectView() {
        boolean done = false; // set to not done
        do {
            // prompt for and get players name
            int menuOption = this.getInput();
            if (menuOption==0) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
    }
    
    private int getInput() {
        Scanner keyboard = new Scanner(System.in); // create infile
        int value= 0;
        String input = ""; //value to be returned
        
        while (true) { // loop while an invalid value is entered
            System.out.print(this.menu);
            System.out.print("Number ~~~~~~~~~~~> ");
            input = keyboard.nextLine();
            input = input.trim(); //trim off leading and trailing blanks
            if ("Q".equals(input)||"q".equals(input)) {input = "0";}
            if (input.length() <1) { //Check if value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            else {
                try {
                    value = Integer.parseInt(input);
                    if (value <0||value>10){ //value is blank
                        System.out.println("\nValue has to be between 0 and 10");
                        continue;}
                    else {break;}
                }
                catch (NumberFormatException ne) {
                    System.out.println("\nValue must be a number!");
                }
            }
        }
        return value; // return the value
    }
    
//    public String getInput() {
//        Scanner keyboard = new Scanner(System.in); // create infile
//        String value = ""; //value to be returned
//        boolean valid = false; // initialize to not valid
//        
//        while (!valid) { // loop while an invalid value is entered
//            System.out.print(this.menu);
//            value = keyboard.nextLine(); //get next line typed
//            value = value.trim(); //trim off leading and trailing blanks
//            if (value.length() <1) { //value is blank
//                System.out.println("\nValue cannot be blank");
//                continue;
//            }
//            break; //end of loop
//        }
//        return value; // return the value
//    }
    
    public boolean doAction(int choice) {
        //choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case 1: //Warrior
                warrior = GameControl.createWarrior();
                this.doNext();
                return true;
                
            case 2: //Paladin
                warrior = GameControl.createPaladin();
                this.doNext();
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                
        }
        return false;
    }

    private void doNext() {
        
        System.out.println("\n**************************************************************************************************"
                         + "\nYou have chosen " + warrior.getCharacterName() +" "+ warrior.getCharacterClass()+""
                         + "\n**************************************************************************************************");
        
        
    }

    
   
}
