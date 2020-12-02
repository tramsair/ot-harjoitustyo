
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Cortyard extends Area implements AreaInterface{
    
    
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
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Cortyard Description**");
        
        this.addCommand("1", "Explore area");
        this.addCommand("2", "Exit through the gate");
        
        Encounter thing = new Encounter("placeholder encounter", 25, "agility", "positive placeholder2", "negative placeholder2");
        Encounter thing2 = new Encounter("placeholder encounter1", 25, "agility", "positive placeholder3", "negative placeholder3");
        this.addEncounter(thing);
        this.addEncounter(thing2);
        
    }


    
    
}    

