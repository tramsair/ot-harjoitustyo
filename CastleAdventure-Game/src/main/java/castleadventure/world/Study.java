/**
 * Class representing the Study, or Library gameplay area
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Study extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public Study() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Study";
    }

    
    @Override
    public void addNeighbour() {

        Hall hall = new Hall();
        hall.setName("Hall");
        this.neighbours.add(hall);
        
        Rooms rooms = new Rooms();
        rooms.setName("Rooms");
        this.neighbours.add(rooms);
        
        Garden garden = new Garden();
        garden.setName("Garden");
        this.neighbours.add(garden);
    }
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        this.setDescription("**The study is a massive library, split into more open study spaces and the cramped archives, a labyrinth of shelves and dusty books. Sounds of steps and rustling of pages occasionally echo around the surprisingly cold halls, and you swear some of the books are shivering on the shelves when you are not looking**");
        
        this.addCommand("1", "Search the dusty, dark maze of bookshelves for information and knowledge");
        this.addCommand("2", "Exit the library back to the main hall");
        this.addCommand("3", "Go through the side door and enter the living quarters and quest rooms");
        if (this.hero.getPass4()) {
            this.addCommand("4", "take the hidden door to the garden");
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
        
        Encounter thing2 = new Encounter("You come across a table with writing supplies strewn across it, couple of books, and a stack of what look like journal papers. The journal is in a strange language however, or at least written in a very weird way, or dialect.", 25, "intelligence", "willpower", "You manage to infer from the other books, that this is a research journal of some kind, on matters that should not be touched by human hands. It mentions some kind of deity, who is supposed to be the gate an pathway to underworld, although the context in the journal would suggest that you are literally supposed to go under them to go down. You think there are some statues in the grand hall. And maybe down means that there is a dungeon somewhere here", "placeholder failure", "placeholder other success", "placeholder other failure", false, "you are dead", "Inspect the books and try to figure out the journal with them", "Read trough the journal and try to figure out if it is written in some kind of code");
        
        Encounter thing = new Encounter("You accidentally knock onto the shelf, and a heavy book drops from the shelf. It opens from the middle as it hits the floor, and it text catches your eyes. Literally. You cant turn away your gaze.", 25, "willpower", "charisma", "You start reading the book. The text does not make sense on language level, but still, knowledge starts to flow into your mind. Terrible knowledge, not meant for mortal minds. With massive strain of willpower you rip your eyes off of the sinister text, before your mind is overtaken by the cosmic dread and madness. Hands in front of your eyes, you stumble away from the book", "You start reading the book. The text does not make sense on language level, but still, knowledge starts to flow into your mind. Terrible knowledge, not meant for mortal minds.", "You start to read the text. It makes not sense, but you feel a alien presence flooding into your mind. Leaning into your strong sense of self you start to push back against the invader. Slowly, you stop the invasion, and start pushing them out of your mind, bit by bit, until finally, you suddenly wake from the trance, and notice, you are keeled on the floor, hand on the closed cover of the book. Slowly, you back down and away from the book, careful to not look at it directly, but not daring to to turn your back to it", "A bloodcurdling scream escapes from your throat as the dread of aeons seeps into your mind. You cant turn away your eyes, but with the fading clarity of your mind, you throw yourself at the bookshelf next to you. You hit your head against the wood painfully, and the shelf breaks, dropping a dozen heavy books on your head. The pain finally makes your eyes close. Your lids now tightly in front of your eyes, you crawl away from the sinister text, feeling a warm drip of blood flowing from your scalp after the painful impact", true, "you start reading the book. The text does not make sense on language level, but still, knowledge starts to flow into your mind. Terrible knowledge, not meant for mortal minds. You cant take your eyes off of the text, yet you can feel your mind shattering as it tries to refuse the eldritch knowledge. You start to slip away, and from the distance, you hear a horrifying scream. It is yours, and you scream, and scream, as your mind crumbles under the weight of the cosmic presence...", "convince(get the key)", "intimidate");
        
        Encounter thing3 = new Encounter("Walking amongst the dusty shelves, you notice some of loose papers stuffed amongst the books", 20, "charisma", "agility", "The writing is shaky and contains lots of misspellings and use of dialect. It is probably a diary of sorts, belonging to a servant of the house. With some difficulty, you wade trough the mundane and notice that there is a repeating mention about a secret passage, from the kitchens to the dungeon, through the lardy", "Try to make sense of the text, but it is badly written, both in handwriting and quality. What little you can understand describes mundane chores", "You leave the papers to be and continue on your way", "You leave the papers to be and continue on your way", false, "", "inspect the papers", "leave the papers alone");
        
        if (!this.hero.getKeyKitchen()) {
            this.addEncounter(thing);
        }
        this.addEncounter(thing2);
        this.addEncounter(thing3);
    }
    
    
}
