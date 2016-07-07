/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.model.Inventory;
import static byui.cit260.darkdungeon.control.GameControl.*;
import byui.cit260.darkdungeon.exception.MapControlException;

/**
 *
 * @author Greg
 */
public class SpecialMenuView extends View {
    //GameControl game = new GameControl();

    public SpecialMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|       Specials/Abilities         |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        O. OmniSlash              |"
                + "\n|        A. Armaggeddon            |"
                + "\n|        B. Back to Previous Menu  |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "O": //OmniSlash
                try {
                    this.useOmniSlash();
                }
                catch (Throwable sa) {
                    ErrorView.display(this.getClass().getName(),sa.getMessage());
                }
                return true;
            case "A": //Armageddon
                try {
                    this.useArmageddon();
                }
                catch (Throwable sa) {
                    ErrorView.display(this.getClass().getName(),sa.getMessage());
                }
                return true;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
     private void useOmniSlash() throws MapControlException {
         BattleControl.abilityDefend(game.getWarrior(), game.getMonster(), game.getOmniSlash());
         
    }
     private void useArmageddon() throws MapControlException {
         BattleControl.abilityDefend(game.getWarrior(), game.getMonster(), game.getArmageddon());
    }
    
    
}
