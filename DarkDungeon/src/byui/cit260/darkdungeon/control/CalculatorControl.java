/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.darkdungeon.control;

import static byui.cit260.darkdungeon.control.CalculatorControl.response;
import byui.cit260.darkdungeon.exception.CalculatorControlException;
import java.util.Random;

/**
 *
 * @author gregg
 */
public class CalculatorControl {
    
    public static boolean calculator(double first, double second, double answer, String sign) throws CalculatorControlException {
        
        double total = 0;
        if ("*".equals(sign) || "/".equals(sign) || "+".equals(sign) || "-".equals(sign)) {
           if ("+".equals(sign))
            {
                total = first + second;
                System.out.println(sign);
            }
            else if ("-".equals(sign))
            {
                total = first - second;
            }
            else if ("*".equals(sign))
            {
                total = first * second;
            }
            else if ("/".equals(sign))
            {
                total = first / second;
            }
            try {
                CalculatorControl contr = new CalculatorControl();
                double total2 = contr.round(total, 2);
                if (answer == total2) {
                    System.out.println(first+" "+sign+" "+second+" = "+answer);
                return true;
                }
                else return false;
            }
               catch (Exception a) {throw new CalculatorControlException("Error, used the wrong Opperand");}
        }
        // show if false statement with a alert.
        else {
        throw new CalculatorControlException("Error, used the wrong Opperand");
        }
    }

    public double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
    }
    
    public static String response() {
    String[] response = {"The laws of science didn't cease to exist in your computer, Please enter the correct number between 0 and 999 ",
   "Your mind is so sharp solving E=mc2 would be a cake walk for you, but please remember to enter a number between 0 and 999. ",
   "This program can only do as much as it can, the rest is up to you. You forgot to enter a number between 0 and 999 ",
   "God has truely blessed you with a sharp mind, please remember to enter a number between 0 and 999",
   "Very embitious, but you forgot to enter a number between 0 and 999 ",
   "Slow down there speedy, dont forget to enter a number between 0 and 999"};
   
    Random random = new Random();
    int index = random.nextInt(response.length);
    return response[index];
    
    }
    
    
    
}
