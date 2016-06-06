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
public class StartProgramView {
    
    private String promptMessage;

    public StartProgramView() {
        this.promptMessage = "===================================="
                         + "\n| Please Choose your Name          |"
                         + "\n===================================="
                         + "\nPlease enter your name~~~> ";
        this.displayBaner();
    }

    private void displayBaner() {
    System.out.println(
       "\t*******************************************************************************************"
    +"\n\t*          ____  ___    ____  __ __    ____  __  ___   __________________  _   __         *"
    +"\n\t*         / __ \\/   |  / __ \\/ //_/   / __ \\/ / / / | / / ____/ ____/ __ \\/ | / /         *"
    +"\n\t*        / / / / /| | / /_/ / ,<     / / / / / / /  |/ / / __/ __/ / / / /  |/ /          *"
    +"\n\t*       / /_/ / ___ |/ _, _/ /| |   / /_/ / /_/ / /|  / /_/ / /___/ /_/ / /|  /           *"
    +"\n\t*      /_____/_/  |_/_/ |_/_/ |_|  /_____/\\____/_/ |_/\\____/_____/\\____/_/ |_/            *"
    +"\n\t*******************************************************************************************\n");

                                                                                  
        System.out.println(
            "\t*******************************************************************************************"
         +"\n\t*    In the waning days of the Demon Wars the Paladin Hends Solthresh made an unholy deal *"
         +"\n\t* with Thantos the God of Death to save his party from destruction. Though Thantos is a   *"
         +"\n\t* neutral God promising to serve any other God violated his oath of fealty to Praydon.    *"
         +"\n\t* Hends was repudiated by Praydon and strip of his Paladinhood.                           *"
         +"\n\t*                                                                                         *"
         +"\n\t*    The God of Death immediately made Hends his servant and avatar. It is said that the  *"
         +"\n\t* rejection by Praydon darkened Hends heart and that over the years as he served Thantos  *"
         +"\n\t* he sought a way to wreck vengeance on the world. Stories say that one day he betrayed   *"
         +"\n\t* Thantos and stole a powerful magic item from the God that allowed Hends to raise and    *"
         +"\n\t* control the dead and thus was born the Necromancer. Little has been heard from Hends    *"
         +"\n\t* since that time but dark rumors say he is in hiding building up his forces to strike.   *"
         +"\n\t*******************************************************************************************\n");
        
    }

    public void displayStartProgramView() {
        boolean done = false; // set to not done
        do {
            //get player name
            String playersName = this.getPlayersName();
            
            if (playersName.toUpperCase().equals("q")) //quit
                return; // exit game
            //do the requested action
            done = this.doAction(playersName);
        } while (!done);
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.print(this.promptMessage);
            value = keyboard.nextLine(); //get next line typed
            value = value.trim(); //trim off leading and trailing blanks
            if (value.length() <1) { //value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            break; //end of loop
            
        }
        
        return value; // return the value
    }

    private boolean doAction(String playersName) {
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
        mainMenuView.displayMainMenuView();
        System.out.println("\n**************************************"  
                                                +"********************");
        System.out.println("\t # THANKS FOR PLAYING!! Goodbye #");
        System.out.println("**************************************"
                                                +"********************/n");
    }
    
    
    
}
