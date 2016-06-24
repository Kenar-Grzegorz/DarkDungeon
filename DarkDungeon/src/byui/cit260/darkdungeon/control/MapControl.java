/**
 *
 * @author Greg K, Bill M, Florian K
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.model.Location;
import byui.cit260.darkdungeon.model.Map;
import byui.cit260.darkdungeon.model.Scene;
import byui.cit260.darkdungeon.enums.SceneType;
import static java.lang.Math.random;

/**
 *
 * added by Florian K
 */
public class MapControl {

    public static int random(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static Map createMap() {
        // create the map
        Map map = new Map(20,20);
        // create scenes
        Scene[] scenes = createScenes();
        //assign a scene to a location
        assignScenesToLocations(map, scenes);
        return map;
    }

    static void moveActorsToStartingLocation(Map map) {
        System.out.println("MapControl Move actor");
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];
        
        Scene startingScene = new Scene();
        startingScene.setDescription("\n This is the starting scene description");
        startingScene.setMapSymbol("ST");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= startingScene;
        
        Scene hobbitonScene = new Scene();
        startingScene.setDescription("\n Bilbo is the local legend, you should"
                + "\n go talk with him and see if he"
                + "\n has any advice for you.");
        startingScene.setMapSymbol("HB");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= hobbitonScene;
        
        Scene crossroadsScene = new Scene();
        startingScene.setDescription("\n You come to a crossroads, which"
                + "\n way should you take?");
        startingScene.setMapSymbol("CR");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= crossroadsScene;
        
        Scene beornScene = new Scene();
        startingScene.setDescription("\n you have been traveling for awhile"
                + "\n if only there were somplace to rest...");
        startingScene.setMapSymbol("BN");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= beornScene;
        
        Scene rivendellScene = new Scene();
        startingScene.setDescription("\n Time to stock up on supplies.");
        startingScene.setMapSymbol("RD");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= rivendellScene;
        
        Scene goblinsScene = new Scene();
        startingScene.setDescription("\n They say there are goblins"
                + "\n in these mountains!");
        startingScene.setMapSymbol("GB");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= goblinsScene;
        
        Scene miningScene = new Scene();
        startingScene.setDescription("\n short on cash, maybe I could"
                + "dig up some extra coin....");
        startingScene.setMapSymbol("MN");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= miningScene;
        
        Scene dragonScene = new Scene();
        startingScene.setDescription("\n This is it, the final battle");
        startingScene.setMapSymbol("DR");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.start.ordinal()]= dragonScene;
        
        Scene finishScene = new Scene();
        finishScene.setDescription ("\n You have defeted the Dragon! Glory and honor are yours");
        finishScene.setMapSymbol("FN");
        finishScene.setBlocked(false);
        scenes[Scene.SceneType.finish.ordinal()] = finishScene;
        
        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
         Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.entrance.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.crossToBare.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.BeesGetTheseBees.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.BodyInTheRiver.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.TheyDidntHaveToEatHim.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.Food.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.dragon.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.finish.ordinal()]);
    }
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
             int validLocation = (int) Math.random();
             if (validLocation>= 1) {return Boolean.TRUE;}
                else {return Boolean.FALSE;}
            
           
    }
     public boolean openLock(){
         int openLock = (int) Math.random();
             if (openLock>= 1) {return Boolean.TRUE;}
                else {return Boolean.FALSE;}
         
     }
}