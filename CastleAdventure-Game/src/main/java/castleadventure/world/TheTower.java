/**
 * Class representing the The Tower gameplay area which is also the end game.
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class TheTower extends Area implements AreaInterface {

    
    String description;
    private ArrayList<Area> neighbours;
    private ArrayList<Encounter> encounters;
    private Map<String, String> commands;
    private Hero hero;
    private String name;
    
    public TheTower() {
        this.description = "";
        this.encounters = new ArrayList();
        this.commands = new TreeMap<>();
        this.neighbours = new ArrayList();
        this.hero = new Hero("");
        this.name = "Tower";
    }

    
    
    @Override
    public Area getNeighbour(int index) {
        return this.neighbours.get(index);
    }


//    Builds and prepares the area
    @Override
    public void arrive(Hero hero) {
        this.hero = hero;
        
        
        this.setDescription("You open the complex lock with the key, and open the door to the stairwell. Immediately you hear strange sounds and see glimmer in colours you have never seen before. Furrowing our brow, you step forwards and start to climb the stairs. Every step takes you further from the reality, as the dark, closed, winding staircase slowly transforms around you. The walls start to behave strangely, the geometries not adding up. The stairs themselves start to change too, the distance between steps fluctuating, sometimes feeling like every step you take lasts a mile, other times you feel you are moving backwards. You keep your eyes front, and definitely away from your feet. In time, the walls brake away, pieces floating around you. And outside, it is not the meadow. You cant describe it, and do your best not to look directly at it.\n" +
"\n" +
"The climb feels like it takes days, and it might. You are becoming confident the very fabric of time is unravelling around you. But you make it to the door. The door, it takes you by surprise. A normal, wooden door, in the middle of pure elemental chaos. With a shaking hand, you reach for the handle, and open it. Behind, is a deceivingly mundane looking tower room. It is dim and dusty, littered with clothes and parchments. You step inside, and close the door behind you. A silence immediately grips you, silence you did not even realise was missing anymore. you glance around the room, avoiding looking at the middle as long as you can. Heavy velvet curtains, closed. Candles and other curios, on the floor and on the tables. Large bed, messy and unmade. A centimetre of dust on everything.\n" +
"\n" +
"You draw your breath and finally look at the middle of the room. There is an intricate octagram, surrounded with long burnt-out candles and valuable ritual tools. And in the middle of the squiggly lines and arcane texts, on a simple wooden stool, sits an older woman, eyes closed, still and silent. Sadness in your eyes, you look at her. The moment stretches, until finally, with a long sigh, you reach to your bag and pull out the three-bladed dagger. With determined steps, you stride across the room, across the arcane runes and circles of power. You step next to the woman, and with only a moment's hesitation, sink the dagger to her heart. There is no sound, all seems stand still. And them, everything lurches and twists. Stone brakes. Glass shatters. Air boils and textiles rot as the suspended reality rushes back to fill the void left by the disappeared madness. \n" +
"\n" +
"Fin");       
        
        

    }


    
    
}
