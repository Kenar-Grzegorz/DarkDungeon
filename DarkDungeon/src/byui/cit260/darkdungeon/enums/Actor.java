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
    
    Person1("Local legend and your favorite story teller. If only you could have your own adventure"),
    Person2("A large man with mystical eyes shining green, with a staff of the Gods.");
    
    private final String description;
    private final Point coordinates;
    private final String type = "test";
    private final double hitPoints = 10;
    private final double maxHitPoints = 10;

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

    public double getMaxHitPoints() {
        return maxHitPoints;
    }

    public String getType() {
        return type;
    }    

    public double getHitPoints() {
        return hitPoints;
    }

    public String getLocation() {
        System.out.println("test");
        return "test";
    }
}
