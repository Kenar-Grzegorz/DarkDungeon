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
        startingScene("This is test."),
        atriumScene("This is test1."),
        storageScene("This is test2."),
        libraryScene("This is test3."),
        officeScene("This is test4."),
        chapelScene("This is test5."),
        studyScene("This is test6."),
        privateQuartersScene("This is test7."),
        bedRoomScene("This is test8."),
        sanctuaryScene("This is test"),
        ceremonyRoomScene("This is test"),
        cryptEntranceScene("This is test"),
        areaOneScene("This is test"),
        areaTwoScene("This is test"),
        areaThreeScene("This is test"),
        areaFourScene("This is test"),
        guardRoomScene("This is test"),
        mageLabScene("This is test"),
        caveOneScene("This is test"),
        crystalCaveScene("This is test"),
        mushroomCaveScene("This is test"),
        gaurdianScene("This is test"),
        summoningRoomScene("This is test"),
        morgueScene("This is test"),
        livingQuartersScene("This is test"),
        dragonCaveScene("This is test"),
        finishScene("This is test");
    
//        
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
