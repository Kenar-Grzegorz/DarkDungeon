/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class HelpMenuView {
    private String helpMenu;
    private String goal;
    private String movement;
    private String backstory;

    public HelpMenuView() {
        this.helpMenu = "\n"
                + "\n===================================="
                + "\n|           Help Menu              |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|   G. Goal of the Game            |"
                + "\n|   M. Movement                    |"
                + "\n|   B. Back Story                  |"
                + "\n|   Q. Quit                        |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ";
        this.goal = "\n"
                   +"\n\t================================================================================================="
                   +"\n\t=  There have been reports that some evil force may have occupied the ruins of Caer Darkin,     ="
                   +"\n\t=  an ancient stronghold, in the Trel mountian range. The source of the reports has mainly      ="
                   +"\n\t=  been miners and sheep herders who have reported seeing strange things in the area near the   ="
                   +"\n\t=  castle.                                                                                      ="
                   +"\n\t=                                                                                               ="
                   +"\n\t=  You have been approached by the mayor of the village of Van Kalen to find out what is going  ="
                   +"\n\t=  on. He tells you The town folk are simple people with little experience in the supernatural  ="
                   +"\n\t=  and the ways of magic. He has sent runners to the local garrison in the city of Silvermist   ="
                   +"\n\t=  requesting assistance but the captain of the garrison sent word back that he won’t be able   ="
                   +"\n\t=  to send help for at least several weeks.                                                     ="
                   +"\n\t=                                                                                               =" 
                   +"\n\t=  Luckily you happened to be journeying through the mountains to Silvermist when you stopped   ="
                   +"\n\t=  in the village for the night. They Mayor has hired you to scout the area, explore the ruins, ="
                   +"\n\t=  and determine what exactly what is happening and who is responsible. Enter the goals here    ="
                   +"\n\t=================================================================================================";
        this.movement = "\n"
                   +"\n\t==============================================="
                   +"\n\t=  This will explain the movements, " 
                   +"\n\t=  Enter the movements here"
                   +"\n\t===============================================";
        this.backstory = "\n"
                   +"\n\t==============================================="
                   +"\n\t=  This is the backstory, " 
                   +"\n\t=  Enter the backstory here"
                   +"\n\t===============================================";
   }

    public void displayHelpMenuView() {
        boolean done = false; // set to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
        
       
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.print(this.helpMenu);
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
    

    private boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "G": //Goal of the game
                this.gameGoals();
                break;
            case "M": //Movement
                this.movementInstructions();
                break;
            case "B": //Back Story
                this.backStory();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void gameGoals() {
        System.out.print(this.goal);
    }

    private void movementInstructions() {
        System.out.println(this.movement);
    }

    private void backStory() {
        System.out.println(this.backstory);
    }
}
