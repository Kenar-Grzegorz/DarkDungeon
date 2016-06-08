/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.GameControl;
import darkdungeongame.DarkDungeonGame;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class MoveView {
    private final String promptMessage;
    private final String menu;
    public MoveView() {
        this.menu = "\n"
                  + "\n|=====================================|"
                  + "\n|               Movement              |"
                  + "\n|=====================================|"
                  + "\n|    N - North                        |"
                  + "\n|    S - South                        |"
                  + "\n|    E - East                         |"
                  + "\n|    W - West                         |"
                  + "\n|    Q - Run out of the dungeon       |"
                  + "\n|=====================================|";
        
        this.promptMessage = "Which direction would you like to travel? ~~~>";
    }
    
  public void displayMenu() {
      boolean done = false; // set flag to not done
        do{
            //prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q") )// user wants to quit)
                        return; // exist the game
            
            // do the requested action and display the next view
            done = this. doAction(menuOption);
        } while (!done);   
        }

      private String getMenuOption() {
         Scanner Keyboard = new Scanner (System.in); // get infile for keyboard
     String value = ""; // value to be returned
     boolean valid = false; // initialize to not valid
     
     while (!valid){ // loop while an invalid value is enter
         System.out.println("" + this.menu);
         System.out.print("" + this.promptMessage);
         
         value = Keyboard.nextLine(); // get next line typed on keyboard
         value = value. trim(); // trim off leading and trailing blanks
         
         if (value.length()< 1) { // value is blank
             System.out.println("\nInvalid value: value can not be blank");
             continue;    
         }
         break; // end the loop
    }
    return value;
      }  

   private boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "N": //North
                
                this.North();
                break;
            case "S": //South
                this.South();
                break;
            case "E": //East
                this.East();
                break;
              case "W": //West
                this.West();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void North() {
        
        System.out.println("***You have chosen North***");
        open();
    }
    private void South() {
        
        System.out.println("***You have chosen South***");
        open();
    }
     private void East() {
        
        System.out.println("***You have chosen East***");
        open();
    }
      private void West() {
        
        System.out.println("***You have chosen West***");
        open();
    }
      
      private void open() {
        OpenDoorView openDoor = new OpenDoorView();
            boolean open = openDoor.moveView();
            if (open==true) {
                System.out.println("\tDoor Opened!");
                GameControl.createNewBattle(DarkDungeonGame.getPlayer(), GameControl.getWarrior());
            }
            else {
                System.out.println("\t");
            }
      }
   
}
