/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import byui.cit260.darkdungeon.exception.BattleControlException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg K, Bill M, Florian K
 */
public class BattleControlTest {
    
    public BattleControlTest() {
    }

    /**
     * Test of attack method, of class BattleControl. ~~ Team Project
     */
    @Test
    public void testAttack() throws BattleControlException {
        System.out.println("attack");
        /*******************************
         * Test case #1
         *******************************/
        System.out.println("\tTest case #1");
        int min = 35;
        int max = 35;
        int defense = 5;
        int health = 100;
        int expResult = 70;
        BattleControl test = new BattleControl();
        int result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        /*******************************
         * Test case #2
         *******************************/
        System.out.println("\tTest case #2");
        min = 10;
        max = 10;
        defense = 20;
        health = 40;
        expResult = 40;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        /*******************************
         * Test case #3
         *******************************/
        System.out.println("\tTest case #3");
        min = -5;
        max = -5;
        defense = 0;
        health = 40;
        expResult = -1;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        /*******************************
         * Test case #4
         *******************************/
        System.out.println("\tTest case #4");
        min = 40;
        max = 40;
        defense = 5;
        health = 5;
        expResult = 0;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        /*******************************
         * Test case #5
         *******************************/
        System.out.println("\tTest case #5");
        min = 50;
        max = 50;
        defense = 10;
        health = 40;
        expResult = 0;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        /*******************************
         * Test case #6
         *******************************/
        System.out.println("\tTest case #6");
        min = 10;
        max = 10;
        defense = 10;
        health = 200;
        expResult = 200;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
        /*******************************
         * Test case #7
         *******************************/
        System.out.println("\tTest case #7");
        min = 1;
        max = 1;
        defense = 0;
        health = 1;
        expResult = 0;
        result = test.attack(min, max, defense, health);
        assertEquals(expResult, result);
    }

    /**
     * Test of random method, of class BattleControl. ~~ Greg K
     */
    @Test
    public void testRandom() throws BattleControlException {
        /*******************************
         * Test case #1
         *******************************/
        System.out.println("random");
        System.out.println("\tTest case #1");
        int min = 80;
        int max = 80;
        int expResult = 80;
        BattleControl test2 = new BattleControl();
        int result = test2.random(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
         /*******************************
         * Test case #2
         *******************************/
        System.out.println("\tTest case #2");
        min = 250;
        max = 250;
        expResult = -1;
        result = test2.random(min, max);
        assertEquals(expResult, result);
        /*******************************
         * Test case #3
         *******************************/
        System.out.println("\tTest case #3");
        min = -5;
        max = -5;
        expResult = -1;
        result = test2.random(min, max);
        assertEquals(expResult, result);
        /*******************************
         * Test case #4
         *******************************/
        System.out.println("\tTest case #4");
        min = 20;
        max = 10;
        expResult = -1;
        result = test2.random(min, max);
        assertEquals(expResult, result);
        /*******************************
         * Test case #5
         *******************************/
        System.out.println("\tTest case #5");
        min = 0;
        max = 0;
        expResult = 0;
        result = test2.random(min, max);
        assertEquals(expResult, result);
        /*******************************
         * Test case #6
         *******************************/
        System.out.println("\tTest case #6");
        min = 200;
        max = 200;
        expResult = 200;
        result = test2.random(min, max);
        assertEquals(expResult, result);
        /*******************************
         * Test case #7
         *******************************/
        System.out.println("\tTest case #7");
        min = 1;
        max = 1;
        expResult = 1;
        result = test2.random(min, max);
        assertEquals(expResult, result);
    }
    /**
     * Test of random method, of class BattleControl. ~~ Greg K
     */
    @Test
    public void testSuperAttack() throws BattleControlException {
        /*******************************
         * Test case #1
         *******************************/
        System.out.println("SuperAttack");
        System.out.println("\tTest case #1");
        int health = 100;
        int damage = 20;
        int defense = 5;
        int expResult = 85;
        BattleControl test3 = new BattleControl();
        int result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
         /*******************************
         * Test case #2
         *******************************/
        System.out.println("\tTest case #2");
        health = -5;
        damage = 30;
        defense = 0;
        expResult = -1;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
         /*******************************
         * Test case #3
         *******************************/
        System.out.println("\tTest case #3");
        health = 100;
        damage = 1;
        defense = 1;
        expResult = -1;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
         /*******************************
         * Test case #4
         *******************************/
        System.out.println("\tTest case #4");
        health = 10;
        damage = 50;
        defense = 5;
        expResult = 0;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
         /*******************************
         * Test case #5
         *******************************/
        System.out.println("\tTest case #5");
        health = 200;
        damage = 100;
        defense = 10;
        expResult = 110;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
         /*******************************
         * Test case #6
         *******************************/
        System.out.println("\tTest case #6");
        health = 200;
        damage = 10;
        defense = 10;
        expResult = 200;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
         /*******************************
         * Test case #7
         *******************************/
        System.out.println("\tTest case #7");
        health = 100;
        damage = 100;
        defense = 0;
        expResult = 0;
        result = test3.superAttack(health, defense, damage);
        assertEquals(expResult, result);
    }
    
}
