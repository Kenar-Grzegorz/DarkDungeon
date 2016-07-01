/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.control.*;
import static byui.cit260.darkdungeon.control.GameControl.*;
import byui.cit260.darkdungeon.enums.Item;
import byui.cit260.darkdungeon.exception.MapControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bill
 */
public class ItemMenuView extends View {
        
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
            case "F": {
            try {
                //Fire Scroll
                this.useFireScroll();
            } catch (MapControlException ex) {
                System.out.println(ex.getMessage());
            }
        }
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    private void usePotion() {
        BattleControl.heal(game.getPotion(), game.getWarrior());
        
        
    }
    private void useFireScroll() throws MapControlException { 
        BattleControl.abilityDefend(game.getWarrior(), game.getMonster(), game.getFirescroll());
    }
}
