/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.vew;

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
                System.out.println("\n*** Invalid Selection *** Try again");
                break;
        }
        return false;
    }

    private void Axe() {

        System.out.println("***You have chosen an Axe***");
        choose();
    }

    private void magicalPotion() {

        System.out.println("***You have chosen the magical potion***");
         choose();
    }

    private void Sword() {

        System.out.println("***You have chosen a sword***");
         choose();
    }

    private void Fist() {

        System.out.println("***You have chosen to use your fist***");
         choose();
    }
    

    private void choose() {
        GameControl.createNewBattle();
    }

    private void Arrow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
