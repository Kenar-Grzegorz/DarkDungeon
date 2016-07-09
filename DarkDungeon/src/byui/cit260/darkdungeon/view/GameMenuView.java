/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.control.GameControl.game;
import static byui.cit260.darkdungeon.control.GameControl.warrior;
import byui.cit260.darkdungeon.enums.Item;
import byui.cit260.darkdungeon.exception.GameControlException;
import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Game;
import static byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.model.Inventory;
import byui.cit260.darkdungeon.model.Location;
import byui.cit260.darkdungeon.model.Map;
import byui.cit260.darkdungeon.model.Scene;
import darkdungeongame.DarkDungeonGame;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Greg
 */
public class GameMenuView extends View {

    
    public boolean gate;

    public GameMenuView() {
        super("\n"
                + "\n====================================="
                + "\n|           Game Menu               |"
                + "\n====================================="
                + "\n| Options:                          |"
                + "\n|        C. Choose a Character      |"
                + "\n|        D. Dungeon                 |"
                + "\n|        M. Map                     |"
                + "\n|        N. Map 2                   |"
                + "\n|        I. View Inventory          |"
                + "\n|        P. Print Locations         |"
                + "\n|        PP. Print Names            |"
                + "\n|        PI. Print Inventory        |"
                + "\n|        S. Save Game               |"
                + "\n|        B. Back to Previous Menu   |"
                + "\n====================================="
                + "\nMake your Selection ~~~> ");

    }

    @Override
    public boolean doAction(String choice) {
       
        
        choice = choice.toUpperCase(); //convert to uppercase

        switch (choice) {
            case "C":
                this.useCharCreate();
                break;
            case "D":
                this.useStartJourney();
                break;
            case "M":
                this.map();
                break;
            case "N":
                this.map2();
                break;
            case "I":
                this.viewInventory();
                break;
            case "P": {
            try {
                //print to file
                this.printLocations();
            } catch (GameControlException ex) {
                Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "pp":
        
                this.savePlayerNames();
            
                break;
            case "PI":
                this.printInventoty();
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
        catch (Exception e) {System.out.println("Error Reading Input: " + e.getMessage());
        }
        return value; // return the value
    }
    
    private void useCharCreate() {
        CharacterSelectView charSelect = new CharacterSelectView();
        charSelect.displayCharacterSelectView();

    }

    private void useStartJourney() {
        StartAdventureView check = new StartAdventureView();
        //CharacterSelection charac = new CharacterSelection();
        Game gameClass = new Game();
        if (warrior.isExist() == false || game.getWarrior().getHealth()==0) {
            this.console.println("\n**************************************"
                    + "********************");
            this.console.println("\t # Please Select a Character First #");
            this.console.println("**************************************"
                    + "********************\n");
            CharacterSelectView charSelect = new CharacterSelectView();
            charSelect.displayCharacterSelectView();
        }
        if (check.isGate() == false) {
                check.display();
        }
        if (warrior.isExist() == true && check.isGate() == true && game.getWarrior().getHealth()>0) { 
            GameControl.createJourney();
        }
        else {
            this.console.println("\n**************************************"
                    + "********************");
            this.console.println("\t # Please Come Back when you are ready #");
            this.console.println("**************************************"
                    + "********************\n");
        }
    }

    private void viewInventory() {
        GameControl gamec = new GameControl();
        StringBuilder line;
        Game game = DarkDungeonGame.getCurrentGame();
        Inventory[] inventory = game.getInventory();
        this.console.println("\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                                                                         ");
        line.insert(0, "NAME");
        //line.insert(10, "DESCRIPTION");
        line.insert(15, "STRENGTH");
        line.insert(25, "IN STOCK");

        ErrorView.display(this.getClass().getName(),line.toString());

        // for each inventory item
        for (Inventory item : inventory) {

            line = new StringBuilder("                                                                     ");
            line.insert(0, item.getItemName());
            //line.insert(13, item.getItemDescription());
            line.insert(18, item.getItemDamage());
            line.insert(28, item.getItemAmount());

            // DISPLAY THE LINE
            this.console.println(line.toString());
        }
        //percent of items
        int numItems = gamec.getNumberOfItems(); //gets from GameControl Folder
        int emptyItem = gamec.getNumberOfEmptyItems();  //gets from GameControl Folder
        int Average = 100-((emptyItem *100) / numItems); // gets average
        this.console.println("\n You have "+emptyItem+" empty items of "+numItems+" or you have "+Average+"% of your items.");
    }

    private void map2() {
        MapView mapView = new MapView();
        mapView.display();
    }

    private void map() {

        String leftIndicator;
        String rightIndicator;

        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Scene scene = new Scene();
        Location[][] locations = map.getLocations(); // retreive the locations from map
        try {
            this.console.print("   |");
            for (int column = 0; column < locations[0].length; column++) {
                if (column < 10) {
                    this.console.print(" " + column + "  |");
                } // print col numbers to side of map;
                else {
                    this.console.print(" " + column + " |");
                } // print col numbers to side of map;
            }
            this.console.println();
                for (int row = 0; row < locations.length; row++) {
                    if (row < 10) {
                        this.console.print(row + "  ");
                    } else {
                        this.console.print(row + " ");
                    } // print row numbers to side of map
                    for (int column = 0; column < locations[row].length; column++) {
                        leftIndicator = " ";
                        rightIndicator = " ";
                        if (locations[row][column] == map.getCurrentLocation()) {
                            leftIndicator = "*"; // can be stars or whatever these are indicators showing visited
                            rightIndicator = "*"; // same as above
                        } else if (locations[row][column].isVisited()) {
                            leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                            rightIndicator = "<"; // same as above
                        }
                        this.console.print("|"); // start map with a |
                        if (locations[row][column].getScene() == null) {
                            this.console.print(leftIndicator + "??" + rightIndicator);
                        } else {
                            if (locations[row][column].getScene().getMapSymbol() == null) {
                                this.console.print(leftIndicator + "XX" + rightIndicator);
                            } else {
                                this.console.print(leftIndicator + locations[row][column].getScene().getMapSymbol() + rightIndicator);
                            }
                        }
                    }
                    this.console.println("|");
                }
            } 
            catch (Exception e) {
                ErrorView.display(this.getClass().getName(),"Error");
            }
        // calculate percentage of map
        GameControl gamec = new GameControl();
        double amountMaps = gamec.numberOfLocations(); //gets from GameControl Folder
        double visited = gamec.placesVisited(map);  //gets from GameControl Folder
        double calc = (visited * 100) / amountMaps; // gets average
        if ( visited>amountMaps || amountMaps<1 || calc>100) ErrorView.display(this.getClass().getName(),"error"); //checks for errors
        else {double average = Math.round(calc*100); //rounds to 2 decimal
            average = average/100;
            this.console.println("\n>> You have visited "+visited+" of "+ amountMaps +" locations or "+average+"% of the map <<");
        }
    }

    private void printLocations() throws GameControlException{
        System.out.println("\n\nEnter the file path for file where the game is to be saved.");
        String filePath = this.getInput2();
        boolean response = true;
        try {
            response = GameControl.printLocation(filePath);
        } 
        catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
        if (response == true) {this.console.println("Your file print completed successfully");
        }
        else {this.console.println("Your file didnt print did not complete successfully");}
    }
    
    public void savePlayerNames()  {
        System.out.println("\n\nEnter the file path for file where the game is to be saved.");
        String filePath = this.getInput2();
        try {
            GameControl.printNames(filePath);
        } catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
    
    private void printInventoty() {
        System.out.println("\n\nEnter the file path for file where the game is to be saved.");
        String filePath = this.getInput2();
        boolean response = false;
        try {
            response = GameControl.printInventory(filePath);
        } catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
        if (response == true) {this.console.println("Your file print completed successfully");
        }
        else {this.console.println("Your file didnt print did not complete successfully");}
    }
    
    private void saveGame() {
        if (warrior.isExist() == true) {
            System.out.println("\n\nEnter the file path for file where the game is to be saved.");
            String filePath = this.getInput2();

            try {
                GameControl.saveGame(DarkDungeonGame.getCurrentGame(), filePath);
            } catch (Exception ex){
                ErrorView.display("MainMenuView", ex.getMessage());
            }
        }
        else {
            ErrorView.display(this.getClass().getName(),"**************************************"
                    + "********************");
            ErrorView.display(this.getClass().getName(),"\t # Please Select a Character First #");
            ErrorView.display(this.getClass().getName(),"**************************************"
                    + "********************\n");
        }
    }
    
    public Scene scenePrint() {
        Scene.SceneType[] scenes = Scene.SceneType.values();
        String places = "test";
        this.console.println(places);
//                for (SceneType scene : scenes){
//            System.out.println(
//                    "\n -----------------------------"
//                    + "\n Locations and Descriptions"
//                    + "\n -----------------------------"
//                    + scene 
//                    + ":   \t" 
//                    + scene.getDescription());
//        }
        return null;
    }
    
    public boolean isGate() {
        return gate;
    }

    public void setGate(boolean gate) {
        this.gate = gate;
    }

}
