/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.model;

import byui.cit260.darkdungeon.vew.GameMenu;
import byui.cit260.darkdungeon.vew.MoveView;
import byui.cit260.darkdungeon.control.*;
import java.io.Serializable;

/**
 *
 * @author gregg
 */
public class Game implements Serializable{
    public static GameMenu gameMenu = new GameMenu();
        public static Monster monster = new Monster();
        public static MoveView move = new MoveView();
        public static Player player = new Player();
        public static CharacterSelection warrior = new CharacterSelection();
        public static Item potion = new Item();
        public static Item fireScroll = new Item();
        public static Item omniSlash = new Item();
        public static Item armageddon = new Item();
        public static BattleControl battle = new BattleControl();
    private Item[] item;
    private CharacterSelection character;
    private Scene scene;
    private Map map;

    
    public Game() {
        
    }
    
    public static void getLoadSavedGame(String filePath) {
        
    }

    public void setPlayer(Player player) {
        
    }

    
    
}
