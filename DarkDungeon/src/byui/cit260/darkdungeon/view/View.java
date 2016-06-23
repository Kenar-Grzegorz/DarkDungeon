/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import java.util.Scanner;

/**
 *
 * @author test
 */
public abstract class View implements ViewInterface {
    protected String displayMessage;
    
    public View() {
        
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        boolean done = false; // set to not done
        do {
            // prompt for and get players name
            String menuOption = this.getInput();
            if (menuOption.toUpperCase().equals("Q")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
    }
    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.print(this.displayMessage);
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
}
