/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author K
 */
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test of Move method, of class MapControl.
     */
    //@Test
//    public void testMove() {
//        System.out.println("Move");
//        /*******************************
//         * Test case #1
//         *******************************/
//         System.out.println("\tTest case #1");
//        int character = 1;
//        int location = 1;
//        int monster = 1;
//        int health = 1;
//        MapControl instance = new MapControl();
//        int expResult = 4;
//        int result = instance.Move(character, location, monster, health);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }
//
//    /**
//     * Test of validLocation method, of class MapControl.
//     */
//     
//    @Test
//    public void testValidLocation() {
//        System.out.println("validLocation");
//        /*******************************
//         * Test case #2
//         *******************************/
//        System.out.println("\tTest case #2");
//        int character = 0;
//        int location = 0;
//        MapControl instance = new MapControl();
//        boolean expResult = false;
//        boolean result = instance.validLocation(character, location);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//
//    }

    /**
     * Test of openLock method, of class MapControl.
     */
    @Test
    public void testOpenLock() {
        System.out.println("openLock");
         /*******************************
         * Test case #3
         *******************************/
        System.out.println("\tTest case #3");
        MapControl instance = new MapControl();
        boolean expResult = false;
        boolean result = instance.openLock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
