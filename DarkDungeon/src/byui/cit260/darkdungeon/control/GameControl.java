/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.Exceptions.*;
import byui.cit260.darkdungeon.vew.*;
import byui.cit260.darkdungeon.model.*;
import static byui.cit260.darkdungeon.model.Game.*;
import byui.cit260.darkdungeon.vew.CharacterSelectView;
import darkdungeongame.DarkDungeonGame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author gregg
 */
public class GameControl {
    public static Game game;
    
    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        
        player.setName(name);
        
        DarkDungeonGame.setPlayer(player); //save the player
        return player;
    }

    public static void createNewGame(Player player) {
        game = new Game();
        DarkDungeonGame.setCurrentGame(game);
        
        game.setPlayer(player);
    }
    
    public static void createJourney() {
        move.display();
    }
    
    public static void createNewBattle() {
        //monster = Monster.newMonsterInstance();
        monster = Monster.newRandomInstance();
        gameMenu.battleStart(player, getWarrior(), monster);
    }
    public void useFireScroll() { 
        BattleControl.abilityDefend(warrior, fireScroll);
    }
    public void usePotion() {
        BattleControl.heal(potion, warrior);
    }
    public void useOmniSlash() {
         BattleControl.abilityDefend(warrior, omniSlash);
    }
     public void useArmageddon() {
         BattleControl.abilityDefend(warrior, armageddon);
    }
    public static CharacterSelection createWarrior() {
        fireScroll = new Item("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);
        potion = new Item("Potion", "A devine glow covers your body", 0,25,3);
        warrior = new CharacterSelection("The Might Warrior -","- Brave attacker of all that is evil",100,10,50,10,30,50,50,true);
        omniSlash = new Item("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
        armageddon = new Item("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);
        setWarrior(warrior);
        return warrior;
    }
    public static CharacterSelection createPaladin() {
        fireScroll = new Item("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);
        potion = new Item("Potion", "A devine glow covers your body", 0,25,3);
        warrior = new CharacterSelection("The Might Paladin Defender -","- Brave defender of the people for all that is good.", 100,10,40,10,30,40,60,true);
        omniSlash = new Item("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
        armageddon = new Item("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);
        setWarrior(warrior);
        return warrior;
    }
    
    public static void setWarrior(CharacterSelection warrior) {
        game.warrior = warrior;
    }

    public static CharacterSelection getWarrior() {
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
}
