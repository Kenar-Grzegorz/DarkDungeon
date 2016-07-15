/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.enums;

import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Greg
 */
public enum Actor implements Serializable {
    
    warrior("Test1"),
    paladin("Test2"),
    mage("Test3"),
    Samurai("Test4"),
    Thief("Test5");
    
    private final Point coordinates;
    private final String description;
    
    Actor(String description){
        this.description = description;
        coordinates = new Point (1,1);
    }
     public String getDescription(){
        return description;
    }

    public Point getCoordinates(){
        return coordinates;
    }
}
