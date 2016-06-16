/*
 *  Dark Dungeon game
 */
package darkdungeongame;

import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.control.*;
import byui.cit260.darkdungeon.vew.*;

/**
 * @authors Greg Kenar, William Murray, Florian Kausche
 * CIT 260  First Assignment
 */
public class DarkDungeonGame {
    private static Game currentGame = null;
    private static Player player = null;
    private static Monster monster = null;
    
    
    private static void displayBaner() {
    System.out.println(
    "\t*******************************************************************************************"
    +"\n\t*          ____  ___    ____  __ __    ____  __  ___   __________________  _   __         *"
    +"\n\t*         / __ \\/   |  / __ \\/ //_/   / __ \\/ / / / | / / ____/ ____/ __ \\/ | / /         *"
    +"\n\t*        / / / / /| | / /_/ / ,<     / / / / / / /  |/ / / __/ __/ / / / /  |/ /          *"
    +"\n\t*       / /_/ / ___ |/ _, _/ /| |   / /_/ / /_/ / /|  / /_/ / /___/ /_/ / /|  /           *"
    +"\n\t*      /_____/_/  |_/_/ |_/_/ |_|  /_____/\\____/_/ |_/\\____/_____/\\____/_/ |_/            *"
    +"\n\t*******************************************************************************************\n");

                                                                                  
        System.out.println(
            "\t*******************************************************************************************"
         +"\n\t*    In the waning days of the Demon Wars the Paladin Hends Solthresh made an unholy deal *"
         +"\n\t* with Thantos the God of Death to save his party from destruction. Though Thantos is a   *"
         +"\n\t* neutral God promising to serve any other God violated his oath of fealty to Praydon.    *"
         +"\n\t* Hends was repudiated by Praydon and strip of his Paladinhood.                           *"
         +"\n\t*                                                                                         *"
         +"\n\t*    The God of Death immediately made Hends his servant and avatar. It is said that the  *"
         +"\n\t* rejection by Praydon darkened Hends heart and that over the years as he served Thantos  *"
         +"\n\t* he sought a way to wreck vengeance on the world. Stories say that one day he betrayed   *"
         +"\n\t* Thantos and stole a powerful magic item from the God that allowed Hends to raise and    *"
         +"\n\t* control the dead and thus was born the Necromancer. Little has been heard from Hends    *"
         +"\n\t* since that time but dark rumors say he is in hiding building up his forces to strike.   *"
         +"\n\t*******************************************************************************************\n");
        
    }
    public static void main(String[] args) {
    //Game game = new Game();
    //game.enter();
    
    displayBaner();
    StartProgramView startProgramView = new StartProgramView();
    startProgramView.display();
    } 

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        DarkDungeonGame.player = player;
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        DarkDungeonGame.currentGame = currentGame;
    }
    
    public static Player createPlayer(String playersName) {
        if (playersName == null) return null;
        
        Player player = new Player();
        player.setName(playersName);
        return player;
    }
    
}
