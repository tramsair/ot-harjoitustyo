
package castleadventure.world;

import castleadventure.tools.Encounter;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//this class is the template for the game's areas

public class Area{
    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;

    public Area(){
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
    }
    
//    -----------------------------------------------------------------
//    setters and adders
    
    public void setDescription(String story){
        this.description = story;
    }
    
    public void addNeighbour(Area area){
        this.neighbours.add(area);
    }
    
        public void addEncounter(Encounter encounter){
        encounters.add(encounter);
    }
        
        public void addCommand(String number, String command){
            this.commands.put(number, command);
        }
    
//    ------------------------------------------------------------------
//    Getters
    
    public String getDescription(){
        return this.description;
    }
    
    public int getEncountersNumber(){
        return encounters.size();
    }
    
    public Map<String, String> getCommands(){
        return this.commands;
    }
    
    public Area getNeighbour(int index){
        return this.neighbours.get(index);
    }
    
//    ---------------------------------------------------------------------
    
    public Encounter randomEncounter(int number){
        return encounters.get(number - 1);
    }
    

    
    
}
