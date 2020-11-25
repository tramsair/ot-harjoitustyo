
package castleadventure.ui;

// This class will create and handle the different Areas of the game, and serve
//as the gameplay UI

import castleadventure.tools.Dice;
import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import castleadventure.world.Area;
import java.util.Scanner;

public class WorldMap {
    
    private Area meadow;
    private Area cortyard;
    
    private Scanner scribe;
    private Dice die;
    private Hero hero;
    
    public WorldMap(Scanner reader, Hero hero, Dice die){
        this.scribe = reader;
        this.hero = hero;
        this.die = die;
        
//        Area meadow gets built
//===================================================================================================================
        this.meadow = new Area();
        meadow.setDescription("**Placeholder for Meadow Description**");
        
        meadow.addCommand("1" ,"Explore area");
        meadow.addCommand("2", "Enter trough the gate");
        
        Encounter thing = new Encounter("placeholder encounter", 25, "agility", "positive placeholder", "negative placeholder");
        Encounter thing2 = new Encounter("placeholder encounter1", 25, "agility", "positive placeholder1", "negative placeholder1");
        meadow.addEncounter(thing);
        meadow.addEncounter(thing2);
//---------------------------------------------------------------------------------------------------------------
//      Area "cortyard" is built
//===================================================================================================================
        this.cortyard = new Area();
        cortyard.setDescription("**Placeholder for Cortyard Description**");
    
        cortyard.addCommand("1" ,"Explore area");
        cortyard.addCommand("2", "Exit trough the gate");
        
        Encounter test = new Encounter("placeholder encounter2", 25, "physique", "positive placeholder2", "negative placeholder2");
        Encounter test2 = new Encounter("placeholder encounter3", 25, "physique", "positive placeholder3", "negative placeholder3");
        cortyard.addEncounter(test);
        cortyard.addEncounter(test2);
//---------------------------------------------------------------------------------------------------------------
//          Neighbours are set
//==================================================================================
        meadow.addNeighbour(cortyard);
        cortyard.addNeighbour(meadow);
    
    }
    
    public void launch(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("*A placeholder for the Intro*");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("");
        
        
//        current area starts at Meadow
        Area currentArea = this.meadow;
        
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
                
                System.out.println(encounter.faceEncounter(hero, die.rollDie(20)));
            }
            
            if (command.equals("2")) {
//                moves to the first neighbour on the list
                currentArea = currentArea.getNeighbour(0);
            }
            
            if (command.equals("3")) {
                
            }
            
            if (command.equals("4")) {
                
            }
            
            if (command.equals("5")) {
                
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
    
    public void printCommands(Area area){
        for (String key : area.getCommands().keySet()){
            System.out.println(key + " | " + area.getCommands().get(key));
        }
    }
}
