/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|           Main Menu              |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|   N. Start a New Game            |"
                + "\n|   L. Load a saved Game           |"
                + "\n|   H. Game Help                   |"
                + "\n|   S. Save Game                   |"
                + "\n|   Q. Quit                        |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }
    @Override
    public boolean doAction(String choice) {
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
