/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import darkdungeongame.DarkDungeonGame;
import java.io.PrintWriter;

/**
 *
 * @author gregg
 */
public class ErrorView {
    private static final PrintWriter errorFile = DarkDungeonGame.getOutFile();
    private static final PrintWriter logFile = DarkDungeonGame.getLogFile();
    
    public static void display(String className, String errorMessage) {
    
        errorFile.println(
        "------------------------------------------------------------------"
      + "\n- ERROR - " + errorMessage
      + "\n------------------------------------------------------------------");
        
        //log error
        logFile.println(className + " - " + errorMessage);
        logFile.flush();
    }
}
