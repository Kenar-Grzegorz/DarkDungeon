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
public class MoveView extends View{
    //private final String promptMessage;
    //private final String menu;
    public MoveView() {
        super("\n"
                  + "\n|=====================================|"
                  + "\n|               Movement              |"
                  + "\n|=====================================|"
                  + "\n|    N - North                        |"
                  + "\n|    S - South                        |"
                  + "\n|    E - East                         |"
                  + "\n|    W - West                         |"
                  + "\n|    Q - Run out of the dungeon       |"
                  + "\n|=====================================|"
                  + "\nWhich direction would you like to travel? ~~~>");
    }
    
  
    @Override
   public boolean doAction(String choice) {
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
        GameControl.createNewBattle();
      }
   
}
