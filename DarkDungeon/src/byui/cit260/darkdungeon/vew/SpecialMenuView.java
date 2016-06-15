/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.*;

/**
 *
 * @author Greg
 */
public class SpecialMenuView extends View {
    GameControl game = new GameControl();

    public SpecialMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|       Specials/Abilities         |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        O. OmniSlash              |"
                + "\n|        A. Armaggeddon            |"
                + "\n|        X. Exit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "O": //OmniSlash
                this.useOmniSlash();
                return true;
            case "A": //Armageddon
                this.useArmageddon();
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
     private void useOmniSlash() {
         game.useOmniSlash();
         
    }
     private void useArmageddon() {
         game.useArmageddon();
    }
    
    
}
