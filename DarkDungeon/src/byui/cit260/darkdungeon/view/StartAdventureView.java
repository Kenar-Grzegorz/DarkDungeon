/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

/**
 *
 * @author Greg
 */
public class StartAdventureView extends View {
    private static boolean gate = false;    
    public StartAdventureView() {
                super("\n***************************************"
                    + "\n* You are standing before a Dungeon   *"
                    + "\n* with a iron gate. You hear the      *"
                    + "\n* sounds of pain and anguish inside.  *"
                    + "\n* You remember the happy place in the *"
                    + "\n* fields of your home that you spent  *"
                    + "\n* with your children. Do you enter    *"
                    + "\n* dungeon?                            *"
                    + "\n***************************************"
                + "\n\n"
                + "\n===================================="
                + "\n|     Would you like to Enter      |"
                + "\n===================================="
                + "\n| OPTIONS:                         |"
                + "\n|        Y. Yes                    |"
                + "\n|        N. No                     |"
                + "\n|        Q. EXIT                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "Y":
               System.out.println("\n*** YOU HAVE CHOSEN TO ENTER THE DUNGEON  ***"
                       + "\n***          PRESS D TO ENTER         ***");
               StartAdventureView.gate= true;
               
               return true;
            case "N":
                 System.out.println("*********************************************"
                                + "\n* The yard looks beautiful and it would     *"
                                + "\n* be a shame to let it go. better leave the *"
                                + "\n* adventures for someone else.              *"
                                + "\n*********************************************");
                 return true;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    public boolean isGate() {
        return gate;
    }
    
   
}
   
