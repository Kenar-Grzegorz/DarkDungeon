/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.model.*;
import darkdungeongame.DarkDungeonGame;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class CharacterSelectView {
    CharacterSelection warrior = GameControl.createWarrior();
    protected final BufferedReader keyboard = DarkDungeonGame.getInFile();
    protected final PrintWriter console = DarkDungeonGame.getOutFile();
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
                + "\n Please Choose a Number ~~~~~~~~~~~> ";
                
   }
    
    public void displayCharacterSelectView() {
        int menuOption;
        boolean done = false; // set to not done
        do {
            // prompt for and get players name
            menuOption = this.getInput();
            if (menuOption==0) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
    }
    
    private int getInput() {
        boolean valid = false; // initialize to not valid
        int value= 0;
        String input = null; //value to be returned
        try {
            while (!valid) { // loop while an invalid value is entered
                System.out.print(this.menu);
                input = keyboard.readLine();
                input = input.trim(); //trim off leading and trailing blanks
                if ("Q".equals(input)||"q".equals(input)) {input = "0";}
                if (input.length() <1) { //Check if value is blank
                    ErrorView.display(this.getClass().getName(),"Value cannot be blank");
                    continue;
                }
                else {
                    try {
                        value = Integer.parseInt(input);
                        if (value <0||value>10){ //value is blank
                            ErrorView.display(this.getClass().getName(),"Value has to be between 0 and 10");
                            continue;}
                        else {break;}
                    }
                    catch (NumberFormatException ne) {
                        ErrorView.display(this.getClass().getName(),"Value must be a number!");
                    }
                }
            }
        }
        catch (Exception e) {ErrorView.display(this.getClass().getName(),"Error Reading Input: " + e.getMessage());}
        return value; // return the value
    }
    
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
                ErrorView.display(this.getClass().getName(),"*** Invalid Selection *** Try again");
                
        }
        return false;
    }

    private void doNext() {
        
        this.console.println("\n**************************************************************************************************"
                         + "\nYou have chosen " + warrior.getCharacterName() +" "+ warrior.getCharacterClass()+""
                         + "\n**************************************************************************************************");
        
        
    }

    
   
}
