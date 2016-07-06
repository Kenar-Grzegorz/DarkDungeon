/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.view;

import byui.cit260.darkdungeon.control.GameControl;

/**
 *
 * @author K
 */
public class InventoryView extends View {

    //private final String promptMessage;
    //private final String menu;
    public InventoryView() {
        super("\n"
                + "\n|=====================================|"
                + "\n|              Inventory              |"
                + "\n|=====================================|"
                + "\n|    N - Axe                          |"
                + "\n|    S - Magical potion               |"
                + "\n|    E - Arrow                        |"
                + "\n|    W - Sword                        |"
                + "\n|    Q - Fist                         |"
                + "\n|=====================================|"
                + "\nChose a weapon? ~~~>");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); //convert to uppercase

        switch (choice) {
            case "N": //Axe

                this.Axe();
                break;
            case "S": //magical potion
                this.magicalPotion();
                break;
            case "E": //Arrow
                this.Arrow();
                break;
            case "W": //Sword
                this.Sword();
                break;
            case "F": //Fist
                this.Fist();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void Axe() {

        this.console.println("***You have chosen an Axe***");
        choose();
    }

    private void magicalPotion() {

        this.console.println("***You have chosen the magical potion***");
         choose();
    }

    private void Sword() {

        this.console.println("***You have chosen a sword***");
         choose();
    }

    private void Fist() {

        this.console.println("***You have chosen to use your fist***");
         choose();
    }
    

    private void choose() {
        this.console.println("here you go");
    }

    private void Arrow() {
        this.console.println("***You have chosen a satchel of Arrows***");
    }

    
}
