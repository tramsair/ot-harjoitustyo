
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
    private boolean GameOver;
    
    public WorldMap(Scanner reader, Dice die) {
        this.scribe = reader;
        this.die = die;
        this.GameOver = false;
        
    
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
        while (!this.GameOver) {
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
                
                this.challenge(encounter);
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
    
//    Previous for the encounters
    public void printActions(Encounter challenge) {
        for (String key : challenge.getCommands().keySet()) {
            System.out.println(key + " | " + challenge.getCommands().get(key));
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
    
    public void challenge(Encounter challenge){
        
        Encounter encounter = currentArea.randomEncounter(die.rollDie(currentArea.getEncountersNumber()));
        System.out.println(encounter.getDescription());
        
        System.out.println("What do you do? ");
        System.out.println("");
        this.printActions(challenge);
            
        
//        interface takes players choice of action
        while (true) {
            
            String command = scribe.nextLine();
        
            
            if (!challenge.getCommands().keySet().contains(command)) {
                System.out.println("Invalid command");
                
            } else {
            
                if(challenge.isDeadly()) {
                    System.out.println(challenge.faceDeadlyEncounter(hero, this.die.rollExplodingDie(20), command));
                    if(this.hero.getHP() <= 0){
                        this.GameOver = true;
                    }
                    break;
                } else {
                    System.out.println(challenge.faceEncounter(hero, this.die.rollExplodingDie(20), command));
                    break;
                }
            }
            
            
        }
                
        
        
    }
}
