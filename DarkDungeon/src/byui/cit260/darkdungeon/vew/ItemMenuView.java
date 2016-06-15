/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.control.*;

/**
 *
 * @author Bill
 */
public class ItemMenuView extends View {
    GameControl game = new GameControl();
        
    public ItemMenuView() {
                super("\n"
                + "\n===================================="
                + "\n|             ITEM                 |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        P. Potion                 |"
                + "\n|        F. Fire Scroll            |"
                + "\n|        X. Exit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "P": //potion
                this.usePotion();
                return true;
            case "F": //Fire Scroll
                this.useFireScroll();
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    private void usePotion() {
        game.usePotion();
    }
    private void useFireScroll() { 
        game.useFireScroll();
    }
}
