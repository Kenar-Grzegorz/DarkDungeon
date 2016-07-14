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
   private String bannerTop;
   private String north;
   private String south;
   private String east;
   private String west;
   private String bannerBottom;
   
   int columnCurrent;
   int rowCurrent;
   boolean northPossible;
   boolean southPossible;
   boolean eastPossible;
   boolean westPossible;
   Game game;
   Map map;
//Location[][] locations = map.getLocations();
    //private final String promptMessage;
    //private final String menu;
    public MoveView() {
        this.bannerTop=("\n"
                  + "\n|=====================================|"
                  + "\n|               Movement              |"
                  + "\n|=====================================|");
        
        this.bannerBottom=("\n|    B. Back to Previous Menu         |"
                  + "\n|    Q - Quit to the Main Menu        |"
                  + "\n|=====================================|"
                  + "\nWhich direction would you like to travel? ~~~>");
        
        this.north=("\n|    N - North                        |");
        this.south=("\n|    S - South                        |");
        this.east=("\n|    E - East                         |");
        this.west=("\n|    W - West                         |");
    }
    
    @Override
    public void display() {
        game = DarkDungeonGame.getCurrentGame(); // retreive the game
        map = game.getMap(); // retreive the map from game
        boolean done = false; // set to not done
        String menuOption;
        String className = this.getClass().getSimpleName();
        
        
        do {
            try {
                if (!"MainMenuView".equals(className)&&game.getWarrior().isDead()) return;
            }
            catch (Exception e) {}
            // prompt for and get players name
            rowCurrent = map.getCurrentRow();
            columnCurrent = map.getCurrentColumn();
            northPossible = roomExists(rowCurrent,(columnCurrent+1));
            southPossible = roomExists(rowCurrent,(columnCurrent-1));
            eastPossible = roomExists((rowCurrent+1),columnCurrent);
            westPossible = roomExists((rowCurrent-1),columnCurrent);
            System.out.println(map.getCurrentLocation().getScene().getDescription());
            if (!"FN".equals(map.getCurrentLocation().getScene().getMapSymbol())){System.out.print(this.bannerTop);
            if (northPossible) System.out.print(this.north);
            if (southPossible) System.out.print(this.south);
            if (eastPossible) System.out.print(this.east);
            if (westPossible) System.out.print(this.west);
            System.out.print(this.bannerBottom);
            menuOption = this.getInput();}
            else { game.getWarrior().setHealth(0);
                    warrior.setExist(false);return;}
            if (menuOption.toUpperCase().equals("B")) //user will quit
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
                    if (northPossible)this.North();
                    else System.out.println("You cannot go in that direction");
                }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "S": //South
                try {
                    
                    if (southPossible)this.South();
                    else System.out.println("You cannot go in that direction");
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "E": //East
                try {
                    if (eastPossible)this.East();
                    else System.out.println("You cannot go in that direction");
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "W": //West
                try {
                    if (westPossible)this.West();
                    else System.out.println("You cannot go in that direction");
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
        //Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        //Map map = game.getMap(); // retreive the map from game
        //int row = map.getCurrentRow();
        //int column = map.getCurrentColumn();
        if (northPossible) {
            MapControl.movePlayer(map, rowCurrent, (columnCurrent+1));
            open();
        }
        else this.console.println("Cant go that way");
    }
    private void South() throws BattleControlException {
        
        this.console.println("***You have chosen South***");
        if (southPossible) {
            MapControl.movePlayer(map, rowCurrent, (columnCurrent-1));
            open();
        }
        else this.console.println("Cant go that way");
    }
     private void East() throws BattleControlException {
        
        this.console.println("***You have chosen East***");
        if (eastPossible) {
            MapControl.movePlayer(map, (rowCurrent+1), columnCurrent);
            open();
        }
        else this.console.println("Cant go that way");
    }
      private void West() throws BattleControlException {
        
        this.console.println("***You have chosen West***");
        if (westPossible) {
            MapControl.movePlayer(map, (rowCurrent-1), columnCurrent);
            open();
        }
        else this.console.println("Cant go that way");
    }
      
      private void open() throws BattleControlException {
        GameControl.createNewBattle(map);
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
