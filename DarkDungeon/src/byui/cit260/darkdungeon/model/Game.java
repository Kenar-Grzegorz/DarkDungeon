/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import byui.cit260.darkdungeon.view.GameMenu;
import byui.cit260.darkdungeon.view.MoveView;
import byui.cit260.darkdungeon.control.*;
import java.io.Serializable;

/**
 *
 * @author gregg
 */
public class Game implements Serializable{
    public static GameMenu gameMenu = new GameMenu();
    public static MoveView move = new MoveView();
    private Player player;
    private Monster monster;
    private Inventory[] inventory;
    private CharacterSelection warrior;
    private Map map;
    private Inventory firescroll;
    private Inventory potion;
    private Inventory omniSlash;      
    private Inventory armageddon;
    private Inventory testItem;
    
    public Game() {
        
    }
    
    public static void getLoadSavedGame(String filePath) {
        
    }

    public void setPlayer(Player player) {
        
    }

    public Player getPlayer() {
        return player;
    }
    
    public static GameMenu getGameMenu() {
        return gameMenu;
    }

    public static void setGameMenu(GameMenu gameMenu) {
        Game.gameMenu = gameMenu;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public static MoveView getMove() {
        return move;
    }

    public static void setMove(MoveView move) {
        Game.move = move;
    }

    public CharacterSelection getWarrior() {
        return warrior;
    }

    public void setWarrior(CharacterSelection warrior) {
        this.warrior = warrior;
    }

    public Inventory[] getInventory() {
        return inventory;
    }

    public void setInventory(Inventory[] inventory) {
        this.inventory = inventory;
    }

    public Inventory getTestItem() {
        return testItem;
    }

    public void setTestItem(Inventory testItem) {
        this.testItem = testItem;
    }
    
    public Inventory getFirescroll() {
        return firescroll;
    }

    public void setFirescroll(Inventory firescroll) {
        this.firescroll = firescroll;
    }

    public Inventory getPotion() {
        return potion;
    }

    public void setPotion(Inventory potion) {
        this.potion = potion;
    }

    public Inventory getOmniSlash() {
        return omniSlash;
    }

    public void setOmniSlash(Inventory omniSlash) {
        this.omniSlash = omniSlash;
    }

    public Inventory getArmageddon() {
        return armageddon;
    }

    public void setArmageddon(Inventory armageddon) {
        this.armageddon = armageddon;
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    
    
}
