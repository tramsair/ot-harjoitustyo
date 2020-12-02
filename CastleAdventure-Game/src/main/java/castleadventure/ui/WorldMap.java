
package castleadventure.ui;

// This class will create and handle the different Areas of the game, and serve
//as the gameplay UI

import castleadventure.tools.Dice;
import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import castleadventure.world.Area;
import castleadventure.world.Cortyard;
import castleadventure.world.Hall;
import castleadventure.world.Meadow;
import java.util.ArrayList;
import java.util.Scanner;

public class WorldMap {
    
    private ArrayList<Area> map;
    
    private Scanner scribe;
    private Dice die;
    private Hero hero;
    private Area currentArea;
    
    public WorldMap(Scanner reader, Dice die) {
        this.scribe = reader;
        this.die = die;
        
    
        System.out.println("");
        System.out.println("Name your character: ");
                
        this.hero = new Hero(scribe.nextLine());
        this.map = new ArrayList<Area>();
        
                
        System.out.println();
        System.out.println(hero);
        System.out.println("");
        
        
        

    }
    
    public void launch() {
        this.buildMap();
        System.out.println("--------------------------------------------------------------------");
        System.out.println("*A placeholder for the Intro*");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("");
        
//        ====================================
//        set up the areas of the game
        for(Area area : this.map) {
            area.addNeighbour();
        }
//        current area starts at Meadow
        this.currentArea = this.map.get(0);
//        ========================================
        
        
        currentArea.arrive(hero);
        
//        Interface starts here
//========================================================================================
        while (true) {
            currentArea.addCommand("x", "Return to Main Menu");
            currentArea.addCommand("c", "View Character");
            
            System.out.println(currentArea.getDescription());
            System.out.println("");
            printCommands(currentArea);
            System.out.println();
            System.out.println("Select Action: ");
            
            String command = scribe.nextLine();
                    
            if (!currentArea.getCommands().keySet().contains(command)) {
                System.out.println("Invalid command");
                printCommands(currentArea);
            }

            if (command.equals("x")) {
                System.out.println("Returning to menu...");
                break;
            }
            
            if (command.equals("1")) {
//                Rolls for random encounter from the location
                Encounter encounter = currentArea.randomEncounter(die.rollDie(currentArea.getEncountersNumber()));
                
                System.out.println(encounter.faceEncounter(scribe, hero, die.rollExplodingDie(20)));
            }
            
            if (command.equals("2")) {
//                moves to the first neighbour on the list
                
                this.move(0);
            
            }
            
            if (command.equals("3")) {
//                moves to the second neighbour on the list
                
                this.move(1);
                
            }

            if (command.equals("c")) {
                System.out.println("_____________________________________________");
                System.out.println(hero);
                System.out.println("_____________________________________________");
                System.out.println("");
            }
        }
    }
//    -----------------------------------------------------------------
    
    //    Prints out the current area's commands
    
    public void printCommands(Area area) {
        for (String key : area.getCommands().keySet()) {
            System.out.println(key + " | " + area.getCommands().get(key));
        }
    }
    
    public void buildMap() {
        this.map.add(new Meadow());
        this.map.add(new Cortyard());
        this.map.add(new Hall());
    }
    
    public void move(int number) {
        for(Area area : this.map){
            if(area.getClass().equals(this.currentArea.getNeighbour(number).getClass())) {
                this.currentArea = area;
                this.currentArea.arrive(hero);
            } else {
                System.out.println("Placeholder indicator Error");
            }
        }
    
    }
}
