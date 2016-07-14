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
       if (game.getPotion().getItemAmount()>0){
           this.console.println("*  You have used a potion  *  `  `  \\ \\(`^')/ /  '  '\n");
           BattleControl.heal(game.getPotion(), game.getWarrior());
            this.console.println(warrior.getCharacterName()+" drinks a healing potion. You have "+game.getPotion().getItemAmount()+" left.");
            this.console.println(warrior.getStatus());
        } else {
            ErrorView.display(this.getClass().getName(),"*  You've exhausted your potion supply!  *\n");
        }
        
    }
    private void useFireScroll() throws MapControlException { 
        if (game.getFirescroll().getItemAmount()>0){
            this.console.println("*  You have activated the "+game.getFirescroll().getItemName()+ " *\n" + game.getFirescroll().getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            BattleControl.itemDefend(game.getWarrior(), game.getMonster(), game.getFirescroll());
            this.console.println("You have hit the "+ game.getMonster().getMonsterName()+" for "+game.getFirescroll().getItemDamage()+" of Damage!!");
            try {
                if (game.getMonster().getHealth() == 0||game.getMonster() == null) {
                    this.console.println("\t" + game.getPlayer().getName() + " transforms the skull of " + game.getMonster().getMonsterName()
                    + " into dust to never be seen again");
                }
            }
            catch (Exception e) {}
        }
        else {
            this.console.println("You have exhausted your Mana amount, You have: "+game.getWarrior().getManaAmount()+" Mana");
        }
    }

    private void useEther() {
        if (game.getEther().getItemAmount()>0){
            this.console.println("*  You have activated the "+game.getEther().getItemName()+ " *\n" + game.getEther().getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            BattleControl.useEther(game.getWarrior(), game.getEther());
            this.console.println(warrior.getManaStatus());
           
        }
        else this.console.println("You do not have enough Ethers");
    }

    private void useTent() {
        if (game.getTent().getItemAmount()>0){
            this.console.println("*  You have activated the "+ game.getTent().getItemName()+ " *\n"+ game.getTent().getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            BattleControl.useTent(game.getWarrior(), game.getTent());
            this.console.println(warrior.getManaStatus()+" "+warrior.getStatus());
        }
        else this.console.println("You do not have enough Tents");
    }
}
