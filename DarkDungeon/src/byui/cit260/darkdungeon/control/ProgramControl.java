/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.control.GameControl;
import byui.cit260.darkdungeon.model.Monster;
import byui.cit260.darkdungeon.model.Player;
import darkdungeongame.DarkDungeonGame;

/**
 *
 * @author Greg
 */
public class ProgramControl {
       
    public static Player createPlayer(String playerName) {
        
        if (playerName == null) return null;
        
        Player player = new Player();
        player.setName(playerName);
        
        DarkDungeonGame.setPlayer(player);
        
        return player;
    }
    
    public static Monster createEnemy(String enemyName, String enemyType) {
   
        if (enemyName == null) return null;
        
        Monster monster = new Monster();
        GameControl.initiateBattle(monster);
        
        return monster;
    }
}
