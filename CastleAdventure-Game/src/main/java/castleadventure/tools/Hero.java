/**
 * Representation of the player, the player character. The game will use the 
 * attributes with dice rolls to find out if the succeeds or fails to overcome 
 * any challenges they fail.
 */
package castleadventure.tools;


public class Hero {
    
    private int healthPoints;
    private int physique;
    private int agility;
    private int knowledge;
    private int willpower;
    private int charisma;
    private String name;
    private Dice d6 = new Dice();
    
    public Hero(String name) {
        this.agility = rollAttribute();
        this.charisma = rollAttribute();
        this.knowledge = rollAttribute();
        this.physique = rollAttribute();
        this.willpower = rollAttribute();
        
        this.healthPoints = 2;
        this.name = name;
    }
    
    
   
    
//------------------------------------------------------------------------------
//          Getters
//------------------------------------------------------------------------------    
    
    
    public int getPhysique() {
        return this.physique;
    }
    
    public int getAgility() {
        return this.agility;
    }
    
    public int getKnowledge() {
        return this.knowledge;
    }
    
    public int getWillpower() {
        return this.willpower;
    }
    
    public int getCharisma() {
        return this.charisma;
    }
    
    public int getHP() {
        return this.healthPoints;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAttribute(String attribute) {
        if (attribute.equals("knowledge")) {
            return this.knowledge;
        } else if (attribute.equals("physique")) {
            return this.physique;
        } else if (attribute.equals("agility")) {
            return this.agility;
        } else if (attribute.equals("willpower")) {
            return this.willpower;
        } else {
            return this.charisma;
        }
            
    }
    
//              Getters end
//==============================================================================    
    
/**
 * Rolls the value for a single attribute,
 * 
 * @return sum of three six-sided dice
 */
    
    public int rollAttribute() {
        return d6.rollDice(3, d6);
    }
/**
 * Metod deducts one hitpoint from the character, and checks if the character 
 * has gone to 0 hitpoints
 * 
 * @return boolean depending on if the character is at 0 hp or not
 */
    public boolean takeHit() {
        this.healthPoints--;
        
        if (this.healthPoints <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Character name: " + this.getName() + " | " + "  Health Points: " + this.getHP() + "\n" +
                "Physique: " + this.getPhysique() + "\n" +
                "Agility: " + this.getAgility() + "\n" +
                "Knowledge: " + this.getKnowledge() + "\n" +
                "Willpower: " + this.getKnowledge() + "\n" +
                "Charisma: " + this.getCharisma();
    }
}
