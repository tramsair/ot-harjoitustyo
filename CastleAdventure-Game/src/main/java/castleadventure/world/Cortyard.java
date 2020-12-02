
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Cortyard extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public Cortyard() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Cortyard";
    }

    
    @Override
    public void addNeighbour() {
        this.neighbours.add(new Meadow());
        this.neighbours.add(new Hall());
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Cortyard Description**");
        
        this.addCommand("1", "Explore area");
        this.addCommand("2", "Exit through the gate");
        this.addCommand("3", "Enter through the main doors");
        
        Encounter thing = new Encounter("placeholder encounter", 25, "agility", "positive placeholder2", 
                "negative placeholder2", "option2", "option2");
        Encounter thing2 = new Encounter("placeholder encounter1", 25, "agility", "positive placeholder3", 
                "negative placeholder3", "option2", "option2");
        this.addEncounter(thing);
        this.addEncounter(thing2);
    }


    
    
}
