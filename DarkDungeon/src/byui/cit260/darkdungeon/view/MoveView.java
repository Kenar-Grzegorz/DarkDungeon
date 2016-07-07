/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;



import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.control.GameControl.game;
import static byui.cit260.darkdungeon.control.GameControl.warrior;
import byui.cit260.darkdungeon.control.MapControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Game;
import byui.cit260.darkdungeon.model.Location;
import byui.cit260.darkdungeon.model.Map;
import darkdungeongame.DarkDungeonGame;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class MoveView extends View{
    
    //Location[][] locations = map.getLocations();
    //private final String promptMessage;
    //private final String menu;
    public MoveView() {
        super("\n"
                  + "\n|=====================================|"
                  + "\n|               Movement              |"
                  + "\n|=====================================|"
                  + "\n|    N - North                        |"
                  + "\n|    S - South                        |"
                  + "\n|    E - East                         |"
                  + "\n|    W - West                         |"
                  + "\n|    M - Quit and Go to Main Menu     |"
                  + "\n|    B. Back to Previous Menu         |"
                  + "\n|    Q - Quit to the Main Menu        |"
                  + "\n|=====================================|"
                  + "\nWhich direction would you like to travel? ~~~>");
    }
    
    @Override
    public void display() {
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        boolean done = false; // set to not done
        int row = map.getCurrentRow();
        int column = map.getCurrentColumn();
        boolean northPossible = roomExists(row,(column+1));
        boolean souththPossible = roomExists(row,(column-1));
        boolean eastPossible = roomExists((row+1),column);
        boolean westPossible = roomExists((row-1),column);
       
        
        String menuOption;
        String className = this.getClass().getSimpleName();
        do {
            try {
                if (!"MainMenuView".equals(className)&&game.getWarrior().isDead()) return;
            }
            catch (Exception e) {}
            // prompt for and get players name
            row = map.getCurrentRow();
            column = map.getCurrentColumn();
            northPossible = roomExists(row,(column+1));
            souththPossible = roomExists(row,(column-1));
            eastPossible = roomExists((row+1),column);
            westPossible = roomExists((row-1),column);
            System.out.println(map.getCurrentLocation().getScene().getDescription());
            System.out.println("Which direction would you like to travel? ~~~>  (Q) Quit, (P) Back ");
            if (northPossible) System.out.print("(N) North" );
            if (souththPossible) System.out.print(" (S) South" );
            if (eastPossible) System.out.print(" (E) East" );
            if (westPossible) System.out.print(" (W) West" );
            System.out.print(" ? ");
            menuOption = this.getInput();
            
            if (menuOption.toUpperCase().equals("P")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
    
    }
    
    @Override
    public String getInput() {
        String value = null; //value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                //System.out.print(this.displayMessage);
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
        catch (Exception e) {System.out.println("Error Reading Input: " + e.getMessage());
        }
        return value; // return the value
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        switch (choice) {
            case "N": //North
                try {
                    this.North();
                    
                }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "S": //South
                try {
                    this.South();
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "E": //East
                try {
                    this.East();
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "W": //West
                try {
                    this.West();
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "Q": //West
                try {
                    game.getWarrior().setHealth(0);
                    warrior.setExist(false);
                    
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                return false;
                //break;
        }
        if (game.getWarrior().isAlive()) {return false;}
        else {return true;}
    }
    
    private boolean roomExists(int x, int y) {
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            Location[][] locations = map.getLocations(); // retreive the locations from map
            boolean answer = false;
            try {
                
                answer = map.getLocations()[x][y]!=null ;
            }
            catch(Exception e) {}
            return answer;
        
    }
   
    private void North() throws BattleControlException {     
        
        this.console.println("***You have chosen North***");
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        int row = map.getCurrentRow();
        int column = map.getCurrentColumn();
        MapControl.movePlayer(map, row, (column+1));
//        System.out.println("row: "+map.getCurrentRow());
//        System.out.println("column: "+map.getCurrentColumn());
         open();
//        map.setLocations((map.getCurrentRow()++));
//        doAction2("CL");
        //locations[row][column].getScene().getMapSymbol();
        //System.out.println(map.getCurrentLocation().getScene().getDescription());
    }
    private void South() throws BattleControlException {
        
        this.console.println("***You have chosen South***");
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        int row = map.getCurrentRow();
        int column = map.getCurrentColumn();
        MapControl.movePlayer(map, row, (column-1));
//        System.out.println("row: "+map.getCurrentRow());
//        System.out.println("column: "+map.getCurrentColumn());
        open();
    }
     private void East() throws BattleControlException {
        
        this.console.println("***You have chosen East***");
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        int row = map.getCurrentRow();
        int column = map.getCurrentColumn();
        MapControl.movePlayer(map, (row+1), column);
//        System.out.println("row: "+map.getCurrentRow());
//        System.out.println("column: "+map.getCurrentColumn());
        open();
    }
      private void West() throws BattleControlException {
        
        this.console.println("***You have chosen West***");
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        int row = map.getCurrentRow();
        int column = map.getCurrentColumn();
        MapControl.movePlayer(map, (row-1), column);
//        System.out.println("row: "+map.getCurrentRow());
//        System.out.println("column: "+map.getCurrentColumn());
        open();
    }
      
      private void open() throws BattleControlException {
        GameControl.createNewBattle();
      }

      public boolean doAction2(String mapOption) { 
          mapOption = mapOption.toUpperCase();
            Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            Location[][] locations = map.getLocations(); // retreive the locations from map
            for (int row = 0; row < locations.length; row++) {
                for (int column = 0; column < locations[row].length; column++) {
                    if (locations[row][column].getScene() != null) {
                        if (mapOption.equals(locations[row][column].getScene().getMapSymbol())) {
                            MapControl.movePlayer(map, row, column);
                            return true;
                        }
                    }
                }
            }
            System.out.println("\n*** Invalid selection *** Try Again later");
            return false;
        }
}
