
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Hall extends Area implements AreaInterface {
    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;

    public Hall() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Hall";
    }    
    
    @Override
    public void addNeighbour() {
        this.neighbours.add(new Cortyard());
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Hall Description**");
        
        this.addCommand("1", "Explore area");
        this.addCommand("2", "Exit through the Doors");
        
        Encounter thing = new Encounter("placeholder description", 25, "physique", "agility", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", true, "you are dead", "fight", "run away");
        Encounter thing2 = new Encounter("placeholder description2", 25, "charisma", "willpower", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", false, "", "convince", "intimidate");
        
        this.addEncounter(thing);
        this.addEncounter(thing2);
        
    }


    
    
}    

