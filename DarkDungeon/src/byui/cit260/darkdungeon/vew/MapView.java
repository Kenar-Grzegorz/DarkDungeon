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
                 System.out.println("\n*** YOU CHOSE OPTION 3 ***");  
            case "B":
                 System.out.println("\n*** YOU CHOSE OPTION 4 ***");
            default:
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }
     private void levelOne() {
        System.out.println("\n"
                         + "\n==============="
                         + "\n=             =" 
                         + "\n=             ==============" 
                         + "\n=             D            ="
                         + "\n=             =            =" 
                         + "\n======DD=======            ="
                         + "\n=             =            =" 
                         + "\n=             =            ="
                         + "\n=             =            ="
                         + "\n=        =DD=========DD====="
                         + "\n=        =                 ="
                         + "\n==========                 ="
                         + "\n=        =                 ="
                         + "\n=        ===DD======================"
                         + "\n=        =             D           ="
                         + "\n====DD====             =           ="
                         + "\n=        =             =           ="
                         + "\n=        =             =           ="
                         + "\n=        =             ============="
                         + "\n=        =                 =       ="
                         + "\n=        D                 D       ="
                         + "\n=        =                 =       ="
                         + "\n====================================");
     }
     private void levelTwo() {
       System.out.println("\n"
                         + "\n==============="
                         + "\n=             =" 
                         + "\n=             ==============" 
                         + "\n=             D            ="
                         + "\n=             =            =" 
                         + "\n======DD=======            ="
                         + "\n=             =            =" 
                         + "\n=             =            ="
                         + "\n=             =            ="
                         + "\n=        =DD=========DD====="
                         + "\n=        =                 ="
                         + "\n==========                 ="
                         + "\n=        =                 ="
                         + "\n=        ===DD======================"
                         + "\n=        =             D           ="
                         + "\n====DD====             =           ="
                         + "\n=        =             =           ="
                         + "\n=        =             =           ="
                         + "\n=        =             ============="
                         + "\n=        =                 =       ="
                         + "\n=        D                 D       ="
                         + "\n=        =                 =       ="
                         + "\n===================================="); 
   }
}