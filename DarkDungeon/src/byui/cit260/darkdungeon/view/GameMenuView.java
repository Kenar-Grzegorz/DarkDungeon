/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.control.GameControl.warrior;
import byui.cit260.darkdungeon.model.Game;
import static byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.model.Inventory;
import byui.cit260.darkdungeon.model.Location;
import darkdungeongame.DarkDungeonGame;

/**
 *
 * @author Greg
 */
public class GameMenuView extends View {
    GameControl game = new GameControl();
    
    public GameMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|           Game Menu              |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        C. Choose a Character     |"
                + "\n|        D. Dungeon                |"
                + "\n|        M. Map                    |"
                + "\n|        N. Map 2                  |"
                + "\n|        I. View Inventory         |"
                + "\n|        Q. Quit                   |"
                + "\n===================================="
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
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
     private void useCharCreate() {
        CharacterSelectView charSelect = new CharacterSelectView();
        charSelect.display();
         
    }
     private void useStartJourney() {
         StartAdventureView check = new StartAdventureView();
         if (warrior.isExist()== true){
            if (check.isGate() == true) {
             GameControl.createJourney();
            }
            else {check.display();}
        }    
         else {
             System.out.println("\n**************************************"  
                                                +"********************");
        System.out.println("\t # Please Select a Character First #");
        System.out.println("**************************************"
                                                +"********************\n");
        }
    }
    
    private void viewInventory() {
        StringBuilder line;
        
        Game game = DarkDungeonGame.getCurrentGame();
        Inventory[] inventory = GameControl.getSortedInventoryList();
        
        System.out.println("\n      LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                         ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "STRENGTH");
        line.insert(30, "IN STOCK");
        line.insert(40, " HEALING");
        System.out.println(line.toString());
        
        // for each inventory item
        for (Inventory item : inventory) {
            line = new StringBuilder("                                     ");
            line.insert(0, item.getItemDescription());
            line.insert(23, item.getItemDamage());
            line.insert(33, item.getItemAmount());
            line.insert(43, item.getItemHeal());
            
            
            // DISPLAY THE LINE
            System.out.println(line.toString());
            
                   
        }
        
        
        
        
    
    }  
    private void map() {
        MapView mapView = new MapView();
        mapView.display();
    }
    
    private void map2() {
        
        //get locations from the current game
        Location[][] locations = DarkDungeonGame.getCurrentGame().getMap().getLocations();
        
        //Display title
        System.out.println(
                 "\n--------------------"
                +"\n MAP OF MIDDLE EARTH"
                +"\n--------------------");
        //Display row of column numbers
        System.out.println(" -0  1  2-");
        //Display row divider
        System.out.println(" -------");
        
        //Display row numbers
        for (int i = 0; i < locations.length; i++) {
            //Display column divider
            System.out.print(i + 1 + "|");
            
            for (Location location : locations[i]) {
                
                //If location has been visited, display map symbol
                if (location.getVisited()) {
                    System.out.print(location.getScene().getMapSymbol());
                } else {
                    System.out.print("??");
                }
                //Display ending column divider 
                System.out.print("|");
            }
            //Display ending row divider
            System.out.println("\n -------");
        }
    
    }
    
    
}
