/**
 * Class representing the first gameplay area, the one the player character starts from
 */
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
        Cortyard cortyard = new Cortyard();
        cortyard.setName("Cortyard");
        this.neighbours.add(cortyard);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Twilight surrounds the hill around the castle-manor, even during daytime. A long, rough grass has grown up to waist everywhere. Occasional barn or shack could be seen on the meadow surrounding the Castle, were it not for the thick clouds of fog, moving erratically and unnaturally despite almost complete lack of wind. On top of the shallow hill stands the Castle manor, its main tower radiating the sinister darkness surrounding the meadow, and frozen in mid-collapse, the fragments stretched upwards towards the sky, suspended unnaturally**");
        
        this.addCommand("1", "Survey the area surrounding the castle-manor");
        this.addCommand("2", "Head to the main gate, and enter the courtyard");
        this.addCommand("r", "Lay down at your camp for a bit, tend to your wounds and rest");
        
        this.encounterSetter();
        
    }

    /**
     * Method to set the encounters of the area
     */
    public void encounterSetter() {
//        Fill encounter in order: description, difficulty, attribute, other Attribute, 
//            positive outcome, negative outcome, otherPositive, otherNegative, 
//            is it deadly?, death message(leave empty if not deadly), action one, action two two
        
        
        String success = "As you approach the shadow, it turns out to be a barn after all. Slumped down and grey with age, but a barn. You head inside, and discover a motionless servant girl from the old hay. She has seemingly passed away on her sleep, but her lips and fingernails are jet black. You find a rusty servants key from her pockets. It must be for the castle kitchen";
        Encounter keyBarn = new Encounter("wading amongst the rolling fog, you suddenly make dark shape from the mist in front of you, large as a barn.", 25, "charisma", "willpower", success, success, "Silently, you kneel amongst the tall grass and back away from the looming dark shape. It does not follow after you", "Silently, you kneel amongst the tall grass and back away from the looming dark shape. It does not follow after you", false, "", "Approach the shape carefully", "Back away, without making a sound");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        
        if (!this.hero.getKeyKitchen()) {
            this.addEncounter(keyBarn);
        }
    }
    
    
}    

