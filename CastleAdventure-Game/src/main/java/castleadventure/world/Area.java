/**
 * A template for the game's different areas. Never directly used by itself, but the actual areas extend this class
 */
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
        this.name = "";
        
    }
    
//    -----------------------------------------------------------------
//    setters and adders
    public void setName(String name) {
        this.name = name;
    }
    
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
    
    @Override
    public String getName() {
        return this.name;

    }
    
//    ---------------------------------------------------------------------
    
    /**
     * Method Selects an encounter from the area's encounters
     * 
     * @param number index for the encounter selected
     * @return the selected encounter
     */
    @Override
    public Encounter randomEncounter(int number) {
        return encounters.get(number - 1);
    }

    /**
     * A template for initializing the are for the player character
     * 
     * @param hero player character entering the area
     */
    @Override
    public void arrive(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
    

    
    
}
