/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import com.sun.xml.internal.ws.api.pipe.PipelineAssembler;
import java.util.Scanner;

/**
 *
 * @author test
 */
public class ItemDropView {
  private String menu;

    public ItemDropView() {
       
   }

    public void displayMainMenuView() {
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
            System.out.print("Please Enter The First Value");
            value1 = keyboard.nextLine(); //get next line typed
            value1 = value.trim(); //trim off leading and trailing blanks
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
            case "N": //New Game
                this.startNewGame();
                break;
            case "L": //Start a saved game
                this.startExistingGame();
                break;
            case "H": //Display the Help Menu
                this.displayHelpMenu();
                break;
            case "S": //save current Game
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void startNewGame() {
        //Create a new Game
        CharacterSelectView charSelect = new CharacterSelectView();
        charSelect.characterMenuView();
        
       
        
        
    }

    private void startExistingGame() {
        System.out.println("Existing Game");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.displayHelpMenuView();
    }

    private void saveGame() {
        System.out.println("Save Game");
    }   
}
