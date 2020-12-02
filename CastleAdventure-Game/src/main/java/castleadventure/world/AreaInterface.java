
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;

//Interface for the different areas of the game map.
public interface AreaInterface {
    public void setDescription(String story);
    public void addNeighbour();
    public void addEncounter(Encounter encounter);
    public void addCommand(String number, String command);
    public String getDescription();
    public int getEncountersNumber();
    public Map<String, String> getCommands();
    public Area getNeighbour(int index);
    public String getName();
    public Encounter randomEncounter(int number);
    public void arrive(Hero hero);
}
