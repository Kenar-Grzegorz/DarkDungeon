/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.control.GameControl.warrior;
import static byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.model.Inventory;

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
        Inventory[] inventory = GameControl.getSortedInventoryList();
        
        
    }
     
     
    private void map() {
        MapView mapView = new MapView();
        mapView.display();
    }
    
    
    
}
