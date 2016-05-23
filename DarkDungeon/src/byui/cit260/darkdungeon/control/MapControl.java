/**
 *
 * @author Greg K, Bill M, Florian K
 */
package byui.cit260.darkdungeon.control;

import static java.lang.Math.random;

/**
 *
 * added by Florian K
 */
public class MapControl {
    public int Move(int character,int location,int monster,int health){
            if (character<1)
                    {return -1;}
            if (location<1)
                    {return -1;}
            if (monster<1)
                   {return -1;}
            if (health<1)
                    {return -1;}
            
            int Move = character + location + monster + health;
            return Move;
    }
    
    public boolean validLocation(int character,int  location){
        
            if (character<1)
                    {return Boolean.FALSE;}
        
            if (location<1)
                    {return Boolean.FALSE;}
             int validLocation = (int) random();
             if (validLocation>= 1) {return Boolean.TRUE;}
                else {return Boolean.FALSE;}
            
           
    }
     public boolean openLock(){
         int openLock = (int) Math.random();
             if (openLock>= 1) {return Boolean.TRUE;}
                else {return Boolean.FALSE;}
         
     }
}