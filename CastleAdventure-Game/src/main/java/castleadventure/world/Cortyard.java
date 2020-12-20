/**
 * Class representing the Cortyard gameplay area
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Cortyard extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public Cortyard() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Cortyard";
    }

    
    @Override
    public void addNeighbour() {
        Meadow meadow = new Meadow();
        meadow.setName("Meadow");
        this.neighbours.add(meadow);
        
        Hall hall = new Hall();
        hall.setName("Hall");
        this.neighbours.add(hall);
        
        Garden garden = new Garden();
        garden.setName("Garden");
        this.neighbours.add(garden);
        
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
        
        this.setDescription("**The Courtyard is surprisingly big. It is roughly oval-shaped, with plantings along the walls. "
                + "The yard is hard stomped dirt. There are two doors into the castle interior; the "
                + "main double doors, and the unassuming small door to the common folk quarters. The servants quarters "
                + "'doors seems to be locked. A heavy stench of death, and something indescribable, is floating "
                + "in the air. Lot of the stench seems to be coming from the dark stables, which doors are hanging wide open**");
        
        this.addCommand("1", "Poke around and search the courtyard");
        this.addCommand("2", "Exit the courtyard trough the gate, back to the meadow");
        this.addCommand("3", "Head in through the large double doors");
        this.addCommand("4", "Pass under the small gate, into the twisted, maze-like garden");
        if (this.hero.getKeyKitchen()) {
            this.addCommand("5", "Use the rusty key to enter through the unassuming side door, into the servants' quarters");
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
        
        Encounter bushes = new Encounter("As you move past the plantings, you notice they seems somehow off. They are overgrown and still oddly pale, and odd thorns are growing from plants that should not have ones. Squinting, you think you can make up a large shape amongst the bushes. It seems to be still, maybe a large sack", 5, "physique", "agility", "you crouch down and carefully move aside the thorny branches. Slowly digging deeper, you finally move aside on branch, and are greeted by the pale, dead face of a man, thoroughly entangled and wrapped into sinister looking thorny vines. His eyes are wide open in an expression of utmost terror. You startle and back away quickly from the disturbing sight", "", "you slowly back down from the bushes. You do not hear any movement as you leave, and sigh with relief", "", false, "", "Crouch down and take a closer look", "Back down carefully");
        
        Encounter meatBlob = new Encounter("You enter the the garage and stables, and the stench indeed seems to get stronger. You see no signs of life for quite a bit, until you suddenly notice large stains of splashes, and some kinds of lumps in front of you on the floor. Rising you lantern, you see the lumps look like pieces of slimy rotten beef. Except they are slowly pulsating, and... moving across the floor. Turning your head around, you realise there are now several behind you too. Looking for an escape route, you spot a coat fit for a noble hanging from a chair, amongst the blobs in front of you", 5, "physique", "agility", "You catch a broom leaning against the wall and charge the several blobs in front of you. Gripping the broom firmly, you push and sweep the slimy, pulsating nodules of rot from your way, succeeding fairly well. You make it to the chair and catch the jacket, before dashing forwards. Your broom snaps on the last blob, which you instead just leap over and sprint out of the stables. Going trough the jacket, you find fine key from the pocket. It has a picture of a book engraved into it, maybe it is for a study or a library", "you charge and aim a strong kick on the closest blob in your way, but your foot just sinks into the slimy nodule. Panicking, you fall down. You feel the slime seep trough your boot and pants as the slime starts to envelop your leg, and soon the wet feeling changes to a stinging pain. grasping around you catch a broom from the floor besides you, and manage to push the blob out of your leg, before scampering to your feet. With the help of the broom, you manage to escape, though your leg and pants are left slightly melted from the caustic touch of the meat-slime", "Daftly you turn on your heels and dash out to the courtyard before the slimes manage to corner you off", "you turn on your heel,s but the blobs are faster than they look. You try to jump over the couple now blocking your way, but another drops from the ceiling, hitting you on the back. It drops off, but the slime it leaves behind burns as it dissolves trough your clothes, onto your skin", true, "You try to make it trough the approaching blobs of slimy meat, but you catch your foot into one of them and fall. You struggle, you another catches your arm within it. Terror spreads on your mind, as you realize one hanging from the roof above you. It drops down right on your face, and everything goes black, as the slimy, rotten blob of meat suffocates you", "Try to get trough the ones in front and get the coat", "Attempt to dash back before you get surrounded");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        
        if (!this.hero.getKeyStudy()) {
            this.addEncounter(meatBlob);
        }
        this.addEncounter(bushes);
    }


    
    
}
