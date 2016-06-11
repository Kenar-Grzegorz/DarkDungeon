/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.BattleControl;
import byui.cit260.darkdungeon.control.MapControl;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class OpenDoorView {
    private int value;

    public OpenDoorView() {
                
   }

    public boolean moveView() {
       
            // prompt for and get players name
            System.out.println("Please enter the first number between 1 and 15");
            int value1 = this.getMenuOption();
            
            //display next view
            boolean done = this.doAction(value1);
            return done;
        
       
    }

    private int getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // create infile
        int value= 1;
        String input = ""; //value to be returned
        
        while (true) { // loop while an invalid value is entered
            
            System.out.print("Number ~~~~~~~~~~~> ");
            input = keyboard.nextLine();
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
        return value; // return the value
    }
    

    private boolean doAction(int value1) {
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


