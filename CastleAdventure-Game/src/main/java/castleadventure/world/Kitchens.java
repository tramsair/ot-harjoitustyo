/**
 * Class representing the game play area of 'Kitchens'
 * 
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Kitchens extends Area implements AreaInterface {
 
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;

    public Kitchens() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Kithcens";
    }    
    
    @Override
    public void addNeighbour() {
        Cortyard cortyard = new Cortyard();
        cortyard.setName("Cortyard");
        this.neighbours.add(cortyard);
        
        Hall hall = new Hall();
        hall.setName("Hall");
        this.neighbours.add(hall);
        
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
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Kitchen Description**");
        
        this.addCommand("1", "Search the kitchens and the servants quarters for clues and something useful");
        
        if (this.hero.getKeyKitchen()) {
            this.addCommand("2", "Exit out to the courtyard via the side door");
        }
        
        this.addCommand("3", "Go through the servants' quarters to the main hallway");
        this.addCommand("4", "Head through the kitchen and enter the Grand hall");
        if (this.hero.getPass1()) {
            this.addCommand("5", "Take the secret passage from the servant's quarters to the Dungeon");
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
