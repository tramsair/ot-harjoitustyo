
package castleadventure.tools;

//This class will represent the hardships and problems the player character wil lencounter, from enemies to locked doors

import java.util.Scanner;



public class Encounter {
    
    private String description;
    private int difficulty;
    private String attribute;
    private String outcomePositive;
    private String outcomeNegative;
    private String criticalFailure;
    private String choiceOne;
    private String choiceTwo;
    
    public Encounter(String description, int difficulty, String attribute, String outcomePositive, 
            String outcomeNegative, String one, String two) {
        this.attribute = attribute;
        this.description = description;
        this.difficulty = difficulty;
        this.outcomeNegative = outcomeNegative;
        this.outcomePositive = outcomePositive;
        this.choiceOne = one;
        this.choiceTwo = two;
        
    }
    
    public Encounter(String description, int difficulty, String attribute, String outcomePositive, 
            String outcomeNegative, String criticalFailure, String one, String two) {
        this.attribute = attribute;
        this.description = description;
        this.difficulty = difficulty;
        this.outcomeNegative = outcomeNegative;
        this.outcomePositive = outcomePositive;
        this.criticalFailure = criticalFailure;
        this.choiceOne = one;
        this.choiceTwo = two;
        
    }
    
    
//    Encountering the Encounters
//    =====================================
    public String faceEncounter(Scanner scribe, Hero hero, int roll) {
        System.out.println(this.description);
        System.out.println(this.choiceOne);
        System.out.println(this.choiceTwo);        
        
        int pcScore = hero.getAttribute(this.attribute) + roll;
        
        if (pcScore >= this.difficulty) {
            return this.outcomePositive;
        } else {
            return this.outcomeNegative;

        }
    }
    
    public String faceDeadlyEncounter(Scanner scribe, Hero hero, int roll) {
        System.out.println(this.description);
        System.out.println(this.choiceOne);
        System.out.println(this.choiceTwo);
        
        int pcScore = hero.getAttribute(this.attribute) + roll;
        
        
        
        if (pcScore >= this.difficulty) {
            return this.outcomePositive;
        } else {
            if(hero.takeHit()){
                return this.criticalFailure;
                
                
            } else {
                return this.outcomeNegative;
            }
        }
    }
}
