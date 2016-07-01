/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.exception.BattleControlException;
import java.util.Scanner;

/**
 *
 * @author William Murray
 * Class: CIT 260 
 * Lesson 7 - Individual Assignment 
 */
public class TreasureChestView {
    private String question;
    private int random1;
    private int random2;
    private int answer;
/* 
 * This Function occurs when a monster is defeated, Players will be asked to
 * Solve a problem to open the Monsters Treasure Chest.
 */
    public TreasureChestView() {
        this.question = "\nThe monster has dropped a locked chest"
                        + "\nPlease answer the equation to gain access";
     }

    public boolean ChestOpenView() throws BattleControlException {
        boolean done = false; // set to not done
        do {
        calculate();
        System.out.println("" + this.question);
        System.out.println("What is " + getRandom1() + " + " + getRandom2());
        // prompt for and get players name
        System.out.println("Please enter the first number between 1 and 20");
        int value1 = this.getMenuOption();
        //display next view
        done = this.doAction(value1);
            
        
        } while (!done);
        return done;
    }

    private int getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // create infile
        int value= 0;
        String input = ""; //value to be returned

        while (true) { // loop while an invalid value is entered

            System.out.print("Number ~~~~~~~~~~~> ");
            input = keyboard.nextLine();
            input = input.trim(); //trim off leading and trailing blanks
            if (input.length() <1) { //Check if value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            else {
                try { // check for a integer value
                    value = Integer.parseInt(input);
                    if (value <1||value>20){ //Check if value is betwen 1 and 10
                        System.out.println("\nValue has to be between 0 and 20");
                        continue;}
                    else {break;}
                }
                catch (NumberFormatException ne) {
                    System.out.println("\nValue must be a number!");
                }
            }
        }
        return value; // return the value
    }

    private void calculate() throws BattleControlException {
        setRandom1(random1 = BattleControl.random(0, 10));
        setRandom2(random2 = BattleControl.random(0, 10));
        setAnswer(answer = random1 + random2);
    }

    private boolean doAction(int userAnswer) {

        if (userAnswer==getAnswer()) { 
            choice1();
            return true;
        } 

        else {
            choice2();
            return false;
        }
    }

    private void choice1(){
        System.out.println("You have answered the question correctly! " + random1 + " + " + random2 + " = " + answer);
        System.out.println("The Chest is now open");
    }
    private void choice2(){
        System.out.println("incorrect try again");

    }

    public int getRandom1() {
        return random1;
    }

    public void setRandom1(int random1) {
        this.random1 = random1;
    }

    public int getRandom2() {
        return random2;
    }

    public void setRandom2(int random2) {
        this.random2 = random2;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
}