/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;


import byui.cit260.darkdungeon.control.BattleControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.*;
//import byui.cit260.darkdungeon.model.Game.player;
import darkdungeongame.DarkDungeonGame;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class BattleMenuView  {
    //class instance variables
   // private Boolean isAlive;
    private String gameMenu;
    protected final BufferedReader keyboard = DarkDungeonGame.getInFile();
    protected final PrintWriter console = DarkDungeonGame.getOutFile();
    
    public BattleMenuView() {
        this.gameMenu = "\n"
                + "\n===================================="
                + "\n|             Battle               |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|        A. Attack                 |"
                + "\n|        S. Specials / Abilities   |"
                + "\n|        I. Item Sack              |"
                + "\n|        Q. Run Away               |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ";
        
    }
    private String getMenuOption() {
        
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                //System.out.print(this.gameMenu);
                value = keyboard.readLine(); //get next line typed
                value = value.trim(); //trim off leading and trailing blanks
                if (value.length() <1) { //value is blank
                    ErrorView.display(this.getClass().getName(),"Value cannot be blank");
                    continue;
                }
                break; //end of loop
            }
        }
        catch (Exception e) {ErrorView.display(this.getClass().getName(),"Error Reading Input: " + e.getMessage());}
        value = value.toUpperCase();
        return value; // return the value
    }
    
    public void battleStart(Player playerName, CharacterSelection character, Monster monster) throws BattleControlException  {
        //BattleControl battle = new BattleControl();
        //Monster.newMonsterInstance();
        this.console.println(playerName.getName()+ " has encountered a " + monster.getMonsterName()+ "\n");
        this.console.println("You intiate the Battle with " +monster.getMonsterName() + "(" + character.getStatus() + " / "
                + monster.getStatus() + ")");
        OUTER:
        while (character.isAlive() && monster.isAlive()) {
            this.console.print(this.gameMenu);
            String action = this.getMenuOption();
            switch (action) {
                case "S":
                    SpecialMenuView specialView = new SpecialMenuView();
                    specialView.display();
                    break;
                case "I":
                    ItemMenuView itemView = new ItemMenuView();
                    itemView.display();
                    break;
                case "A":
                    try {
                        int monHealth = BattleControl.attack(character.getMinAttackDamage(), character.getMaxAttackDamage(), monster.getDefense(), monster.getHealth());
                        if (BattleControl.isShield()==true) {this.console.println("The monster has successfuly blocked your attack");}
                        else {this.console.println(character.getCharacterName()+ " hits "+ monster.getMonsterName()+" for "+ BattleControl.getAttackStrength()+" HP of damage \n");}
                        if (monHealth == 0) {this.console.println("\t" + playerName.getName() + " transforms the skull of " + monster.getMonsterName()
                    + " into dust to never be seen again");}
                        monster.setHealth(monHealth);
                    }
                    catch (Throwable at) {
                        ErrorView.display(this.getClass().getName(),at.getMessage());
                    }
                    break;
                case "Q":
                    EscapeView escape = new EscapeView();
                    try {    
                        boolean escapeBoolean = escape.displayMainMenuView(character);
                        if (escapeBoolean==true) {
                            this.console.println("\tYou run away from the " + monster.getMonsterName() + "!");
                            return;}
                        else {
                            break;
                        }
                    }
                    catch (Throwable ev) {
                        ErrorView.display(this.getClass().getName(),ev.getMessage());
                    }

                    //break OUTER;
                default:
                    ErrorView.display(this.getClass().getName(),"\tInvalid command!");
                    break;
            }
            if (monster.isAlive()) {
                try {
                    int charHealth = BattleControl.attack(monster.getMinAttackDamage(), monster.getMaxAttackDamage(), character.getDefenseAmount(), character.getHealth());
                    if (BattleControl.isShield()==true) {this.console.println("You have successfuly blocked the monsters attack");}    
                    else {this.console.println(monster.getMonsterName()+ " hits "+ character.getCharacterName()+" for "+ BattleControl.getAttackStrength()+" HP of damage \n");
                    if (charHealth == 0) {this.console.println("\t" + character.getCharacterName() + " has been defeated, try again next time");}
                    character.setHealth(charHealth);}
                }
                catch (Throwable ia) {
                    ErrorView.display(this.getClass().getName(),ia.getMessage());
                }
           }
            this.console.println("(" + character.getStatus() + " / " + character.getManaStatus() + " / " + monster.getStatus() + ")");
        }
        
        if (character.isAlive()) {    
            try {
                open();
            }
            catch (Throwable ch) {
                ErrorView.display(this.getClass().getName(),ch.getMessage());
            }
        }
        
    }
    private void open() throws BattleControlException {
       TreasureChestView chestView = new TreasureChestView();
       boolean open = chestView.ChestOpenView();
    }
   
    
    
}
