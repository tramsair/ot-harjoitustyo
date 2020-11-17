
package castleadventure;

import java.util.Random;
import java.util.Scanner;



public class Dice {
    
    private Random random;
    private int faces;
    
    //Constructor
    public Dice(int faces){
        this.random = new Random();
        this.faces = faces;
    }
    
    //Roll one die, returns the roll result
    public int rollDie(){
        return 1 + random.nextInt(faces);
    }
    
    //Rolls multiple dice and adds the roll restults together
    public int rollDice(int number, Dice die){
        int i = 1;
        int sum = 0;
        
        while(i <= number){
            sum = sum + die.rollDie();
            i++;
        }
        
        return sum;
    }
}
