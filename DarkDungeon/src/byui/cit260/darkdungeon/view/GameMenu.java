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
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class GameMenu  {
    //class instance variables
   // private Boolean isAlive;
    private String gameMenu;
    
    public GameMenu() {
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
        Scanner keyboard = new Scanner(System.in); // create infile
        String value = ""; //value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            //System.out.print(this.gameMenu);
            value = keyboard.nextLine(); //get next line typed
            value = value.trim(); //trim off leading and trailing blanks
            if (value.length() <1) { //value is blank
                System.out.println("\nValue cannot be blank");
                continue;
            }
            break; //end of loop
            
        }
        value = value.toUpperCase();
        return value; // return the value
    }
    
    public void battleStart(Player playerName, CharacterSelection character, Monster monster) throws BattleControlException {
        //BattleControl battle = new BattleControl();
        //Monster.newMonsterInstance();
        System.out.println(playerName.getName() + " has encountered a " + monster.getMonsterName()+ "\n");
        System.out.println("You intiate the Battle with " +monster.getMonsterName() + "(" + character.getStatus() + " / "
                + monster.getStatus() + ")");
        OUTER:
        while (character.isAlive() && monster.isAlive()) {
            System.out.print(this.gameMenu);
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
                    int monHealth = BattleControl.attack(character.getMinAttackDamage(), character.getMaxAttackDamage(), monster.getDefense(), monster.getHealth());
                    if (BattleControl.isShield()==true) {System.out.println("The monster has successfuly blocked your attack");}
                    else {System.out.println(character.getCharacterName()+ " hits "+ monster.getMonsterName()+" for "+ BattleControl.getAttackStrength()+" HP of damage \n");}
                    if (monHealth == 0) {System.out.println("\t" + playerName.getName() + " transforms the skull of " + monster.getMonsterName()
                + " into dust to never be seen again");}
                    monster.setHealth(monHealth);
                    break;
                case "Q":
                    EscapeView escape = new EscapeView();
                    boolean escapeBoolean = escape.displayMainMenuView(character);
                    if (escapeBoolean==true) {
                        System.out.println("\tYou run away from the " + monster.getMonsterName() + "!");
                        return;}
                    else {
                        break;
                    }
                    //break OUTER;
                default:
                    System.out.println("\tInvalid command!");
                    break;
            }
            if (monster.isAlive()) {
                int charHealth = BattleControl.attack(monster.getMinAttackDamage(), monster.getMaxAttackDamage(), character.getDefenseAmount(), character.getHealth());
                if (BattleControl.isShield()==true) {System.out.println("You have successfuly blocked the monsters attack");}    
                else {System.out.println(monster.getMonsterName()+ " hits "+ character.getCharacterName()+" for "+ BattleControl.getAttackStrength()+" HP of damage \n");
                if (charHealth == 0) {System.out.println("\t" + character.getCharacterName() + " has been defeated, try again next time");}
                character.setHealth(charHealth);}
           }
            System.out.println("(" + character.getStatus() + " / " + character.getManaStatus() + " / " + monster.getStatus() + ")");
        }
        open();
    }
    private void open() {
       TreasureChestView chestView = new TreasureChestView();
       boolean open = chestView.ChestOpenView();
    }
    
//    public Boolean getIsAlive() {
//        return isAlive;
//    }
//
//    public void setIsAlive(Boolean isAlive) {
//        this.isAlive = isAlive;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 79 * hash + Objects.hashCode(this.isAlive);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final GameMenu other = (GameMenu) obj;
//        if (!Objects.equals(this.isAlive, other.isAlive)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Battle{" + "isAlive=" + isAlive + '}';
//    }
    
    
}
