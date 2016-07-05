/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.BattleControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.CharacterSelection;
import darkdungeongame.DarkDungeonGame;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Greg K
 */
public class EscapeView {
    private int value;
    protected final BufferedReader keyboard = DarkDungeonGame.getInFile();
    protected final PrintWriter console = DarkDungeonGame.getOutFile();

    public EscapeView() {
                
   }

    public boolean displayMainMenuView(CharacterSelection character) throws BattleControlException {
       
            // prompt for and get players name
            this.console.println("Please enter the first number between 0 and 10");
            int value1 = this.getMenuOption();
            this.console.println("Please enter the second numberbetween 0 and 10");
            int value2 = this.getMenuOption();
            //display next view
            boolean done = this.doAction(value1, value2, character);
            return done;
        
       
    }

    private int getMenuOption() {
        
        int value= 0;
        String input = ""; //value to be returned
        
        while (true) { // loop while an invalid value is entered
            
            this.console.print("Number ~~~~~~~~~~~> ");
            try {    
                input = keyboard.readLine();
                input = input.trim(); //trim off leading and trailing blanks
                if (input.length() <1) { //Check if value is blank
                    ErrorView.display(this.getClass().getName(),"Value cannot be blank");
                    continue;
                }
                else {
                    try {
                        value = Integer.parseInt(input);
                        if (value <0||value>10){ //value is blank
                            ErrorView.display(this.getClass().getName(),"Value has to be between 0 and 10");
                            continue;}
                        else {break;}
                    }
                    catch (NumberFormatException ne) {
                        ErrorView.display(this.getClass().getName(),"Value must be a number!");
                    }
                }
            }
            catch (Exception e) {ErrorView.display(this.getClass().getName(),"Error Reading Input: " + e.getMessage());}
        }
        return value; // return the value
    }
    

    private boolean doAction(int value1, int value2,CharacterSelection character) throws BattleControlException {
        int random = BattleControl.random(0, 10);
        if ((value1+value2+random)%2==0) {
            this.choice1();
            return true;
        }
        else {
            if (random%2==0){
                this.choice3(character);
                return false;
            }
            else {this.choice2();
            return false;
            }
           
        }
    }

    private void choice1(){
        this.console.println("You have chosen correctly");
    }
    private void choice2(){
        this.console.println("You have chosen incorrectly");
    }
    private void choice3(CharacterSelection character){
        this.console.println("You have chosen incorrectly, but someone gave you a fighting chance to heal you by 40HP");
        character.setHealth(character.getHealth()+40);
    }
}
