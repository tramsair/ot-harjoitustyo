
package castleadventure;


public class Hero {
    
    private int healthPoints;
    private int physique;
    private int agility;
    private int knowledge;
    private int willpower;
    private int charisma;
    private String name;
    private Dice D6 = new Dice(6);
    
    public Hero(String name){
        this.agility = rollAttribute();
        this.charisma = rollAttribute();
        this.knowledge = rollAttribute();
        this.physique = rollAttribute();
        this.willpower = rollAttribute();
        
        this.healthPoints = 10;
        this.name = name;
    }
    
    
    
    
//------------------------------------------------------------------------------
//          Getters
//------------------------------------------------------------------------------    
    
    
    public int getPhysique(){
        return this.physique;
    }
    
    public int getAgility(){
        return this.agility;
    }
    
    public int getKnowledge(){
        return this.knowledge;
    }
    
    public int getWillpower(){
        return this.willpower;
    }
    
    public int getCharisma(){
        return this.charisma;
    }
    
    public int getHP(){
        return this.healthPoints;
    }
    
    public String getName(){
        return this.name;
    }
    
//              Getters end
//==============================================================================    
    
    public int rollAttribute(){
        return D6.rollDice(3, D6);
    }
    
    public String toString(){
        return "Character name: " + this.getName() + "  Health Points: " + this.getHP() + "\n" +
                "Physique: " + this.getPhysique() + "\n" +
                "Agility: " + this.getAgility() + "\n" +
                "Knowledge: " + this.getKnowledge() + "\n" +
                "Willpower: " + this.getKnowledge() + "\n" +
                "Charisma: " + this.getCharisma();
    }
}
