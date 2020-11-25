
package castleadventure.tools;

import java.util.Random;



public class Dice {
    
    private Random random;
    
    //Constructor
    public Dice(int faces) {
        this.random = new Random();
    }
    
    //Roll one die, returns the roll result
    public int rollDie(int faces) {
        return 1 + random.nextInt(faces);
    }
    
    //Rolls multiple dice and adds the roll restults together
    public int rollDice(int number, Dice die) {
        int i = 1;
        int sum = 0;
        
        while (i <= number) {
            sum = sum + die.rollDie(6);
            i++;
        }
        
        return sum;
    }
    
}
