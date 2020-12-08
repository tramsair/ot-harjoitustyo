/**
 * This class will create and handle the different Areas of the game, and serve
 * as the gameplay UI
 */
package castleadventure.ui;



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
    private boolean gameOver;
    private boolean run;
    
/**
 * The constructor for the main in-game UI. It also creates the player character, 
 * naming it according to input from the user and prints out the ready character.
 */    
    
    public WorldMap(Scanner reader, Dice die) {
        this.scribe = reader;
        this.die = die;
        this.gameOver = false;
        
        System.out.println("");
        System.out.println("Name your character: ");
                
        this.hero = new Hero(scribe.nextLine());
        this.map = new ArrayList<Area>();
               
        System.out.println();
        System.out.println(hero);
        System.out.println("");
    }
    
    
/**
 * Starts the main in-game interface which takes orders from the user and solves 
 * them. Also allows for return to the "main menu", or returns the user there 
 * automatically if "game over" is reached.
 */    
    public void launch() {
        this.initializeGame();
        
//        Interface starts here
//========================================================================================
        while (!this.gameOver) {
            currentArea.addCommand("x", "Return to Main Menu");
            currentArea.addCommand("c", "View Character");
        
            System.out.println(currentArea.getDescription());
            System.out.println("");
            printCommands(currentArea);
            System.out.println();
            System.out.println("Select Action: ");
        
            String command = scribe.nextLine();
            
            this.launchLoop(command);
        }
//    -----------------------------------------------------------------
    }
    
/**
 * Method generates the game world and places the player character in the first 
 * area.
 */
    public void initializeGame() {
        this.buildMap();
        
        this.printIntro();
        
//        ====================================
//        set up the areas of the game
        for (Area area : this.map) {
            area.addNeighbour();
        }
//        current area starts at Meadow
        this.currentArea = this.map.get(0);
//        ========================================
        
        
        currentArea.arrive(hero);
    }
    
/**
 * Method prints out the commands available on the area the player character is at.
 */
    public void printCommands(Area area) {
        for (String key : area.getCommands().keySet()) {
            System.out.println(key + " | " + area.getCommands().get(key));
        }
    }
    
/**
 * Method prints out the commands available for the player regarding facing the 
 * current encounter
 */
    public void printActions(Encounter challenge) {
        for (String key : challenge.getCommands().keySet()) {
            System.out.println(key + " | " + challenge.getCommands().get(key));
        }
    }
    
/**
 * Method prints out the intro of the game
 */
    public void printIntro() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("*A placeholder for the Intro*");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("");
    }
    
/**
 * Method Prints out the character sheet of the player character
 * 
 * @param hero the player character
 */
    public void showCharacter(Hero hero) {
        System.out.println("_____________________________________________");
        System.out.println(hero);
        System.out.println("_____________________________________________");
        System.out.println("");
    }
    
/**
 * Method adds the different game areas into the list that consists of the game's
 * "map".
 */
    public void buildMap() {
        this.map.add(new Meadow());
        this.map.add(new Cortyard());
        this.map.add(new Hall());
    }
    
  
//    Moves the active area to the indicated neighbour #BUG NOTE: For some reason
//    it is currently impossible to move back to the Meadow area.
/**
 * Method moves the active area to the indicated neighbour
 * #BUG NOTE: For yet unkown reason the method does not allow mowing back to the 
 * first area, "Meadow"
 * 
 * @param number input from the user, specifies to which of the neighboring areas 
 * the player character moves
 */
    public void move(int number) {
        for (Area area : this.map) {
            if (area.getClass().equals(this.currentArea.getNeighbour(number).getClass())) {
                
//  Rolls for a random chance to face and encounter on the way to new area
                if (this.die.rollDie(6) == 1) {
                    Encounter encounter = currentArea.randomEncounter(die.rollDie(currentArea.getEncountersNumber()));
                
                    this.challenge(encounter);
                }
                this.currentArea = area;
                this.currentArea.arrive(hero);
            } else {
//      Developement indicator that the program goes trough the list properly
                System.out.println("Placeholder indicator Error");
            }
        }
    
    }
    
/**
 * Selects and solves an encounter from the current area against the player character
 * 
 * @param challenge the Encounter the player character is facing.
 */    
    public void challenge(Encounter challenge) {
        
        System.out.println("What do you do? ");
        System.out.println("");
        this.printActions(challenge);
        
        this.run = true;
        
//        interface takes players choice of action
        while (run == true) {
            
            this.challengeLoop(challenge);
            
        }   
    }
    
/**
 * Method asks user for a command and solves the encounter accordingly
 * 
 * @param challenge the encounter currently being faced by the player character 
 */    
    public void challengeLoop(Encounter challenge) {
        
        String command = scribe.nextLine();
        
        if (!challenge.getCommands().keySet().contains(command)) {
            System.out.println("Invalid command");
                
        } else {
            
            if (challenge.isDeadly()) {
                System.out.println(challenge.faceDeadlyEncounter(hero, this.die.rollExplodingDie(20), command));
                if (this.hero.getHP() <= 0) {
                    this.gameOver = true;
                }
                this.run = false;
            } else {
                System.out.println(challenge.faceEncounter(hero, this.die.rollExplodingDie(20), command));
                this.run = false;
            }
        }
    }

/**
 * Method is the loop that forms the core of the in-game menu and interface, 
 * resolving commands given by the user
 * @param command user's command regarding on the proceeding within the game
 */
    public void launchLoop(String command) {
        
                    
//            Error message for invalid commands by user
        if (!currentArea.getCommands().keySet().contains(command)) {
            System.out.println("Invalid command");
            
        } else if (command.equals("x")) {
            System.out.println("Returning to menu...");
            this.gameOver = true;
            
        } else if (command.equals("1")) {
//            Rolls for random encounter from the location
            Encounter encounter = currentArea.randomEncounter(die.rollDie(currentArea.getEncountersNumber()));
                
            this.challenge(encounter);
        } else if (command.equals("2")) {
//            moves to the first neighbour on the list
                
            this.move(0);
            
        } else if (command.equals("3")) {
//            moves to the second neighbour on the list
                
            this.move(1);
                
        } else if (command.equals("c")) {
            this.showCharacter(hero);
        }
    }
}
