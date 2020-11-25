
package castleadventure.tools;

//This class will represent the hardships and problems the player character wil lencounter, from enemies to locked doors

public class Encounter {
    
    private String description;
    private int difficulty;
    private String attribute;
    private String outcomePositive;
    private String outcomeNegative;
    
    public Encounter(String description, int difficulty, String attribute, String outcomePositive, String outcomeNegative) {
        this.attribute = attribute;
        this.description = description;
        this.difficulty = difficulty;
        this.outcomeNegative = outcomeNegative;
        this.outcomePositive = outcomePositive;
    }
    
    public String faceEncounter(Hero hero, int roll) {
        int pcScore = hero.getAttribute(attribute) + roll;
        
        if (pcScore >= this.difficulty) {
            return this.outcomePositive;
        } else {
            return this.outcomeNegative;
        }
    }
}
