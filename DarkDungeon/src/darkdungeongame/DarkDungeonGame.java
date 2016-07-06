/*
 *  Dark Dungeon game
 */
package darkdungeongame;

import byui.cit260.darkdungeon.view.StartProgramView;
import byui.cit260.darkdungeon.model.*;
import byui.cit260.darkdungeon.control.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
    
    
    
    public static void main(String[] args) {
    
    
    try {
            //Open Charcter stream files or for end user input and output
            DarkDungeonGame.inFile = new BufferedReader(new InputStreamReader(System.in));
            DarkDungeonGame.outFile = new PrintWriter(System.out, true);
            
            //Open Log file
            String filePath = "log.txt";
            File file = new File(filePath);
            DarkDungeonGame.logFile = new PrintWriter(file);
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.startProgramView();
            
        }catch (Exception e){
            System.out.println("Exception: " + e.toString() + "\nCause: " + e.getCause() + "\nMessage: " + e.getMessage());
        }    
        finally {
            try {
                if (DarkDungeonGame.inFile != null)
                    DarkDungeonGame.inFile.close();
                    
                if (DarkDungeonGame.outFile != null)
                    DarkDungeonGame.outFile.close();
                    
                if (DarkDungeonGame.logFile != null)
                    DarkDungeonGame.outFile.close();
                    
            }catch (IOException ex){
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
