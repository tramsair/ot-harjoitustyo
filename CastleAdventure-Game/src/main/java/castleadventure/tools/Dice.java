/**
 * Utility for any dice rolls needed within the game, from character creation to 
 * challenge resolution
 */
package castleadventure.tools;

import java.util.Random;



public class Dice {
    
    private Random random;
    
    //Constructor
    public Dice() {
        this.random = new Random();
    }
    
    //Roll one die, returns the roll result
    /**
     * The method rolls one die of specific size
     * 
     * @param faces the number of faces, or the maximum value of the random number
     * 
     * @return number between 1 and the value of "faces"
     */
    public int rollDie(int faces) {
        return 1 + random.nextInt(faces);
    }
    
    //Rolls multiple dice and adds the roll restults together
    /**
     * Rolls multiple dice and adds the roll results together
     * 
     * @param number how many dice are rolled
     * 
     * @param die what kind of die is rolled
     * 
     * @return the sum of the rolled dice
     */
    public int rollDice(int number, Dice die) {
        int i = 1;
        int sum = 0;
        
        while (i <= number) {
            sum = sum + die.rollDie(6);
            i++;
        }
        
        return sum;
    }
    
    /**
     * Rolls a die, that when it results as the maximum value of the given die, 
     * is rolled again until some other value is rolled, and then all values are 
     * added together
     * 
     * @param faces maximum value of the die
     * 
     * @return the final value of the roll/-s 
     */
    public int rollExplodingDie(int faces) {
        int roll = 1 + random.nextInt(faces);
        int sum = roll;
        
        while (roll == faces && roll != 1) {
            roll = 1 + random.nextInt(faces);
            sum = sum + roll;
        }
        
        return sum;
    }
    
}
