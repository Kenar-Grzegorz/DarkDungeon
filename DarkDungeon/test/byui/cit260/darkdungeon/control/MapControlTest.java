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
    @Test
    public void testMove() {
        System.out.println("Move");
        int character = 0;
        int location = 0;
        int monster = 0;
        int health = 0;
        MapControl instance = new MapControl();
        int expResult = 0;
        int result = instance.Move(character, location, monster, health);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validLocation method, of class MapControl.
     */
    @Test
    public void testValidLocation() {
        System.out.println("validLocation");
        int character = 0;
        int location = 0;
        MapControl instance = new MapControl();
        boolean expResult = false;
        boolean result = instance.validLocation(character, location);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openLock method, of class MapControl.
     */
    @Test
    public void testOpenLock() {
        System.out.println("openLock");
        MapControl instance = new MapControl();
        boolean expResult = false;
        boolean result = instance.openLock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
