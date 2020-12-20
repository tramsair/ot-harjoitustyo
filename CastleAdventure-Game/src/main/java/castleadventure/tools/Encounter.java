/**
 * This class will represent the hardships and problems the player character will encounter, from enemies to locked doors
 */
package castleadventure.tools;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class Encounter {
    
    private String description;
    private int difficulty;
    private String attribute;
    private String altAttribute;
    private String outcomePositive;
    private String outcomeNegative;
    private String otherOutcomePositive;
    private String otherOutcomeNegative;
    private String criticalFailure;
    private Map<String, String> commands;
    private boolean deadly;
    
    public Encounter(String description, int difficulty, String attribute, String altAttribute, 
            String positive, String negative, String otherPositive, String otherNegative, 
            boolean death, String criticalFailure, String one, String two) {
        
        this.commands = new TreeMap<>();
        this.description = description;
        this.difficulty = difficulty;
        this.attribute = attribute;
        this.altAttribute = altAttribute;
        this.outcomePositive = positive;
        this.outcomeNegative = negative;
        this.otherOutcomePositive = otherPositive;
        this.otherOutcomeNegative = otherNegative;
        this.deadly = death;
        this.criticalFailure = criticalFailure;
        
        this.commands.put("1", one);
        this.commands.put("2", two);
        
    }
    
    
//    Encountering the Encounters
//    =====================================
    
 /**
 * Method solves an encounter for the player character depending on the 
 * sum of the value of a roll and appropriate characteristic.
 *
 * @param hero player's character
 *
 * @param roll value of a dice roll made outside the method
 * 
 * @param action player's input on the choice between two actions
 * 
 * @return message of failure or success depending on the comparison result
 */
    public String faceEncounter(Hero hero, int roll, String action) {       
        
        
        if (action.equals("1")) {
            if (hero.getAttribute(this.attribute) + roll >= this.difficulty) {
                return this.outcomePositive;
            } else {
                return this.outcomeNegative;
            }
        } else {
            if (hero.getAttribute(this.altAttribute) + roll >= this.difficulty) {
                return this.otherOutcomePositive;
            } else {
                return this.otherOutcomeNegative;
            }
        }
        
    }
/**
 * Same as above, but for a dangerous encounter. Failing this encounter will
 * deduct one hitpoint from the character. If character reaches 0 hit points, 
 * the method will return a special game over message.
 *
 * @param hero player's character
 *
 * @param roll value of a dice roll made outside the method
 * 
 * @param action player's input on the choice between two actions
 * 
 * @return message of failure or success depending on the comparison result
 */
    public String faceDeadlyEncounter(Hero hero, int roll, String action) {

        
        if (action.equals("1")) {
            if (hero.getAttribute(this.attribute) + roll >= this.difficulty) {
                return this.outcomePositive;
                
            } else {
//                cheking if hero dies
                if (hero.takeHit()) {
                    return this.criticalFailure;

                } else {
                    return this.outcomeNegative;
                }
            }
        } else {
            if (hero.getAttribute(this.altAttribute) + roll >= this.difficulty) {
                return this.otherOutcomePositive;
            } else {
//                cheking if hero dies
                if (hero.takeHit()) {
                    return this.criticalFailure;

                } else {
                    return this.otherOutcomeNegative;
                }
            }
        }
    }
//    Getters and setters and such utility
//    ===================================================

    public String getDescription() {
        return this.description;
    }
    
    public Map<String, String> getCommands() {
        return this.commands;
    }
    
    public void addCommand(String number, String command) {
        this.commands.put(number, command);
    }
    
    public boolean isDeadly() {
        return this.deadly;
    }
}
