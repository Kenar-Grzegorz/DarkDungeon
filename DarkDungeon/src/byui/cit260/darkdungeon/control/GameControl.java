/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.vew.*;
import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.vew.CharacterSelectView;
import darkdungeongame.DarkDungeonGame;

/**
 *
 * @author gregg
 */
public class GameControl {
        public static GameMenuView game = new GameMenuView();
        public static Monster monster = new Monster();
        public static MoveView move = new MoveView();
        public static Player player = new Player();
        public static CharacterSelection warrior = new CharacterSelection();
        public static Item potion = new Item();
        public static Item fireScroll = new Item();
        public static Item omniSlash = new Item();
        public static Item armageddon = new Item();
        
    
    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        
        player.setName(name);
        
        DarkDungeonGame.setPlayer(player); //save the player
        return player;
    }

    public static void createNewGame(Player player,CharacterSelection warrior) {
        move.display();
        
        
        //return map;
    }
    public static void createNewBattle() {
        monster = Monster.newMonsterInstance();
        game.battleStart(player, getWarrior(), monster);
    }
    public void useFireScroll() { 
        monster.abilityDefend(warrior, fireScroll);
    }
    public void usePotion() {
        warrior.heal(potion);
    }
    public void useOmniSlash() {
         monster.abilityDefend(warrior, omniSlash);
    }
     public void useArmageddon() {
         monster.abilityDefend(warrior, armageddon);
    }
    public static CharacterSelection createWarrior() {
        fireScroll = new Item("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);
        potion = new Item("Potion", "A devine glow covers your body", 0,25,3);
        warrior = new CharacterSelection("The Might Warrior -","- Brave attacker of all that is evil",100,10,50,10,30,50,50);
        omniSlash = new Item("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
        armageddon = new Item("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);
        setWarrior(warrior);
        return warrior;
    }
    public static CharacterSelection createPaladin() {
        fireScroll = new Item("Firescroll", "The power of Fire surges throughout your body", 45, 0, 5);
        potion = new Item("Potion", "A devine glow covers your body", 0,25,3);
        warrior = new CharacterSelection("The Might Paladin Defender -","- Brave defender of the people for all that is good.", 100,10,40,10,30,40,60);
        omniSlash = new Item("OmniSlash", "You fill your sword with your life force, It comes to life with the thirst of blood", 45, 0, 5);
        armageddon = new Item("Armageddon", "Your sword comes to life searching for revenge for all the evils done", 45, 0, 5);
        setWarrior(warrior);
        return warrior;
    }
    
    public static void setWarrior(CharacterSelection warrior) {
        GameControl.warrior = warrior;
    }

    public static CharacterSelection getWarrior() {
        return warrior;
    }

    
}
