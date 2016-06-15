/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.model.*;
import darkdungeongame.DarkDungeonGame;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class CharacterSelectView extends View {
    CharacterSelection warrior = GameControl.createWarrior();
    
    public CharacterSelectView() {
        super("\n"
                + "\n===================================="
                + "\n|   Please Choose your Character   |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        1. Warrior                |"
                + "\n|        2. Paladin                |"
                + "\n|        Q. Quit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }

   
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "1": //Warrior
                warrior = GameControl.createWarrior();
                this.doNext();
                GameControl.createNewGame(DarkDungeonGame.getPlayer(),warrior);
                return true;
                
            case "2": //Paladin
                warrior = GameControl.createPaladin();
                this.doNext();
                GameControl.createNewGame(DarkDungeonGame.getPlayer(),warrior);
                return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                return false;
        }
        
    }

    private void doNext() {
        
        System.out.println("You have chosen a " + warrior.getCharacterName() +" "+ warrior.getCharacterClass());
        
        
    }

    
   
}
