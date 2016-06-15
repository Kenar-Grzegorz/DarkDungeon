/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.control.*;
import java.util.Scanner;

/**
 *
 * @author Greg K, Bill M, Florian K
 */
public class StartProgramView extends View {

    public StartProgramView() {
        super("===================================="
         + "\n| Please Choose your Name          |"
         + "\n===================================="
         + "\nPlease enter your name~~~> ");
    }
    @Override
    public boolean doAction(String playersName) {
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
            +"The name must be greater than one character in length");
            return false;
        }
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        if (player == null) { //if unsuccessfull
            System.out.println("\nError Creating the plater.");
            return false;
        }
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n\t==============================================="
                          +"\n\t=  Welcome to the game " + player.getName() 
                          +"\n\t=  I hope your not afraid of the dark!"
                          +"\n\t===============================================");
        //Create main menu object
        
        MainMenuView mainMenuView = new MainMenuView();
        //Display the main menu view
        mainMenuView.display();
        System.out.println("\n**************************************"  
                                                +"********************");
        System.out.println("\t # THANKS FOR PLAYING!! Goodbye #");
        System.out.println("**************************************"
                                                +"********************/n");
    }
    
    
    
}
