/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

/**
 *
 * @author Greg
 */
public class AssignmentTwoView extends View{
    
    public AssignmentTwoView() {
                super("\n"
                + "\n===================================="
                + "\n|         ASSIGNMENT ONE           |"
                + "\n===================================="
                + "\n| OPTIONS:                         |"
                + "\n|        D. OPTION 3               |"
                + "\n|        E. OPTION 4               |"
                + "\n|        F. EXIT                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "D":
               System.out.println("\n*** YOU CHOSE OPTION 3 ***");  
            case "E":
                 System.out.println("\n*** YOU CHOSE OPTION 4 ***");
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
   
}
