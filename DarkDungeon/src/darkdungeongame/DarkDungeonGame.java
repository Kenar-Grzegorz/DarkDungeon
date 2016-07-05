/*
 *  Dark Dungeon game
 */
package darkdungeongame;

import byui.cit260.darkdungeon.view.StartProgramView;
import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.control.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @authors Greg Kenar, William Murray, Florian Kausche
 * CIT 260  First Assignment
 */
public class DarkDungeonGame {
    private static Game currentGame = null;
    private static Player player = null;
    private static Monster monster = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    
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
        try {
            DarkDungeonGame.inFile = new BufferedReader(new InputStreamReader(System.in));
            DarkDungeonGame.outFile = new PrintWriter(System.out, true);
            
            //open log file
            String filePath = "log.txt";
            DarkDungeonGame.logFile = new PrintWriter(filePath);
            
            startProgramView.display();
            return;
        }
        catch (Throwable te) {
            System.out.println("Exception: " + te.toString() + "\nCause: " + te.getCause() + "\nMessage: " + te.getMessage());
            
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.display();
        }
        finally {
            try {
                if (DarkDungeonGame.inFile != null)
                    DarkDungeonGame.inFile.close();
                if (DarkDungeonGame.outFile != null)
                    DarkDungeonGame.outFile.close();
                if (DarkDungeonGame.logFile != null)
                    DarkDungeonGame.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
       
        }
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        DarkDungeonGame.logFile = logFile;
    }
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        DarkDungeonGame.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        DarkDungeonGame.inFile = inFile;
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
    
    public static Monster createMonster(String monsterName) {
        if (monsterName == null) return null;
        
        Monster monster = new Monster();
        return monster;
    }

    public static void setMonster(Monster monster) {
        DarkDungeonGame.monster = monster;
    }
}
