/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.exception.MapControlException;
import byui.cit260.darkdungeon.control.GameControl;
import byui.cit260.darkdungeon.model.Game;
import darkdungeongame.DarkDungeonGame;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "\n|   S. Save Game                   |"
                + "\n|   H. Help                        |"
                + "\n|   B. Back to Previous Menu       |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "N": {
            try {
                //New Game
                this.startNewGame();
            } catch (MapControlException ex) {
                ErrorView.display(this.getClass().getName(),ex.getMessage());
            }
            }
                break;
            case "L": //Start a saved game
                this.loadSavedGame();
                break;
            case "H": //Display the Help Menu
                this.displayHelpMenu();
                break;
            case "S": //save current Game
                this.saveGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

   public String getInput2() {
        
        String value = null; //value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                value = this.keyboard.readLine(); //get next line typed
                this.console.println(value);
                value = value.trim(); //trim off leading and trailing blanks
                if (value.length() <1) { //value is blank
                    ErrorView.display(this.getClass().getName(),"\n*** Value cannot be blank ***");
                    continue;
                }
                break; //end of loop
            }
        }
        catch (Exception e) {ErrorView.display(this.getClass().getName(),"\nError Reading Input: " + e.getMessage());
        }
        return value; // return the value
    }
    
    private void startNewGame() throws MapControlException {
        //Create a new Game
        
        GameControl.createNewGame(DarkDungeonGame.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void loadSavedGame() {
        System.out.println("\n\nEnter the file path for file where the game was saved last.");
        String filePath = this.getInput2();
        
        try {
            GameControl.getLoadSavedGame(filePath);
        } catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        
    }   
    
    
    private void saveGame() {
        System.out.println("\n\nEnter the file path for file where the game is to be saved.");
        String filePath = this.getInput2();
        
        try {
            GameControl.saveGame(DarkDungeonGame.getCurrentGame(), filePath);
        } catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }
    
}
