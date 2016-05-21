/**
 *
 * @author Greg K, Bill M, Florian K
 */
package byui.cit260.darkdungeon.control;

import static java.lang.Math.random;

/**
 *
 * added by Florian
 */
public class MapControl {
    public int Move(character,location,monster,health){
            if (character<1)
                    {return -1;}
            if (location<1)
                    {return -1;}
            if (monster<1)
                   {return -1;}
            if (health<1)
                    {return -1;}
            
            int Move = character + location + monster + health;
    }
    public boolean validLocation(character, location){
        int character = 1;
            if (character<1)
                    {return Boolean.FALSE;}
        int location = 1;
            if (location<1)
                    {return Boolean.FALSE;}
             int validLocation = (int) random();
             if (validLocation>= 1) {return Boolean.TRUE;}
                else {return Boolean.TRUE;}
            
           
    }
     public boolean openLock(){
         int openLock = (int) Math.random();
             if (openLock<= 1) {return Boolean.FALSE;}
                else {return Boolean.TRUE;}
         
     }
}