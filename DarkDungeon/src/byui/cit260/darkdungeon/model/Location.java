/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import byui.cit260.darkdungeon.enums.Actor;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Greg
 */
public class Location implements Serializable{
    
    private int row;
    private int column;
    private double coordinates;
    private boolean visited;
    private Scene scene;
    private Point locations[][];

    public Point[][] getLocations() {
        return locations;
    }

    public void setLocations(Point[][] locations) {
        this.locations = locations;
    }
    private ArrayList<Actor> actors;
    
    public Scene getScene() {
        
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }
    
    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" + "rowCoordinate=" + row + ", columnCoordinate=" + column +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.coordinates) ^ (Double.doubleToLongBits(this.coordinates) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
    
    public double getCoordinates(){
        return coordinates;
    }
    public void setCoordinates(double coordinates){
        this.coordinates=coordinates;
    }

    
}