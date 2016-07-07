/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.exception.GameControlException;
import byui.cit260.darkdungeon.exception.MapControlException;
import byui.cit260.darkdungeon.enums.Actor;
import static byui.cit260.darkdungeon.enums.Actor.paladin;
import byui.cit260.darkdungeon.enums.Item;
import static byui.cit260.darkdungeon.enums.Item.potion;
import byui.cit260.darkdungeon.enums.SceneType;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.*;
import static byui.cit260.darkdungeon.model.Game.*;
import darkdungeongame.DarkDungeonGame;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

/**
 *
 * @author gregg
 */
public class GameControl {
    public static CharacterSelection warrior = new CharacterSelection();
    
    public static Game game;

    public static void createNewGame(Player player) throws MapControlException {
        game = new Game();
        DarkDungeonGame.setCurrentGame(game);
        
        
        game.setPlayer(player);
        
        Inventory[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        Map map = MapControl.createMap(); //create a new map
        game.setMap(map);
        
        //MapControl.moveActorsToStartingLocation(map);
    }
    
    public static void createJourney() {
        move.display();
    }
    
    public static void createNewBattle() throws BattleControlException {
        //monster = Monster.newMonsterInstance();
        game.setMonster(Monster.newRandomInstance());
        gameMenu.battleStart(DarkDungeonGame.getPlayer(), game.getWarrior(), game.getMonster());
    }

    static void initiateBattle(Monster monster) {
        game.setMonster(monster);
    }
   
    public static CharacterSelection createWarrior() {
        CharacterSelection[] fighter = new CharacterSelection[Actor.values().length];
        //CharacterSelection warrior = new CharacterSelection();
        warrior = new CharacterSelection("The Might Warrior -","- Brave attacker of all that is evil",100,10,50,10,30,50,50,true);
        game.setWarrior(warrior);
        fighter[CharacterSelection.Actor.warrior.ordinal()] = warrior;
        return warrior;
    }
    public static CharacterSelection createPaladin() {
        CharacterSelection[] fighter = new CharacterSelection[Actor.values().length];
        CharacterSelection paladin = new CharacterSelection();
        warrior = new CharacterSelection("The Might Paladin Defender -","- Brave defender of the people for all that is good.", 100,10,40,10,30,40,60,true);
        game.setWarrior(warrior);
        fighter[CharacterSelection.Actor.paladin.ordinal()] = paladin;
        return warrior;
    }

    public static void getLoadSavedGame(String filepath) throws GameControlException {
        Game game = null;
         try(FileInputStream fips = new FileInputStream(filepath)){
             ObjectInputStream output = new ObjectInputStream(fips);
             
             game = (Game) output.readObject();
         }catch (FileNotFoundException fnfe){
             throw new GameControlException(fnfe.getMessage());
         }catch(Exception e){
             throw new GameControlException(e.getMessage());
         }
         DarkDungeonGame.setCurrentGame(game);
    }
    
    public static void saveGame(Game game, String filepath) throws GameControlException{
        
        try (FileOutputStream fops = new FileOutputStream(filepath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        } catch (IOException e){
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void printLocation(Scene SceneType, String filepath) throws GameControlException{
        
        try (FileOutputStream fops = new FileOutputStream(filepath)){
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(SceneType);
        } catch (IOException e){
            throw new GameControlException(e.getMessage());
        }
    }
    
    public int numberOfLocations(){
        //SceneType[] scenea = SceneType.values();
        int total = 0;
        for(SceneType scenes: SceneType.values()){ // runs through all the scenes and counts them to get room count.
            
            total++;} // adds one on each pass
        return total;  // returns total
    }
    
    public int getNumberOfItems() {int list = 0;
        int number1=0;
        
        for(Inventory number : DarkDungeonGame.getCurrentGame().getInventory()){ //runs through and counts the amount of items in inventory
            number1++; //adds one on each pass
        }
//        for (int i = 0; i < ( invLength - 1); i++){
//            item[1].getItemName();
//            for (int i2 = 0; i2 < (invLength - i - 1); i2++){
//                if (inventoryList[i2].getItemDescription().compareToIgnoreCase(inventoryList[i2+1].getItemDescription())>0){
//                    tempInventoryItem = inventoryList[i2];
//                    inventoryList[i2] = inventoryList[i2+1];
//                    inventoryList[i2+1] = tempInventoryItem;
//                }
//            }
//        }
        return number1; // returns the amount
    }
    
    public int getNumberOfEmptyItems() {
        int number1=0;
        //Inventory[] item = DarkDungeonGame.getCurrentGame().getInventory();
       
        for(Inventory number : DarkDungeonGame.getCurrentGame().getInventory()){ // runs through inventory and puts into number
            if(number.getItemAmount()==0){ // checks number for any item with a 0 amount
                number1++; // adds a 1 to any item with a zero
            }
        }
        return number1; //returns number
    }

    public int placesVisited(Map map) {
        int row=0; 
        int total = 0;
        //Location[][] loc = map.getLocations();
        for(Location[] d : map.getLocations()){ // runs through inventory row
            int column=0; //resets row
            for(Location mapb : d){ // runs through column
                if (map.locations[row][column].getVisited() == true) { //if location row column was visited run next line
                    total++; // add 1 to total if true
                    
                }
                column++; //add 1 to column on each pass
            }
            row++; //add 1 to row only after lumn was finished
        }
        //for (int row = 0; row < map.getNoOfRows(); row++) {
//            for (int column = 0; column < map.getNoOfColumns(); column++) {
//                
//                if (map.locations[row][column].getVisited() == true) {
//                    total++;
//                }
//            }
//        }
        return total; // return amount
    }
    
    private static class Constants {
        public final static int NUMBER_OF_INVENTORY_ITEMS=5;
    }
    
    public static Inventory[] createInventoryList() {
        Inventory[] inventory = new Inventory[Constants.NUMBER_OF_INVENTORY_ITEMS];
        
        Inventory fireScroll = new Inventory("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);game.setFirescroll(fireScroll);
        inventory[Item.firescroll.ordinal()] = fireScroll;
        Inventory potion = new Inventory("Potion", "A devine glow covers your body", 0,25,3);game.setPotion(potion);
        inventory[Item.potion.ordinal()] = potion;
        Inventory omniSlash = new Inventory("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);game.setOmniSlash(omniSlash);
        inventory [Item.omniSlash.ordinal()] = omniSlash;
        Inventory armageddon = new Inventory("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);game.setArmageddon(armageddon);
        inventory [Item.armageddon.ordinal()] = armageddon;
        Inventory testItem = new Inventory("TestItem", "Just your good old fashioned test item", 45, 0, 0);game.setTestItem(testItem);
        inventory [Item.testItem.ordinal()] = testItem;
        return inventory;
    }
    
    public static Inventory[] getSortedInventoryList() {
        
        Inventory[] item = DarkDungeonGame.getCurrentGame().getInventory();
        
        Inventory[] inventoryList = item.clone();
        int invLength = inventoryList.length;
        
        Inventory tempInventoryItem;
        for (int i = 0; i < ( invLength - 1); i++){
            for (int i2 = 0; i2 < (invLength - i - 1); i2++){
                if (inventoryList[i2].getItemDescription().compareToIgnoreCase(inventoryList[i2+1].getItemDescription())>0){
                    tempInventoryItem = inventoryList[i2];
                    inventoryList[i2] = inventoryList[i2+1];
                    inventoryList[i2+1] = tempInventoryItem;
                }
            }
        }
        
        return inventoryList;
    }
    
}
