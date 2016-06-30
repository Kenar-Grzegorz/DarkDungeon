/**
 *
 * @author Greg K, Bill M, Florian K
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.enums.Actor;
import byui.cit260.darkdungeon.exceptions.MapControlException;
import byui.cit260.darkdungeon.model.Location;
import byui.cit260.darkdungeon.model.Map;
import byui.cit260.darkdungeon.model.Scene;
import byui.cit260.darkdungeon.enums.SceneType;
import byui.cit260.darkdungeon.model.CharacterSelection;
import darkdungeongame.DarkDungeonGame;
import java.awt.Point;
import static java.lang.Math.random;

/**
 *
 * added by Team
 */
public class MapControl {

    public static int random(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Map createMap() throws MapControlException {
        // create the map
        Map map = new Map(6, 5);
        // create scenes
        Scene[] scenes = createScenes();
        //assign a scene to a location
        assignScenesToLocations(map, scenes);
        movePlayerToStartingLocation(map);
        return map;
    }

    public static void movePlayerToStartingLocation(Map map) {
        movePlayer(map, 2, 2);
        movePlayer(map, 0, 0);
    }

    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);

        map.setCurrentRow(row);
        map.setCurrentColumn(column);
        
    }
    
    public static void moveActorsToStartingLocation(Map map) throws MapControlException {
        Actor[] actors= Actor.values();
        for (Actor actor : actors) { 
            Point coordinates = actor.getCoordinates();
            try {
                MapControl.moveActorToLocation(actor, coordinates);
            } catch (MapControlException me) {
                System.out.println(me.getMessage());
            }
        }
    
    }
    
    public static void moveActorToLocation(CharacterSelection actor, Point coordinates) throws MapControlException {
        Map map = DarkDungeonGame.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if (newRow < 0 || newRow >= map.getNoOfRows() || newColumn < 0 || newColumn >= map.getNoOfColumns()) {
        throw new MapControlException("Can not move actor to location " + coordinates.x + ", " + coordinates.y + " because that location is outside the bounds of the map");
        }
        
    }
    
    public static void moveActorToLocation(Actor actor, Point coordinates) throws MapControlException{
        Map map = DarkDungeonGame.getCurrentGame().getMap();
        int newRow = coordinates.x-1;
        int newColumn = coordinates.y-1;
        
        if (newRow<0 || newRow >= map.getNoOfRows() || newColumn < 0 || newColumn > map.getNoOfColumns()){
            throw new MapControlException("Can not move actor to location" + coordinates.x + ", " + coordinates.y + "because that location is outside " + "the bounds of the map.");
        }
    }
    
    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];

        Scene startingScene = new Scene();
        startingScene.setDescription(
                "\n You have traveled for several days to get to the ruins of the Castle of Caer Darkin."
                + "\n You have traveled long and hard and are very tired but you decide to explore the ruins."
                + "\n As you begin to explore the ruins you spot movement in the distance and see someone moving thru the ruins."
                + "\n the person seems to be bent over and dressed in rags. As you watch he suddenly disappears out of sight."
                + "\n Nearing the last place you saw the person you see a set of stairs descending down into the dark recesses of the ruins.");
        startingScene.setMapSymbol("ST");
        startingScene.setBlocked(false);
        scenes[Scene.SceneType.startingScene.ordinal()] = startingScene;

        Scene atriumScene = new Scene();
        atriumScene.setDescription(
                "\n the dank slippery stone steps from the surface has led you down to this small stone chamber"
                + "\n Entering from the south you see the walls of the chamber were once carved with bas reliefs but much of it has worn away and the images are indistinct and crumbling.");
        atriumScene.setMapSymbol("AT");
        atriumScene.setBlocked(false);
        scenes[Scene.SceneType.atriumScene.ordinal()] = atriumScene;

        Scene storageScene = new Scene();
        storageScene.setDescription(
                "\n The door to this room opens up into a small storage room."
                + "\n The walls are covered in shelves and contain various  pieces of crockery and urns");
        storageScene.setMapSymbol("CL");
        storageScene.setBlocked(false);
        scenes[Scene.SceneType.storageScene.ordinal()] = storageScene;

        Scene libraryScene = new Scene();
        libraryScene.setDescription(
                "\n This room was once a private Library. Most of the Shelves now stand empty or covered"
                + "\n in moldering books and scrolls. Several tables and chairs occupy the center of the room ");
        libraryScene.setMapSymbol("LB");
        libraryScene.setBlocked(false);
        scenes[Scene.SceneType.libraryScene.ordinal()] = libraryScene;

        Scene officeScene = new Scene();
        officeScene.setDescription(
                "\n This room seems to have been a private office or study. A large oaken desk sits against"
                + "\n the far wall. A large plush chair sits behind the desk. The walls are covered in decaying tapestries");
        officeScene.setMapSymbol("OF");
        officeScene.setBlocked(false);
        scenes[Scene.SceneType.officeScene.ordinal()] = officeScene;

        Scene chapelScene = new Scene();
        chapelScene.setDescription(
                "\n This room is a small chapel with alters and statues to Praydon (King of the Gods), Geae (the Divine Mother),"
                + "\n and Akron (Lord of Darkness). The skeletal remains of two humans dressed in tatered robes lie on the floor");
        chapelScene.setMapSymbol("CH");
        chapelScene.setBlocked(false);
        scenes[Scene.SceneType.chapelScene.ordinal()] = chapelScene;

        Scene studyScene = new Scene();
        studyScene.setDescription(
                "\n This is a small sitting room with several chairs, tables, and small fireplace.");
        studyScene.setMapSymbol("SD");
        studyScene.setBlocked(false);
        scenes[Scene.SceneType.studyScene.ordinal()] = studyScene;

        Scene privateQuartersScene = new Scene();
        privateQuartersScene.setDescription(
                "\n Thia room appears to be the quarters of one of high preist. The room is decorated with religous symbols and religious iconagraphy");
        privateQuartersScene.setMapSymbol("CL");
        privateQuartersScene.setBlocked(false);
        scenes[Scene.SceneType.privateQuartersScene.ordinal()] = privateQuartersScene;

        Scene bedRoomScene = new Scene();
        bedRoomScene.setDescription(
                "\n This is the private bedroom of the high priest. A large Oak bed covered in a Thick woolen conapy "
                + "\n The walls are covered in shelves and a large dresser can also be found in this room");
        bedRoomScene.setMapSymbol("BD");
        bedRoomScene.setBlocked(false);
        scenes[Scene.SceneType.bedRoomScene.ordinal()] = bedRoomScene;

        Scene sanctuaryScene = new Scene();
        sanctuaryScene.setDescription(
                "\n The Inner Sanctuary is extremely large and can hold over 500 people. The Alter is made of White"
                + "\n Marble and engrained with gold leaf");
        sanctuaryScene.setMapSymbol("SN");
        sanctuaryScene.setBlocked(false);
        scenes[Scene.SceneType.sanctuaryScene.ordinal()] = sanctuaryScene;

        Scene ceremonyRoomScene = new Scene();
        ceremonyRoomScene.setDescription(
                "\n In this small room was housed the holy of holies and here is where the high priest performed the most sacred rituals"
                + "\n The ceremony room has been discrated and the sacred relics lay shattered on the floor");
        ceremonyRoomScene.setMapSymbol("CM");
        ceremonyRoomScene.setBlocked(false);
        scenes[Scene.SceneType.ceremonyRoomScene.ordinal()] = ceremonyRoomScene;

        Scene cryptEntranceScene = new Scene();
        cryptEntranceScene.setDescription(
                "\n The stairs descend to this level and end at a large Iron gate. The Seal of Thantos locks the gate"
                + "\n beyond the gates lays a large marble room where the final ceremony for the deceased is performed before the body is laid to rest");
        cryptEntranceScene.setMapSymbol("CE");
        cryptEntranceScene.setBlocked(false);
        scenes[Scene.SceneType.cryptEntranceScene.ordinal()] = cryptEntranceScene;

        Scene areaOneScene = new Scene();
        areaOneScene.setDescription(
                "\n In this hall lies the noble deceased of lesser ranks. Their crypts are incessed into the walls and covered by an engraved brass plate.");
        areaOneScene.setMapSymbol("AO");
        areaOneScene.setBlocked(false);
        scenes[Scene.SceneType.areaOneScene.ordinal()] = areaOneScene;

        Scene areaTwoScene = new Scene();
        areaTwoScene.setDescription(
                "\n In this hall lies the lesser Royality. The hall is carved from golden crystal and a magical light causes the whole room to sparkle."
                + "\n The crypts in this room are covered by golden plates");
        areaTwoScene.setMapSymbol("AT");
        areaTwoScene.setBlocked(false);
        scenes[Scene.SceneType.areaTwoScene.ordinal()] = areaTwoScene;

        Scene areaThreeScene = new Scene();
        areaThreeScene.setDescription(
                "\n In this hall lies the members of the Royal family who were related closely to the king and who could have inherited The Throne."
                + "\n The Royal Crypts are free standing in this hall and bear the likeness of the deceased. The Crypts are carved from either Marble or limestone");
        areaThreeScene.setMapSymbol("CT");
        areaThreeScene.setBlocked(false);
        scenes[Scene.SceneType.areaThreeScene.ordinal()] = areaThreeScene;

        Scene areaFourScene = new Scene();
        areaFourScene.setDescription(
                "\n The Hall of Kings. Here lie the kings of the realm. The Royal crypts are carved from crystal or Marble and lined with Gold and Silver");
        areaFourScene.setMapSymbol("AF");
        areaFourScene.setBlocked(false);
        scenes[Scene.SceneType.areaFourScene.ordinal()] = areaFourScene;

        Scene guardRoomScene = new Scene();
        guardRoomScene.setDescription(
                "\n This room was once housed the Royal Gaurds who stood watch on the Crypts");
        guardRoomScene.setMapSymbol("GR");
        guardRoomScene.setBlocked(false);
        scenes[Scene.SceneType.guardRoomScene.ordinal()] = guardRoomScene;

        Scene mageLabScene = new Scene();
        mageLabScene.setDescription(
                "\n Hidden deep beneath the crypts is an ancient magical lab. The room is equipped with strange"
                + "\n pieces of glassware and numerous magical implements");
        mageLabScene.setMapSymbol("ML");
        mageLabScene.setBlocked(false);
        scenes[Scene.SceneType.mageLabScene.ordinal()] = mageLabScene;

        Scene caveOneScene = new Scene();
        caveOneScene.setDescription(
                "\n This large cave has numerous stalagtites and staglamites and numerous pools of colored water ");
        caveOneScene.setMapSymbol("CO");
        caveOneScene.setBlocked(false);
        scenes[Scene.SceneType.caveOneScene.ordinal()] = caveOneScene;

        Scene crystalCaveScene = new Scene();
        crystalCaveScene.setDescription(
                "\n This Cave is carved out of crystal strata. The room glows with all the colors of the spectrum as light is reflected from its surface.");
        crystalCaveScene.setMapSymbol("CC");
        crystalCaveScene.setBlocked(false);
        scenes[Scene.SceneType.crystalCaveScene.ordinal()] = crystalCaveScene;

        Scene mushroomCaveScene = new Scene();
        mushroomCaveScene.setDescription(
                "\n This cavern is engulfed in a forest of Gaint Mushrooms");
        mushroomCaveScene.setMapSymbol("MC");
        mushroomCaveScene.setBlocked(false);
        scenes[Scene.SceneType.mushroomCaveScene.ordinal()] = mushroomCaveScene;

        Scene gaurdianScene = new Scene();
        gaurdianScene.setDescription(
                "\n One must past the gaurdian of this room before reaching the Necromancer");
        gaurdianScene.setMapSymbol("GU");
        gaurdianScene.setBlocked(false);
        scenes[Scene.SceneType.gaurdianScene.ordinal()] = gaurdianScene;

        Scene summoningRoomScene = new Scene();
        summoningRoomScene.setDescription(
                "\n The floor, walls, and ceiling of this room have been inscribed with magical symbols and circles.");
        summoningRoomScene.setMapSymbol("SR");
        summoningRoomScene.setBlocked(false);
        scenes[Scene.SceneType.summoningRoomScene.ordinal()] = summoningRoomScene;

        Scene morgueScene = new Scene();
        morgueScene.setDescription(
                "\n This room is were the Necromancer stores bodies that he is expermenting with and raising from the dead");
        morgueScene.setMapSymbol("MG");
        morgueScene.setBlocked(false);
        scenes[Scene.SceneType.morgueScene.ordinal()] = morgueScene;

        Scene livingQuartersScene = new Scene();
        livingQuartersScene.setDescription(
                "\n The room is the living quarters of the Necromancer");
        livingQuartersScene.setMapSymbol("NR");
        livingQuartersScene.setBlocked(false);
        scenes[Scene.SceneType.livingQuartersScene.ordinal()] = livingQuartersScene;

        Scene dragonCaveScene = new Scene();
        dragonCaveScene.setDescription(
                "\n This Cavern is occupied by a Large DracoLich");
        dragonCaveScene.setMapSymbol("DC");
        dragonCaveScene.setBlocked(false);
        scenes[Scene.SceneType.dragonCaveScene.ordinal()] = dragonCaveScene;

        Scene finishScene = new Scene();
        finishScene.setDescription("\n You have defeted the Dragon! Unfortunately the Necromancer slipped away in the midst of your fight with the Dragon.");
        finishScene.setMapSymbol("FN");
        finishScene.setBlocked(false);
        scenes[Scene.SceneType.finishScene.ordinal()] = finishScene;

        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations[0][0].setScene(scenes[SceneType.startingScene.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.atriumScene.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.storageScene.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.libraryScene.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.officeScene.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.chapelScene.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.studyScene.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.privateQuartersScene.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.bedRoomScene.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.sanctuaryScene.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.ceremonyRoomScene.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.cryptEntranceScene.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.areaOneScene.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.areaTwoScene.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.areaThreeScene.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.areaFourScene.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.guardRoomScene.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.mageLabScene.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.caveOneScene.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.crystalCaveScene.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.mushroomCaveScene.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.gaurdianScene.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.summoningRoomScene.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.morgueScene.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.livingQuartersScene.ordinal()]);
        locations[5][0].setScene(scenes[SceneType.dragonCaveScene.ordinal()]);
        locations[5][1].setScene(scenes[SceneType.finishScene.ordinal()]);

    }

    public int Move(int character, int location, int monster, int health) {
        if (character < 1) {
            return -1;
        }
        if (location < 1) {
            return -1;
        }
        if (monster < 1) {
            return -1;
        }
        if (health < 1) {
            return -1;
        }

        int Move = character + location + monster + health;
        return Move;
    }
    
    public boolean validLocation(int character, int location) {

        if (character < 1) {
            return Boolean.FALSE;
        }

        if (location < 1) {
            return Boolean.FALSE;
        }
        int validLocation = (int) Math.random();
        if (validLocation >= 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    public boolean openLock() {
        int openLock = (int) Math.random();
        if (openLock >= 1) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

}
