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
        
        this.setDescription("**The cold, rough stone walls of the hidden dungeon glisten with condensation, As sighs and wails still echo trough the halls. Lines and lines of heavy cell doors with wide view-ports with bars fill the dungeon, and outside, several rooms that are are equipped to look like something between a hospital operation room, torture chamber and witch doctor's den. Remains of experiments lay around those rooms, details visible on them too gruesome to describe**");
        
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
        

        
        Encounter thing = new Encounter("You skulk amongst the dark halls of the Dungeon, when you hear a whisper from one of the cells: \"Come closer, I have something you need\". You inch closer to the door, noting that it is still, seemingly firmly, shackled from this side. You peek trough the view-port and see a tall, bony figure with long greasy hair slumped against the back wall. It raises one of its hands, showing a key. \"It is for the tower. Let me out, and it is yours.\"", 30, "physique", "charisma", "You unshackle the door and open it. The figure continues to lay against the back wall, gesturing with the key. You carefully step closer, your hand on your sword. And for a good reason. As you reach for the key, the bony, lanky figure lunges at you, like a puppet yanked up by its strings. It lashes at you with its elongated fingernails, and now standing up, it towers over a head above you. You dodge and weave, receiving glancing blows, and dealing shallow cuts. The figure cackles as it slashes around. You are beginning to tire, when you spot your change. Lunging forwards beneath its attacks, you drive your sword up into its chest cavity, all the way to the hilt. With a almost peaceful sigh, they slump forwards onto you in a morbid embrace, before you dump them to the ground. You quickly find the key for the tower, and hurry out of the grisly cell. Just now you noticed the walls were covered in strange runes, and you think they were starting to squirm.", "You unshackle the door and open it. The figure continues to lay against the back wall, gesturing with the key. You carefully step closer, your hand on your sword. And for a good reason. As you reach for the key, the bony, lanky figure lunges at you, like a puppet yanked up by its strings. It lashes at you with its elongated fingernails, and now standing up, it towers over a head above you. You dodge and weave, receiving glancing blows, and dealing shallow cuts. The figure cackles as it slashes around. You are beginning to tire, and at a critical moment, you slip on something on the floor. With a murderous grin, the figure rushes onto you. He slashes your face and pummels you against the stone floor, before effortlessly lifting you up and hurling you against a wall. Your sight is filled with stars, but you realize you are now right next to the door. You roll out of the door and shakily slam it shut, sliding the chackle back as a furious howl starts sounding from the cell. You can hear several steps closing in from the depths of the dungeon, and decide to hurry away to lick your wounds", "You recognise the voice. It is your cousin, you spent the long summers of your childhood with them. You call them by the name. After a long silence, you can hear silent sob, completely unfitting for the grotesque form. They rise up, slowly and painfully, They are mumbling a incoherent litany of apologies and laments as they step to the door. \"It is too late for us. It is our fault. End it. Climb to the tower...\" They extend their hand, handing out the key to you. Carefully you catch the key from their spidery fingers. You step away from the door, giving a one last glance at the figure, standing in the darkness, silent and still now.", "You recognise the voice. It is your cousin, you spent the long summers of your childhood with them. You call them by the name. After a long silence, they stand up, slowly stretching up, standing several heads taller than you. They step to the door, extending the key towards you. You reach to take it, as they grab your arm lightning fast and yank you against the bars on the view-port. You hit your head, and you think your shoulder got dislocated. The figure spits and hisses at you \"It is too late! One of us now, you will never leave, no one will!\" You draw your sword and manage to poke the thing's face with it, getting it to release your arm. You stumble back from the door, hearing steps closing in from deeper the dungeon, and decide to run to fix your shoulder", true, "The figure moves faster than you can comprehend, and grabs you by the throat. They pull you closer to their hair-covered face, a humourless smile spreading to their lips, revealing a monstrous, sharp set of teeth. They start to slowly squeeze, twisting your neck backwards, while whispering \"welcome home, cousin\"", "Open the door, but prepared for a scuffle", "You think you recognise the voice.. try to convince them to give the key freely");
        
        Encounter shambler = new Encounter("You hear the a screeching wailing, and soon spot a humanoid shape. The humanoid tumbles around erratically, twitching occasionally and lashing out against the air", 20, "physique", "agility", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. They lunge at you, but you dodge them deftly, and run them trough with your sword. Silently, they slump on the ground", "You draw your sword and approach the erratic humanoid. Seen closer, it appears they may have been a human once, but now they are twisted, their face distorted by madness and something supernatural. You strike at them, but with uprising speed they jump aside and strike at you with a short blade they had hidden in their sleeve. You grimace and manage to stick your sword into them after all, bringing them down.", "You press down you head and sneak away without a sound, leaving the humanoid to wail in peace", "You try to sneak away, but the humanoid hears you. With shocking agility, they sprint to you, tackling you down. They grab your head, hitting it on the ground repeatedly before you manage to stick them whit your sword. They slump off of you, and you scamper up, a trickle of blood flowing down the back of your head", true, "The speed of the raving humanoid takes you completely off guard, as they tackle you on the ground and sit on your back. Crooked, bony fingers wrap around your throat, and slowly, the life is squeezed out of you", "attempt to slay the shambler", "try to sneak away");
        this.addEncounter(shambler);
        this.addEncounter(shambler);
        
        if (!this.hero.getKeyTower()) {
            this.addEncounter(thing);
        }
    }
    
    
}
