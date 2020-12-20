/**
 * Class representing the Dungeon gameplay area which is hidden before discovery
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Dungeon extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public Dungeon() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Dungeon";
    }

    
    @Override
    public void addNeighbour() {
        
        Rooms rooms = new Rooms();
        rooms.setName("Rooms");
        this.neighbours.add(rooms);
        
        GrandHall grandHall = new GrandHall();
        grandHall.setName("Grand Hall");
        this.neighbours.add(grandHall);
        
        Kitchens kitchens = new Kitchens();
        kitchens.setName("Kitchens");
        this.neighbours.add(kitchens);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Dungeon Description**");
        
        this.addCommand("1", "Explore the bleak cells and halls of the dungeon, and the sinister instruments scattered within");
        if (this.hero.getPass2()) {
            this.addCommand("2", "Take the secret passage to the master's quarters");
        }
        if (this.hero.getPass3()) {
            this.addCommand("3", "Climb the ladder to the secret passage to grand hall");
        }
        if (this.hero.getPass1()) {
            this.addCommand("4", "Go through the secret door to the lardy, at the kitchens");
        }
        
        this.encounterSetter();
    }


        /**
     * Method to set the encounters of the area
     */
    public void encounterSetter() {
//        Fill encounter in order: description, difficulty, attribute, other Attribute, 
//            positive outcome, negative outcome, otherPositive, otherNegative, 
//            is it deadly?, death message(leave empty if not deadly), action one, action two two
        
        Encounter thing2 = new Encounter("placeholder description", 25, "physique", "agility", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", true, "you are dead", "fight", "run away");
        
        Encounter thing = new Encounter("placeholder description kitchen key ", 25, "charisma", "willpower", 
                "placeholder success kitchen key", "placeholder failure", "placeholder other success", 
                "placeholder other failure", false, "", "convince(get the key)", "intimidate");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        
        if (!this.hero.getKeyKitchen()) {
            this.addEncounter(thing);
        }
        this.addEncounter(thing2);
    }
    
    
}
