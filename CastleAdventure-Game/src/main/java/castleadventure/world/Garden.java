/**
 * Class representing the game play area 'Garden'
 * 
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Garden extends Area implements AreaInterface {
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;

    public Garden() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Garden";
    }    
    
    @Override
    public void addNeighbour() {
        Cortyard cortyard = new Cortyard();
        cortyard.setName("Cortyard");
        this.neighbours.add(cortyard);
        
        Study study = new Study();
        study.setName("Study");
        this.neighbours.add(study);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }
    
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**Placeholder for Garden Description**");
        
        this.addCommand("1", "Explore the winding paths among the overgrown and twisted bushes and trees");
        this.addCommand("2", "Head back to the courtyard");
        if (this.hero.getPass4()) {
            this.addCommand("3", "Enter the study through the vine-covered door");
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
        
        Encounter bushes = new Encounter("As you move past the bushes, you notice they seems somehow off. They are twisted, overgrown and oddly pale, and sinister thorns are growing from plants that should not have ones. Squinting, you think you can make up a large shape amongst the bushes. It seems to be still, maybe a large sack, or possiply an animal", 5, "physique", "agility", "you crouch down and carefully move aside the thorny branches. Slowly digging deeper, you finally move aside on branch, and are greeted by the pale, dead face of a man, thoroughly entangled and wrapped into sinister looking thorny vines. His eyes are wide open in an expression of utmost terror. You startle and back away quickly from the disturbing sight", "", "you slowly back down from the bushes. You do not hear any movement as you leave, and sigh with relief", "", false, "", "Crouch down and take a closer look", "Back down carefully");
        
        Encounter secretDoor = new Encounter("You reach the castle wall. It is covered within a thick coat of twisting vines. They don't seem too strong, but their sickly, wilted branches cover every inch of the wall", 25, "knowledge", "physique", "you inspect the vines closely for a while, and suddenly you can make out an outline of a door. With some effort you clear out the vines, revealing a fine but weathered door from the garden to the study", "Despite staring at the vines for quite a while and even poking trough them, you fail to find out anything interesting", "You rip and tear at the wall of vines, chopping them off with with your sword and pulling them down in carps with just your hands, and in no time, you find a door from behind the plants, from the garden to the study", "The vines are surprisingly tough, and your sword is not as suited to gardening as it is poking holes at people. You tire yourself out before achieving too much progress", false, "", "inspect the vine-covered wall", "hack and rip away the vines");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        
        if (!this.hero.getPass4()) {
            this.addEncounter(secretDoor);
        }
        this.addEncounter(bushes);
    }
}
