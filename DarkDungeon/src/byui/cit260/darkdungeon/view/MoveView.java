/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;



import byui.cit260.darkdungeon.control.GameControl;
import static byui.cit260.darkdungeon.control.GameControl.game;
import static byui.cit260.darkdungeon.control.GameControl.warrior;
import byui.cit260.darkdungeon.control.MapControl;
import byui.cit260.darkdungeon.exception.BattleControlException;
import byui.cit260.darkdungeon.model.CharacterSelection;
import byui.cit260.darkdungeon.model.Game;
import byui.cit260.darkdungeon.model.Location;
import byui.cit260.darkdungeon.model.Map;
import darkdungeongame.DarkDungeonGame;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Florian
 */
public class MoveView extends View{
   private String bannerTop;
   private String north;
   private String south;
   private String east;
   private String west;
   private String bannerBottom;
   private String beforeBattle;
   private String afterBattle;
   private String deadAfterBattle;
   
   int columnCurrent;
   int rowCurrent;
   boolean northPossible;
   boolean southPossible;
   boolean eastPossible;
   boolean westPossible;
   Game game;
   Map map;
//Location[][] locations = map.getLocations();
    //private final String promptMessage;
    //private final String menu;
    public MoveView() {
        this.bannerTop=("\n"
                  + "\n|=====================================|"
                  + "\n|               Movement              |"
                  + "\n|=====================================|");
        
        this.bannerBottom=("\n|    B. Back to Previous Menu         |"
                  + "\n|    Q - Quit to the Main Menu        |"
                  + "\n|=====================================|"
                  + "\nWhich direction would you like to travel? ~~~>");
        
        this.north=("\n|    N - North                        |");
        this.south=("\n|    S - South                        |");
        this.east=("\n|    E - East                         |");
        this.west=("\n|    W - West                         |");
        this.beforeBattle=("******************************************************************************************************"
                       + "\n* As you descend ever deeper into these ancient ruins the torch you are carrying begins to flicker   *"
                       + "\n* and fail. Your supply of torches is nearly exhausted and you may have to turn back soon or be      *"
                       + "\n* trapped here without any light source. How long has it been since you came down here? Hours? Days? *"
                       + "\n* From the number of torches, you have gone through probably at least 10 or 12 hours. You need to    *"
                       + "\n* rest and eat. Unfortunately, it seems as if every time you have stopped you have been attacked by  *"
                       + "\n* some vile creature. You unpack some journey bread from you backpack and smear it with some fruit   *"
                       + "\n* preserves. This will have to hold you over till you can get back to the surface.                   *"
                       + "\n*                                                                                                    *"
                       + "\n* Once you have gobbled down the last of the bread and drank some water you begin to notice that the *"
                       + "\n* tunnel you are in seems to be leveling out. There is also a smell possibly of Sulphur or brimstone.*"
                       + "\n* As you continue to walk you notice that the humidity and temperature has also begun to increase.   *"
                       + "\n* You come to a bend in the tunnel and as you peer around the corner you see an open door and a      *"
                       + "\n* bright yellowish light. As you cautiously you approach the door you here a laugh and a voice say no*"
                       + "\n* need to tip toe I’ve been expecting you ever since you followed me down last night. I hope my pets *"
                       + "\n* have kept you entertained. Please do come in.                                                      *"
                       + "\n*                                                                                                    *" 
                       + "\n* As you step into the large cavernous chamber you see a tall man in black armor holding a wooden ash*"
                       + "\n* white Staff standing near a door on the other side of the chamber. The Staff he is holding has a   *"
                       + "\n* large green orb attached to the top with black iron bands that have been cast to look like skeletal*"
                       + "\n* fingers clutching the stone. Black Runes are burned into the shaft of the staff. In the center of  *"
                       + "\n* the chamber is a huge pile of bones. The armored figure laughs and says.                           *" 
                       + "\n*                                                                                                    *" 
                       + "\n* I suppose you have many questions and are wondering what I am doing down here. But wait, where are *"
                       + "\n* my manners, let me introduce myself. My name is Hends Solthresh, formerly a Paladin of Praydon and *"
                       + "\n* more recently a Champion of Thantos God of Death. I no longer work for either of them though and   *"
                       + "\n* consider myself a free agent if you will. I prefer the title of Necromancer nowadays.              *"
                       + "\n*                                                                                                    *" 
                       + "\n* Well I have enjoyed watching you play with my pets but I am very busy and I have things I need to  *"
                       + "\n* be doing like raising up my undead army to conquer the surface world . So I am afraid I must take  *"
                       + "\n* my leave of you but worry not I am sure Ragnor will be willing to play with you for a little while *"
                       + "\n* but do be careful – I’m afraid he bites.                                                              *"
                       + "\n*                                                                                                    *"
                       + "\n* As he finishes his little tirade you hear the door behind you shut and lock and the pile of bones  *"
                       + "\n* in front of you begin to move. As the bones shift and move you realize that they are not just a    *"
                       + "\n* random assortment of bones but actually they are part of a very large skeletal dragon.             *"
                       + "\n*                                                                                                    *"
                       + "\n* The Necromancer chuckles and says as he turns to leave,” Ragnor, I told you I bring you a toy to   *"
                       + "\n* play with try to not destroy it too quickly.”                                                           *"
                       + "\n*                                                                                                    *"
                       + "\n* You are being attacked by a Dracolich what do you do?                                              *"
                       + "\n******************************************************************************************************");
         this.afterBattle=("*********************************************************************************************************"
                       + "\n* The ethereal green flame around the Dracolichs skeletal form slowly fades as your final blow shatters *"
                       + "\n* its skull and its dry brittle bones crumble to dust. You have won your battle – how, you may never    *"
                       + "\n* really be sure. For a brief moment during the battle just as you thought you were done for suddenly   *"
                       + "\n* you felt a sense of calm come over you and your moves and attacks just flowed naturally.              *"
                       + "\n*                                                                                                       *"
                       + "\n* You are exhausted and even your aches have aches. You quickly tend to your more serious wounds        *"
                       + "\n* stopping the bleeding before you rest. Unfortunately the Necromancer is gone.  You have foiled his    *"
                       + "\n* plans for now and the Dracolich’s treasure horde is more than you ever imagined. It is going to take  *"
                       + "\n* you some time to find a way to transport this back to a safe place. After loading up the first load of*"
                       + "\n* treasure you follow the escape passage that the Necromancer used to the surface. Upon reaching the    *"
                       + "\n* surface you find that you are on a cliff overlooking the port city of Silvermist just as the sun      *"
                       + "\n* begins to rise over the bay.                                                                          *"
                       + "\n*********************************************************************************************************\n");
     this.deadAfterBattle=("*********************************************************************************************************"
                       + "\n*                                                                                                       *"
                       + "\n*  The Dragon slashes his skeletal claws across your throat ripping open your neck. As the life blood   *" 
                       + "\n*  spurts out from your body you feel yourself fading. You are in shock you were so close to winning    *"
                       + "\n*  this battle and completing you mission now no one will know the danger the world is in. The light in *"
                       + "\n*  yours eyes dim and the world goes black.                                                             *"
                       + "\n*                                                                                                       *"
                       + "\n*********************************************************************************************************");
    }
    
    @Override
    public void display() {
        game = DarkDungeonGame.getCurrentGame(); // retreive the game
        map = game.getMap(); // retreive the map from game
        boolean done = false; // set to not done
        String menuOption;
        String className = this.getClass().getSimpleName();
        
        
        do {
            try {
                if (!"MainMenuView".equals(className)&&game.getWarrior().isDead()) return;
            }
            catch (Exception e) {}
            // prompt for and get players name
            rowCurrent = map.getCurrentRow();
            columnCurrent = map.getCurrentColumn();
            northPossible = roomExists(rowCurrent,(columnCurrent+1));
            southPossible = roomExists(rowCurrent,(columnCurrent-1));
            eastPossible = roomExists((rowCurrent+1),columnCurrent);
            westPossible = roomExists((rowCurrent-1),columnCurrent);
            System.out.println("\n"+map.getCurrentLocation().getScene().getDescription());
            if (!"FN".equals(map.getCurrentLocation().getScene().getMapSymbol())){System.out.print(this.bannerTop);
            if (northPossible) System.out.print(this.north);
            if (southPossible) System.out.print(this.south);
            if (eastPossible) System.out.print(this.east);
            if (westPossible) System.out.print(this.west);
            System.out.print(this.bannerBottom);
            menuOption = this.getInput();}
            else {
                try {
                this.openDracolich();
                game.getWarrior().setHealth(0);
                warrior.setExist(false);
                }
                catch (Exception e) {ErrorView.display(this.getClass().getName(),e + " - was a error");}
                return;
            }
            if (menuOption.toUpperCase().equals("B")) //user will quit
                return; // exit game
            //display next view
            done = this.doAction(menuOption);
        } while (!done);
    
    }
    
    @Override
    public String getInput() {
        String value = null; //value to be returned
        boolean valid = false; // initialize to not valid
        try {
            while (!valid) { // loop while an invalid value is entered
                //System.out.print(this.displayMessage);
                value = this.keyboard.readLine(); //get next line typed
                this.console.println(value);
                value = value.trim(); //trim off leading and trailing blanks
                if (value.length() <1) { //value is blank
                    ErrorView.display(this.getClass().getName(),"\n*** Value cannot be blank ***");
                    continue;
                }
                break; //end of loop
            }
        }
        catch (Exception e) {System.out.println("Error Reading Input: " + e.getMessage());
        }
        return value; // return the value
    }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        switch (choice) {
            case "N": //North
                try {
                    if (northPossible)this.North();
                    else System.out.println("You cannot go in that direction");
                }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "S": //South
                try {
                    
                    if (southPossible)this.South();
                    else System.out.println("You cannot go in that direction");
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "E": //East
                try {
                    if (eastPossible)this.East();
                    else System.out.println("You cannot go in that direction");
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "W": //West
                try {
                    if (westPossible)this.West();
                    else System.out.println("You cannot go in that direction");
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            case "Q": //West
                try {
                    game.getWarrior().setHealth(0);
                    game.getWarrior().setExist(false);
                    
                    }
                catch (Throwable mo) {
                    ErrorView.display(this.getClass().getName(),mo + " - was a error");
                }
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                return false;
                //break;
        }
        if (game.getWarrior().isAlive()) {return false;}
        else {return true;}
    }
    
    private boolean roomExists(int x, int y) {
        Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            Location[][] locations = map.getLocations(); // retreive the locations from map
            boolean answer = false;
            try {
                
                answer = map.getLocations()[x][y]!=null ;
            }
            catch(Exception e) {}
            return answer;
        
    }
   
    private void North() throws BattleControlException {     
        
        this.console.println("***You have chosen North***");
        //Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
        //Map map = game.getMap(); // retreive the map from game
        //int row = map.getCurrentRow();
        //int column = map.getCurrentColumn();
        
        if (northPossible) {
            
            MapControl.movePlayer(map, rowCurrent, (columnCurrent+1));
            open();
        }
        else this.console.println("Cant go that way");
    }
    private void South() throws BattleControlException {
        
        this.console.println("***You have chosen South***");
        if (southPossible) {
            
            MapControl.movePlayer(map, rowCurrent, (columnCurrent-1));
            open();
        }
        else this.console.println("Cant go that way");
    }
     private void East() throws BattleControlException {
        
        this.console.println("***You have chosen East***");
        if (eastPossible) {
            if (rowCurrent==4&&columnCurrent!=0) {
                MapControl.movePlayer(map, (rowCurrent+1), (columnCurrent-4));}
            else {
                MapControl.movePlayer(map, (rowCurrent+1), columnCurrent);
            }
            open();
        }
        else this.console.println("Cant go that way");
    }
      private void West() throws BattleControlException {
        
        this.console.println("***You have chosen West***");
        if (westPossible) {
            MapControl.movePlayer(map, (rowCurrent-1), columnCurrent);
            open();
        }
        else this.console.println("Cant go that way");
    }
      
      private void open() throws BattleControlException {
        GameControl.createNewBattle(map);
      }
      
      private void openDracolich() throws BattleControlException {
            System.out.println(this.beforeBattle);
            GameControl.createNewBattle(map);
            if (!game.getWarrior().isDead()) System.out.println(this.afterBattle);
            else {System.out.println(this.deadAfterBattle);}
      }

      public boolean doAction2(String mapOption) { 
          mapOption = mapOption.toUpperCase();
            Game game = DarkDungeonGame.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            Location[][] locations = map.getLocations(); // retreive the locations from map
            for (int row = 0; row < locations.length; row++) {
                for (int column = 0; column < locations[row].length; column++) {
                    if (locations[row][column].getScene() != null) {
                        if (mapOption.equals(locations[row][column].getScene().getMapSymbol())) {
                            MapControl.movePlayer(map, row, column);
                            return true;
                        }
                    }
                }
            }
            System.out.println("\n*** Invalid selection *** Try Again later");
            return false;
        }
}
