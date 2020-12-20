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
        
        this.setDescription("**Placeholder for Grand Hall Description**");
        
        this.addCommand("1", "Explore area");
        this.addCommand("2", "Exit through the gate");
        this.addCommand("3", "Enter through the main doors");
        if (this.hero.getKeyKitchen()) {
            this.addCommand("4", "Enter through the side door");
        }
        
//        Fill encounter in order: description, difficulty, attribute, other Attribute, 
//            positive outcome, negative outcome, otherPositive, otherNegative, 
//            is it deadly?, death message(leave empty if not deadly), action one, action two two
        
        Encounter thing2 = new Encounter("placeholder description", 25, "physique", "agility", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", true, "you are dead", "fight", "run away");
        
        Encounter thing = new Encounter("placeholder description2 ", 25, "charisma", "willpower", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", false, "", "convincea", "intimidate");
        

        this.addEncounter(thing);
        this.addEncounter(thing2);
    }


    
    
}
