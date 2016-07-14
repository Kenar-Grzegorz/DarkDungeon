/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.*;
import static byui.cit260.darkdungeon.control.GameControl.game;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.exception.MapControlException;
import darkdungeongame.DarkDungeonGame;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author William Murray
 * Class: CIT 260 
 * Lesson 7 - Individual Assignment 
 */
public class TreasureChestView {
    protected final BufferedReader keyboard = DarkDungeonGame.getInFile();
    protected final PrintWriter console = DarkDungeonGame.getOutFile();
    Random rand = new Random();
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

    public boolean ChestOpenView() throws BattleControlException, MapControlException {
        boolean done = false; // set to not done
        do {
        calculate();
        this.console.println("" + this.question);
        this.console.println("What is " + getRandom1() + " + " + getRandom2());
        // prompt for and get players name
        this.console.println("Please enter the first number between 1 and 20");
        int value1 = this.getMenuOption();
        //display next view
        done = this.doAction(value1);
            
        
        } while (!done);
        return done;
    }

    private int getMenuOption() {
        
        int value= 0;
        String input = ""; //value to be returned
        try {
            while (true) { // loop while an invalid value is entered

                this.console.print("Number ~~~~~~~~~~~> ");
                input = keyboard.readLine();
                input = input.trim(); //trim off leading and trailing blanks
                if (input.length() <1) { //Check if value is blank
                    ErrorView.display(this.getClass().getName(),"\nValue cannot be blank");
                    continue;
                }
                else {
                    try { // check for a integer value
                        value = Integer.parseInt(input);
                        if (value <1||value>20){ //Check if value is betwen 1 and 10
                            ErrorView.display(this.getClass().getName(),"\nValue has to be between 0 and 20");
                            continue;}
                        else {break;}
                    }
                    catch (NumberFormatException ne) {
                        ErrorView.display(this.getClass().getName(),"\nValue must be a number!");
                    }
                }
            }
        }
        catch (Exception e) {ErrorView.display(this.getClass().getName(),"Error Reading Input: " + e.getMessage());}
        return value; // return the value
    }

    private void calculate() throws BattleControlException {
        try {
            setRandom1(random1 = BattleControl.random(0, 10));
            setRandom2(random2 = BattleControl.random(0, 10));
            setAnswer(answer = random1 + random2);
        }
        catch (Throwable tc) {
            ErrorView.display(this.getClass().getName(),tc.getMessage());
        }
        
    }

    private boolean doAction(int userAnswer) throws MapControlException {

        if (userAnswer==getAnswer()) { 
            choice1();
            return true;
        } 

        else {
            choice2();
            return false;
        }
    }

    private void choice1() throws MapControlException{
        System.out.println("You have answered the question correctly! " + random1 + " + " + random2 + " = " + answer);
        System.out.print("The Chest is now open, you have recieved ");
        BattleControl.addPotion(game.getPotion());System.out.print("1 potion ");
        if (rand.nextInt(100) < 85) {BattleControl.addFirescroll(game.getFirescroll());System.out.print("1 fireScroll");}
        if (rand.nextInt(100) < 40) {BattleControl.addManatoMana(game.getEther());System.out.print("1 vile of ether");}
        if (rand.nextInt(100) < 35) {BattleControl.addTent(game.getTent());System.out.print("1 Tent");}
    }
    private void choice2(){
        ErrorView.display(this.getClass().getName(),"incorrect try again");

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