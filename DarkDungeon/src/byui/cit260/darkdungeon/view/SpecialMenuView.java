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
        if (game.getWarrior().getManaAmount()> game.getOmniSlash().getItemAmount()){
            this.console.println("*  You have activated the "+ game.getOmniSlash().getItemName()+ " *\n"+ game.getOmniSlash().getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            BattleControl.abilityDefend(game.getWarrior(), game.getMonster(), game.getOmniSlash());
            this.console.println("You have hit the "+ game.getMonster().getMonsterName()+" for "+game.getOmniSlash().getItemDamage()+" of Damage!!");
            try {
                if (game.getMonster().getHealth() == 0) {
                    this.console.println("\t" + game.getPlayer().getName() + " transforms the skull of " + game.getMonster().getMonsterName()
                    + " into dust to never be seen again");
                }
            }
            catch (Exception e) {}
        }
        else {
            ErrorView.display(this.getClass().getName(),"You have exhausted your Mana amount, You have: "+ game.getWarrior().getManaAmount()+" Mana");
        } 
    }
     private void useArmageddon() throws MapControlException {
         if (game.getWarrior().getManaAmount()> game.getArmageddon().getItemAmount()){
            this.console.println("*  You have activated the "+ game.getArmageddon().getItemName()+ " *\n"+ game.getArmageddon().getItemDescription()+"  `  `  \\ \\(`^')/ /  '  '\n");
            BattleControl.abilityDefend(game.getWarrior(), game.getMonster(), game.getArmageddon());
            this.console.println("You have hit the "+ game.getMonster().getMonsterName()+" for "+game.getArmageddon().getItemDamage()+" of Damage!!");
            try {
                if (game.getMonster().getHealth() == 0||game.getMonster() == null) {
                this.console.println("\t" + game.getPlayer().getName() + " transforms the skull of " + game.getMonster().getMonsterName()
                + " into dust to never be seen again");
                }
            }
            catch (Exception e) {}
        }
        else {
            ErrorView.display(this.getClass().getName(),"You have exhausted your Mana amount, You have: "+ game.getWarrior().getManaAmount()+" Mana");
        } 
         
    }
    
    
}
