/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;
import byui.cit260.darkdungeon.exception.ItemControlException;
import byui.cit260.darkdungeon.model.*;

import jdk.internal.dynalink.DefaultBootstrapper;

/**
 *
 * @author Greg K, Bill M, Florian K
 */
// Added by Bill M
public class ItemControl {
    public static int useHeal (int health, int itemAmount, int healAmount) throws ItemControlException {
        if (health < 1 || health > 200) {throw new ItemControlException("\n Error - Health "+ health + " must be between 1 and 200");}
        if (itemAmount<=0) {return health;}
        else if (health > (200-healAmount) || health > 200) {return health = 200;}
        else { health = add(health, healAmount) ; 
        return health;
        }
    } 
    
    public static int add(int health, int healAmount) {
        return health += healAmount;
    
    }
    
   
    
}
