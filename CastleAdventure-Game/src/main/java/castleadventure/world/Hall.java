/**
 * Class representing the Hall gameplay area
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Hall extends Area implements AreaInterface {
    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;

    public Hall() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Hall";
    }    
    
    @Override
    public void addNeighbour() {
        Cortyard cortyard = new Cortyard();
        cortyard.setName("Cortyard");
        this.neighbours.add(cortyard);
        
        Study study = new Study();
        study.setName("Study");
        this.neighbours.add(study);
        
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
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**The main hallways are dark and echoy, lined with small pillars and alcoves, and peppered with side passages. There is an eerie hum in the air, and occasionally you can hear echoes of steps, mumbling and screams, sometimes human, sometimes inhuman.**");
        
        this.addCommand("1", "Search through the shady alcoves and side-passages");
        this.addCommand("2", "Exit back to the courtyard");
        
        if (this.hero.getKeyStudy()) {
            this.addCommand("3", "Enter the Library trough the doors on your left");
        }
        
        this.addCommand("4", "Head to the quest rooms and living quarters trough the second door on the left");
        this.addCommand("5", "Continue straight forwards to the grand hall, trought the second set of large double doors");
        this.addCommand("6", "Enter the kitchen and the servants' quarters trough the plain door on the right");
        
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

