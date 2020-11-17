
package castleadventure;

import java.util.Random;
import java.util.Scanner;



public class Dice {
    
    private Random random;
    private int faces;
    
    public Dice(int faces){
        this.random = new Random();
        this.faces = faces;
    }
    
    public int rollDie(){
        return 1 + random.nextInt(faces);
    }
    
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
