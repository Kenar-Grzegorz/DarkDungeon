/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package byui.cit260.darkdungeon.enums;

/**
 * 
 * @author Greg
 */
public enum Item {
        firescroll,
        potion,
        omniSlash,
        armageddon,
        testItem,
        ether,
        tent;
        
        private final int value;

        private Item() {
        this.value = ordinal();
        }
        
        public static Item fromValue(int value) 
             throws IllegalArgumentException {
         try {
              return Item.values()[value];
         } catch(ArrayIndexOutOfBoundsException e) {
              throw new IllegalArgumentException("Unknown enum value :"+ value);
         }
     }
        
        
}