/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

/**
 *
 * @author Bill 
 */
public class MapView extends View{
    
    public MapView() {
                super("\n"
                + "\n===================================="
                + "\n|         DUNGEON MAP              |"
                + "\n===================================="
                + "\n| OPTIONS:                         |"
                + "\n|        A. Level One              |"
                + "\n|        B. Level Two              |"
                + "\n|        Q. Quit                   |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "A":
                 this.console.println("\n*** LEVEL ONE OF THE DUNGEON ***"); 
                 this.levelOne();
                 break;
            case "B":
                 this.console.println("\n*** LEVEL TWO OF THE DUNGEON ***");
                 this.levelTwo();
                 break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
     private void levelOne() {
        this.console.println("\n"
                         + "\n\t===============                     *         ***"
                         + "\n\t=             =                     *           *" 
                         + "\n\t=             ==============        *           *" 
                         + "\n\t=             D            =        *           *"
                         + "\n\t=             =            =        ******   *******" 
                         + "\n\t======DD=======            ="
                         + "\n\t=             =            =" 
                         + "\n\t=             =            ="
                         + "\n\t=             =            ="
                         + "\n\t=        =DD=========DD====="
                         + "\n\t=        =                 ="
                         + "\n\t==========                 ="
                         + "\n\t=        =                 ="
                         + "\n\t=        ===DD======================"
                         + "\n\t=        =             D           ="
                         + "\n\t====DD====             =           ="
                         + "\n\t=        =             =           ="
                         + "\n\t=        =             =           ="
                         + "\n\t=        =             ============="
                         + "\n\t=        =                 =       ="
                         + "\n\t=        D                 D     | ="
                         + "\n\t=        =                 =     V ="
                         + "\n\t====================================");
     }
     private void levelTwo() {
       this.console.println("\n"
                         + "\n\t=====================================       *         *****"
                         + "\n\t= -->         D                     =       *             *"
                         + "\n\t=             =                     =       *         *****"  
                         + "\n\t=             =                     =       *         *"
                         + "\n\t=             =                     =       ******    *****" 
                         + "\n\t======DD=======                     ="
                         + "\n\t=             =                     =" 
                         + "\n\t=             =                     ="
                         + "\n\t=             =                     ="
                         + "\n\t=        =DD=========DD========DD===="
                         + "\n\t=        =                 =        ="
                         + "\n\t==========                 =        ="
                         + "\n\t=        =                 =        ="
                         + "\n\t=        ===DD======================="
                         + "\n\t=        =             D            ="
                         + "\n\t====DD====             =            ="
                         + "\n\t=        =             =            ="
                         + "\n\t=        =             =            ="
                         + "\n\t=        =             =============="
                         + "\n\t=        =                 =        ="
                         + "\n\t=        D                 D        ="
                         + "\n\t=        =                 =        ="
                         + "\n\t====================================="); 
   }
}