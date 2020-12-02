
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//this class is the template for the game's areas

public class Area implements AreaInterface {
    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private String name;

    public Area() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        
    }
    
//    -----------------------------------------------------------------
//    setters and adders
    
    @Override
    public void setDescription(String story) {
        this.description = story;
    }
    
    @Override
    public void addNeighbour() {
        this.neighbours.add(new Area());
    }
    
    @Override
    public void addEncounter(Encounter encounter) {
        encounters.add(encounter);
    }
        
    @Override
    public void addCommand(String number, String command) {
        this.commands.put(number, command);
    }
    
//    ------------------------------------------------------------------
//    Getters
    
    @Override
    public String getDescription() {
        return this.description;
    }
    
    @Override
    public int getEncountersNumber() {
        return encounters.size();
    }
    
    @Override
    public Map<String, String> getCommands() {
        return this.commands;
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }
    
//    ---------------------------------------------------------------------
    
    @Override
    public Encounter randomEncounter(int number) {
        return encounters.get(number - 1);
    }

    @Override
    public void arrive(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return this.name;

    }
    
    

    
    
}
