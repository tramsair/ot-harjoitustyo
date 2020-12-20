/**
 * Class representing the Rooms gameplay area
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Rooms extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public Rooms() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Rooms";
    }

    
    @Override
    public void addNeighbour() {

        Hall hall = new Hall();
        hall.setName("Hall");
        this.neighbours.add(hall);
        
        Study study = new Study();
        study.setName("Study");
        this.neighbours.add(study);
        
        GrandHall grandHall = new GrandHall();
        grandHall.setName("Grand Hall");
        this.neighbours.add(grandHall);
        
        Dungeon dungeon = new Dungeon();
        dungeon.setName("Dungeon");
        this.neighbours.add(dungeon);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Rooms Description**");
        
        this.addCommand("1", "Search through the silent halls of the quest rooms and living quarters");
        this.addCommand("2", "Take the main door back to the main hallway");
        this.addCommand("3", "Go through the parlor and head to the study and library");
        this.addCommand("4", "Head past the master's quarters and go to the Grand hall");
        this.addCommand("r", "Rest for a while in one of the quest rooms. Gather your wits and tend to your wounds");
        if (this.hero.getPass2()) {
            this.addCommand("5", "Open the secret passage to the dungeon in the master's quarters");
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
        
        Encounter thing2 = new Encounter("You  find the master's quarters. There is an eerie atmosphere and a peculiar smell within", 20, "intelligence", "agility", "The quarters have been ransacked, junk and clothes strewn all around. However, while going trough one of the larger cabinets, you notice it has a hollow back board. You swiftly remove it, and discover stairs down, it appears to be a secret passage from the rooms to the dungeon", "You search around the room, but soon notice it has been ransacked. Cupboards are emptied and bed has been dug trough, even the mattress has been sliced. You find nothing remarkable, other than a handful of some ritual tools that smell strange", "You turn around and leave the rooms alone", "You turn around and leave the rooms alone", false, "", "Poke around and look for clues", "Back away from the quarters");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        
        if (!this.hero.getPass2()) {
            this.addEncounter(thing2);
        }
    }
    
    
}
