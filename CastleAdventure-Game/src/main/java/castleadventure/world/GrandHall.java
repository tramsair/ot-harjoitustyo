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
        
        Encounter thing2 = new Encounter("placeholder description", 25, "physique", "agility", 
                "placeholder success", "placeholder failure", "placeholder other success", 
                "placeholder other failure", true, "you are dead", "fight", "run away");
        
        Encounter thing = new Encounter("placeholder description kitchen key ", 25, "charisma", "willpower", 
                "placeholder success kitchen key", "placeholder failure", "placeholder other success", 
                "placeholder other failure", false, "", "convince(get the key)", "intimidate");
        
        if (!this.hero.getKeyKitchen()) {
            this.addEncounter(thing);
        }
        this.addEncounter(thing2);
    }
    
    
}
