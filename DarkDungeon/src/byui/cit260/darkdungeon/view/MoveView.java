/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;



import byui.cit260.darkdungeon.control.GameControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Game;
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
                try {
                    this.North();
                }
                catch (Throwable mo) {
                    System.out.println(mo);
                }
                break;
            case "S": //South
                try {
                    this.South();
                    }
                catch (Throwable mo) {
                    System.out.println(mo);
                }
                break;
            case "E": //East
                try {
                    this.East();
                    }
                catch (Throwable mo) {
                    System.out.println(mo);
                }
                break;
            case "W": //West
                try {
                    this.West();
                    }
                catch (Throwable mo) {
                    System.out.println(mo);
                }
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void North() throws BattleControlException {     
        
        System.out.println("***You have chosen North***");
        open();
    }
    private void South() throws BattleControlException {
        
        System.out.println("***You have chosen South***");
        open();
    }
     private void East() throws BattleControlException {
        
        System.out.println("***You have chosen East***");
        open();
    }
      private void West() throws BattleControlException {
        
        System.out.println("***You have chosen West***");
        open();
    }
      
      private void open() throws BattleControlException {
        GameControl.createNewBattle();
      }
   
}
