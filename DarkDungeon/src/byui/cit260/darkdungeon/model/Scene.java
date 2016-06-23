/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bill
 */
public class Scene implements Serializable {
    
    //class instance variables
    private String description;
    private Boolean trapboolean;
    private Boolean chestboolean;
    private Boolean randomMonsterEncounter;
    private double visited;
    private double amountRemaining;
    private String name;
    private String type;
    private boolean blocked;
    private double travelTime;
    private String mapSymbol;
    
    public Scene() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String drescription) {
        this.description = drescription;
    }

    public Boolean getTrapboolan() {
        return trapboolean;
    }

    public void setTrapboolean(Boolean trapboolean) {
        this.trapboolean = trapboolean;
    }

    public Boolean getChestboolean() {
        return chestboolean;
    }

    public void setChestboolean(Boolean chestboolean) {
        this.chestboolean = chestboolean;
    }

    public Boolean getRandomMonsterEncounter() {
        return randomMonsterEncounter;
    }

    public void setRandomMonsterEncounter(Boolean randomMonsterEncounter) {
        this.randomMonsterEncounter = randomMonsterEncounter;
    }

    public double getVisited() {
        return visited;
    }

    public void setVisited(double visited) {
        this.visited = visited;
    }

    public double getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(double amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public double getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(double travelTime) {
        this.travelTime = travelTime;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }
    
    public enum SceneType{
        start("Here is where the start of your great journy Begins."),
        hobbiton("Meet with Bilbo and go over what you will need on your journey."),
        crossroads("I can't seem to remember which direction I needed to go..."),
        Beorn("A massive shapeshiffter who could be friend or foe."),
        rivendell("Time to stock up and upgrade your weapons."),
        goblins("There are many goblins in the mountains, tread carefully."),
        mining("Short on supplies? see if you can dig up something."),
        dragon("this is the battle you've been training for!"), 
        finish("Return Home to tell everyone of your mighty deeds.");
        
        private final String description;
        
        SceneType(String description){
            this.description = description;
        }
        
        public String getDescription(){
            return description;
        }
        
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Objects.hashCode(this.trapboolean);
        hash = 19 * hash + Objects.hashCode(this.chestboolean);
        hash = 19 * hash + Objects.hashCode(this.randomMonsterEncounter);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Scene other = (Scene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.trapboolean, other.trapboolean)) {
            return false;
        }
        if (!Objects.equals(this.chestboolean, other.chestboolean)) {
            return false;
        }
        if (!Objects.equals(this.randomMonsterEncounter, other.randomMonsterEncounter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", trapboolean=" + trapboolean + ", chestboolean=" + chestboolean + ", randomMonsterEncounter=" + randomMonsterEncounter + '}';
    }
    
}
