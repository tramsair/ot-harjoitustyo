/**
 * Class representing the Grand Hall gameplay area
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class GrandHall extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public GrandHall() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "GrandHall";
    }

    
    @Override
    public void addNeighbour() {

        Hall hall = new Hall();
        hall.setName("Hall");
        this.neighbours.add(hall);
        
        Rooms rooms = new Rooms();
        rooms.setName("Rooms");
        this.neighbours.add(rooms);
        
        Kitchens kitchens = new Kitchens();
        kitchens.setName("Kitchens");
        this.neighbours.add(kitchens);
        
        Dungeon dungeon = new Dungeon();
        dungeon.setName("Dungeon");
        this.neighbours.add(dungeon);
        
        TheTower tower = new TheTower();
        tower.setName("the Tower");
        this.neighbours.add(tower);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**The Grand Hall. Place of many generous feasts and opulent gatherings. Even within its fading state, the high ceiling and the large pillars command awe. But something is very wrong. Light does not seem to work as it should, the darkness swallowing it way too quickly. And the geometry of the hall feels wrong, the angles misaligned, and twisted inwards. And within the darkness, there are sounds and  steps. Like the members of the last feast still wandering about the Grand Hall.**");
        
        this.addCommand("1", "Carefully inspect the dark corners and abandoned tables of the grand hall");
        this.addCommand("2", "Head back to the main hallway, thorough the large double doors");
        this.addCommand("3", "Take the door on the left to the rooms and living quarters");
        this.addCommand("4", "Pass trough the inconspicuous door on the right and enter the kitchens");
        if (this.hero.getPass3()) {
            this.addCommand("5", "push aside the hollow statue at the alcove on the left, and take the secret passage beneath to the dungeon");
        }
        if (this.hero.getKeyTower()) {
            this.addCommand("6", "Open the lock on the heavy door at the back of the grand hall, and ascend the spiral staircase to the broken tower");
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
        
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        

    }
    
    
}
