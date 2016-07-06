/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class HelpMenuView extends View{
   // private String helpMenu;
    private String goal;
    private String movement;
    private String backstory;

    public HelpMenuView() {
        super("\n"
                + "\n===================================="
                + "\n|           Help Menu              |"
                + "\n===================================="
                + "\n| Options:                         |"
                + "\n|   G. Goal of the Game            |"
                + "\n|   M. Movement                    |"
                + "\n|   B. Back Story                  |"
                + "\n|   Q. Quit                        |"
                + "\n===================================="
                + "\nMake your Selection ~~~> ");
        this.goal = "\n"
                   +"\n\t================================================================================================="
                   +"\n\t=  There have been reports that some evil force may have occupied the ruins of Caer Darkin,     ="
                   +"\n\t=  an ancient stronghold, in the Trel mountian range. The source of the reports has mainly      ="
                   +"\n\t=  been miners and sheep herders who have reported seeing strange things in the area near the   ="
                   +"\n\t=  castle.                                                                                      ="
                   +"\n\t=                                                                                               ="
                   +"\n\t=  You have been approached by the mayor of the village of Van Kalen to find out what is going  ="
                   +"\n\t=  on. He tells you The town folk are simple people with little experience in the supernatural  ="
                   +"\n\t=  and the ways of magic. He has sent runners to the local garrison in the city of Silvermist   ="
                   +"\n\t=  requesting assistance but the captain of the garrison sent word back that he won’t be able   ="
                   +"\n\t=  to send help for at least several weeks.                                                     ="
                   +"\n\t=                                                                                               =" 
                   +"\n\t=  Luckily you happened to be journeying through the mountains to Silvermist when you stopped   ="
                   +"\n\t=  in the village for the night. They Mayor has hired you to scout the area, explore the ruins, ="
                   +"\n\t=  and determine what exactly what is happening and who is responsible. Enter the goals here    ="
                   +"\n\t=================================================================================================";
        this.movement = "\n"
                   +"\n\t==============================================="
                   +"\n\t=  This will explain the movements, " 
                   +"\n\t=  Enter the movements here"
                   +"\n\t===============================================";
        this.backstory = "\n"
                   +"\n\t=========================================================================================================="
                   +"\n\t=  Nearly three thousand years ago at the end of the Mage Wars the world laid in waste. Legends From     ="
                   +"\n\t= that time tell us the Archmage Torrin had used his dark magics to cause a great rock to fall from the  ="
                   +"\n\t= sky and shatter the world. The great cities had been destroyed and the very continents had been        ="
                   +"\n\t= by the impact. The Sun was blocked for years after by the cloud of debris that had been sent up into   ="
                   +"\n\t= the air.                                                                                               ="
                   +"\n\t=                                                                                                        ="
                   +"\n\t= The World laid dying. The Gods of Aesir turned to the Creator and sought his aid in restoring the      ="
                   +"\n\t= world. Through his intervention the World of Aesir was renewed. Yet the damage that had been wrought   ="
                   +"\n\t= had also unleashed ancient banes buried deep beneath the world. Demons and Devils from a far more      ="
                   +"\n\t= ancient time had been freed from the prison that the Gods had condemned them to. Theses creatures of   ="
                   +"\n\t= evil hid themselves from the eyes of the Gods and slowly infiltrated human society. They took human    ="
                   +"\n\t= form and slowly took control of the Church and the Government. They slowly corrupted  the teachings of ="
                   +"\n\t= the Church and cut mankind off from the Gods by doing so. Many ancient and precious truths were lost   ="
                   +"\n\t= because of what these creatures did. Slowly mankind fell into a dark age not just of technology but    ="
                   +"\n\t= of spiritually.                                                                                        ="
                   +"\n\t=                                                                                                        ="
                   +"\n\t= The Gods of Aesir seeing what was happening raised up a group of heroes to restore the World to the    ="
                   +"\n\t= light. In time the Heroes were successful in driving the evil back to the nether regions were they     ="
                   +"\n\t= had come. In time this battle would come to be called the Demon War. One of the heroes of this         ="
                   +"\n\t= campaign was a Paladin of the God Praydon – King of the Gods of Good. This Paladin, Hends Solthresh,   ="
                   +"\n\t= unfortunately wavered at a critical time and lost faith. Hend’s faced with the death of his party      ="
                   +"\n\t= members made a deal with the God of Death for their lives. He would serve Death if he would spare      ="
                   +"\n\t= their lives. A deal was struck and Hend and his party survived and defeated the  Devils. No Paladin    ="
                   +"\n\t= can serve more than one God and Praydon stripped him of his Paladinhood.                               ="
                   +"\n\t=                                                                                                        ="
                   +"\n\t= The loss of his Paladinhood darkened Hends heart and he began to grow bitter and vengeful. He blamed   ="
                   +"\n\t= not only Praydon but Thantos, the God of Death, and sought a way to exact his revenge on them. He      ="
                   +"\n\t= served Thantos for several hundred years as his servant before he found a way to strike at him. He     ="
                   +"\n\t= stole a powerful magic artifact from the God known by many names – the Stone of Tears, the Soul Gem,   ="
                   +"\n\t= the Orb of Thantos. This powerful artifact gave Hends the the ability to animate and command the       ="
                   +"\n\t= dead.                                                                                                  ="                                                                        
                   +"\n\t=                                                                                                        ="
                   +"\n\t= Since gaining possession of the Orb of Thantos Hends has been in hiding learning how to use it and     ="
                   +"\n\t= testing it’s abilities. Once a powerful Paladin Hend’s has now taken on another name – The Necromancer.="
                   +"\n\t= The World of Aesir a realm of magic and adventure. This Ancient world has a vast and complex history.  ="
                   +"\n\t= If you would like to learn more about this realm you can find more information at HeroesofAesir.com.   ="
                   +"\n\t==========================================================================================================";
   }
    
    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase
        
        switch (choice) {
            case "G": //Goal of the game
                this.gameGoals();
                break;
            case "M": //Movement
                this.movementInstructions();
                break;
            case "B": //Back Story
                this.backStory();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void gameGoals() {
        this.console.print(this.goal);
    }

    private void movementInstructions() {
        this.console.println(this.movement);
    }

    private void backStory() {
        this.console.println(this.backstory);
    }
}
