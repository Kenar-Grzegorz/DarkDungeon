/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.exceptions.MapControlException;
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
                + "\n|   H. Help                   |"
                + "\n|   Q. Quit                        |"
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
                Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
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

    private void startNewGame() throws MapControlException {
        //Create a new Game
        GameControl.createNewGame(DarkDungeonGame.getPlayer());
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startExistingGame() {
        System.out.println("\n\nEnter the file path for file where the game " + "was saved last.");
        String filePath = this.getInput();
        
        try {
            Game.getLoadSavedGame(filePath);
        } catch (Exception ex){
            
        }
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        System.out.println("\n\nEnter the file path for file where the game " + "is to be saved.");
        String filePath = this.getInput();
        
        try {
            GameControl.saveGame(DarkDungeonGame.getCurrentGame(), filePath);
        } catch (Exception ex){
            
        }
    
    }
    
}
