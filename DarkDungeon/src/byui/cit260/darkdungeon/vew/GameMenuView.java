/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.model.Game.*;

/**
 *
 * @author Greg
 */
public class GameMenuView extends View {
    GameControl game = new GameControl();
    boolean gate = false;
    public GameMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|           Game Menu              |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        C. Choose a Character     |"
                + "\n|        D. Dungeon                |"
                + "\n|        Q. Quit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
                
   }
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "C": 
                this.useCharCreate();
                break;
            case "D": 
                this.useStartJourney();
                break;
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
    
     private void useCharCreate() {
        CharacterSelectView charSelect = new CharacterSelectView();
        charSelect.display();
         
    }
     private void useStartJourney() {
         
         if (warrior.isExist()== true)
            
             GameControl.createJourney();
            
         else {
             System.out.println("\n**************************************"  
                                                +"********************");
        System.out.println("\t # Please Select a Character First #");
        System.out.println("**************************************"
                                                +"********************\n");
         }
    }
     
     private void gate() {
         System.out.println("\n"
            +"\n------------------------------"
            +"\n|You stand before have heard the stories of dragons"
            + "\n for years, now maybe it's time to"
            + "\n make your own. Will this be the"
            + "\n year you go on a quest and slay"
            + "\n a dragon?"
            +"\n------------------------------"
            +"\nY - Yes, I will begin the quest!"
            +"\nN - No, perhaps next summer..."
            +"\n------------------------------");
     }
    
    
}
