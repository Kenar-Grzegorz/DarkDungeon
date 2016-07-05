/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.BattleControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.control.MapControl;
import darkdungeongame.DarkDungeonGame;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class OpenDoorView {
    private int value;
    protected final BufferedReader keyboard = DarkDungeonGame.getInFile();
    protected final PrintWriter console = DarkDungeonGame.getOutFile();

    public OpenDoorView() {
                
   }

    public boolean moveView() throws BattleControlException {
       
            // prompt for and get players name
            System.out.println("Please enter the first number between 1 and 15");
            int value1 = this.getMenuOption();
            
            //display next view
            boolean done = this.doAction(value1);
            return done;
        
       
    }

    private int getMenuOption() {
        
        int value= 1;
        String input = ""; //value to be returned
        
        while (true) { // loop while an invalid value is entered
            
            System.out.print("Number ~~~~~~~~~~~> ");
            try {
                input = this.keyboard.readLine();
                input = input.trim(); //trim off leading and trailing blanks
                if (input.length() <1) { //Check if value is blank
                    System.out.println("\nValue cannot be blank");
                }
                else {
                    try {
                        value = Integer.parseInt(input);
                        if (value <1||value>15){ //value is blank
                            System.out.println("\nValue has to be between 0 and 10");
                        }
                        else {break;}
                    }
                    catch (NumberFormatException ne) {
                        System.out.println("\nValue must be a number!");
                    }
                }
            }
            catch (Exception e) {System.out.println("Error Reading Input: " + e.getMessage());}
        }
        return value; // return the value
    }
    

    private boolean doAction(int value1) throws BattleControlException {
        try {
            int random = BattleControl.random(1, 10);
            if ((value1+random)%2==0) {
                this.choice1();
                return true;
            }
            else {
                if (random%2==0){
                    this.choice3();
                    return true;
                }
                else {this.choice2();
                return false;
                }
            }
        }
        catch (Throwable xe) {
           System.out.println("You were wrong, rethink your life decisions");
           return false;
        }
    }

    private void choice1(){
        System.out.println("Door is open enter");
    }
    private void choice2(){
        System.out.println("incorrect try again");
    }
    private void choice3(){
        System.out.println("You have chosen incorrectly, but you can enter because entry is close");
        
    }
}


