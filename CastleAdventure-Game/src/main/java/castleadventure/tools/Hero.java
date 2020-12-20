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
    private boolean keyKitchen;
    private boolean keyStudy;
    private boolean keyTower;
    private boolean pass1;
    private boolean pass2;
    private boolean pass3;
    private boolean pass4;
    
    public Hero(String name) {
        this.agility = rollAttribute();
        this.charisma = rollAttribute();
        this.knowledge = rollAttribute();
        this.physique = rollAttribute();
        this.willpower = rollAttribute();
        
        this.healthPoints = 10;
        this.name = name;
    }
    
    
   
    
//------------------------------------------------------------------------------
//          Getters and setters
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
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHp(int hp) {
        this.healthPoints = hp;
    }
    
    public void setPhysique(int number) {
        this.physique = number;
    }
    
    public void setAgility(int number) {
        this.agility = number;
    }
    
    public void setKnowledge(int number) {
        this.knowledge = number;
    }
    
    public void setWillpower(int number) {
        this.willpower = number;
    }
    
    public void setCharisma(int number) {
        this.charisma = number;
    }
    
    public void setKeyKitchen(boolean key) {
        this.keyKitchen = true;
    }
    
    public void setKeyStudy(boolean key) {
        this.keyStudy = true;
    }
    
    public void setKeyTower(boolean key) {
        this.keyTower = true;
    }
    
    public void setPass1(boolean pass) {
        this.pass1 = pass;
    }
    
    public void setPass2(boolean pass) {
        this.pass2 = pass;
    }
    
    public void setPass3(boolean pass) {
        this.pass3 = pass;
    }
    
    public void setPass4(boolean pass) {
        this.pass4 = pass;
    }
    
    public boolean getKeyKitchen() {
        return this.keyKitchen;
    }
    
    public boolean getKeyStudy() {
        return this.keyStudy;
    }
    
    public boolean getKeyTower() {
        return this.keyTower;
    }
    
    public boolean getPass1() {
        return this.pass1;
    }
    
    public boolean getPass2() {
        return this.pass2;
    }
    
    public boolean getPass3() {
        return this.pass3;
    }
    
    public boolean getPass4() {
        return this.pass4;
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
 * Method deducts one hitpoint from the character, and checks if the character 
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
