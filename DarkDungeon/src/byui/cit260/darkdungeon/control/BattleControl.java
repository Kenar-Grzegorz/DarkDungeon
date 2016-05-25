/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import java.util.Random;


/**
 *
 * @author gregg
 */
public class BattleControl {
    public static int attack(int min, int max, int defense, int health) {
        if (min > max) {return -1;}
        int power = random(min, max);
        
        if (power < 0 || power > 50) {return -1;}
        if (power > (health+defense)) {
            return 0;
        }
        else if (power<defense) {
            return health;
        }
        else {
        health = (defense + health) - power;   

        return health;
        }
    }

    public BattleControl() {
    }
    
    public static int random(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        
        return randomNum;
    }
    public static int useHeal (int health, int itemAmount, int healAmount) {
        if (health < 1 || health > 200) {return -1;}
        if (itemAmount<=0) {return health;}
        else if (health > (200-healAmount) || health > 200) {return health = 200;}
        else { health += healAmount; 
        return health;
        }
        
        
    }
}
