/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

/**
 *
 * @author Bill
 */
public class StartAdventureView extends View {
        
    public StartAdventureView() {
                super("\n"
                + "\n===================================="
                + "\n|         ASSIGNMENT ONE           |"
                + "\n===================================="
                + "\n| OPTIONS:                         |"
                + "\n|        A. OPTION 1               |"
                + "\n|        B. OPTION 2               |"
                + "\n|        C. EXIT                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "A":
               System.out.println("\n*** YOU CHOSE OPTION 1 ***");  
            case "B":
                 System.out.println("\n*** YOU CHOSE OPTION 2 ***");
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
   
}
   
