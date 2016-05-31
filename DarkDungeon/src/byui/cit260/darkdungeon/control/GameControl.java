/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Player;
import darkdungeongame.DarkDungeonGame;

/**
 *
 * @author gregg
 */
public class GameControl {

    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        
        DarkDungeonGame.setPlayer(player); //save the player
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("New Game called");
    }

    public static CharacterSelection createWarrior() {
        CharacterSelection warrior = new CharacterSelection("The Might Warrior -","- Brave attacker of all that is evil",100,10,50,10,30,50,50);
        return warrior;
    }
    public static CharacterSelection createPaladin() {
        CharacterSelection warrior = new CharacterSelection("The Might Paladin Defender -","- Brave defender of the people for all that is good.", 100,10,40,10,30,40,60);
        return warrior;
    
    }
}
