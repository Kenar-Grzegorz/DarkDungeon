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
import byui.cit260.darkdungeon.model.Monster;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bill
 */
public class ItemMenuView extends View {
        
    public ItemMenuView() {
                super("\n"
                + "\n====================================="
                + "\n|              ITEM                 |"
                + "\n====================================="
                + "\n| Options:                          |"
                + "\n|        P. Potion                  |"
                + "\n|        E. Ether                   |"
                + "\n|        T. Tent                    |"
                + "\n|        F. Fire Scroll             |"
                + "\n|        B. Back to Previous Menu   |"
                + "\n====================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "P": {
                try {
                    //potion
                    this.usePotion();
                } catch (MapControlException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
            }
                return true;
            case "E": {
                this.useEther();
                return true;
            }
            case "T": {
                this.useTent();
                return true;
            }
            case "F": {
                try {
                    //Fire Scroll
                    this.useFireScroll();
                } catch (MapControlException ex) {
                    ErrorView.display(this.getClass().getName(),ex.getMessage());
                }
            }
                return true;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    private void usePotion() throws MapControlException {
        BattleControl.heal(game.getPotion(), game.getWarrior());
        
        
    }
    private void useFireScroll() throws MapControlException { 
        BattleControl.itemDefend(game.getWarrior(), game.getMonster(), game.getFirescroll());
    }

    private void useEther() {
        if (game.getEther().getItemAmount()>0)BattleControl.useEther(game.getWarrior(), game.getEther());
        else System.out.println("You do not have enough Ethers");
    }

    private void useTent() {
        if (game.getTent().getItemAmount()>0)BattleControl.useTent(game.getWarrior(), game.getTent());
        else System.out.println("You do not have enough Tents");
    }
}
