
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Meadow extends Area implements AreaInterface {
    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;

    public Meadow() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Meadow";
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
        
        this.setDescription("**Placeholder for Meadow Description**");
        
        this.addCommand("1", "Explore area");
        this.addCommand("2", "Enter trough the Gate");
        
        Encounter thing = new Encounter("placeholder encounter", 25, "agility", "positive placeholder", 
                "negative placeholder", "option2", "option2");
        Encounter thing2 = new Encounter("placeholder encounter1", 25, "agility", "positive placeholder1", 
                "negative placeholder1", "option2", "option2");
        this.addEncounter(thing);
        this.addEncounter(thing2);
        
    }


    
    
}    

