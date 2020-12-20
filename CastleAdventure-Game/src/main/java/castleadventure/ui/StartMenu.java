/**
 * The "out-of-Game" menu, handling any actions outside the gameplay
 */
package castleadventure.ui;

import castleadventure.tools.Dice;
import castleadventure.tools.Hero;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class StartMenu {
    
    private Map<String, String> commands;
    private Scanner scribe;
    private boolean shutoff = false;
    
    private Dice die;

    
    
    public StartMenu(Scanner reader) {
        this.scribe = reader;
        this.die = new Dice();

        commands = new TreeMap<>();
        commands.put("x", "Exit");
        
        ArrayList<String> orders = new ArrayList<>();

//      Adds the Main Menu -commands to a list
        orders.add("Throw a D6");
        orders.add("New Game");
        
//        Inserts the command list into the command map
        setCommands(orders);
    }
/**
 * The "main menu", allows player to start a new game, or do other "out-of-game" commands
 */
    public void launch() {
        
        this.printTitle();

//        Placeholder for the Main Menu -interface
        while (!this.shutoff) {
            this.printMenu();
            
            String command = scribe.nextLine();
                   
            this.commandsLoop(command);

        }
    }
       
/**
 * Prints out the available commands
 */    
    public void printCommands() {
        for (String key : commands.keySet()) {
            System.out.println(key + " | " + commands.get(key));
        }
    }
    
 
/**
 * Clears out the current list of commands, and puts in the exit command
 */    
    public void clearCommands() {
        commands.clear();
        commands.put("x", "Exit Game");
    }
    

/**
 * Inserts a list of commands to be used
 */    
    public void setCommands(ArrayList<String> orders) {
        for (String command : orders) {
            commands.put(Integer.toString(commands.size()), command);
        }
    }
    
/**
 * Runs the command loop, offering and solving commands from the user. 
 * 
 * @param command command given by the user
 * 
 */    
    public void commandsLoop(String command) {
                   
//            Error message for invalid commands by user
        if (!commands.keySet().contains(command)) {
            System.out.println("Invalid command");
            printCommands();
        }

        if (command.equals("x")) {
            System.out.println("Good bye");
            this.shutoff = true;
        }
            
        if (command.equals("1")) {
            System.out.println(die.rollDie(6));
        }
            
        if (command.equals("2")) {
            System.out.println("The story begins...");
                
                
//          initializing the game and moving to the gameplay UI
            WorldMap map = new WorldMap(this.scribe, die);
                
            map.launch();
                   
        }
        

    }
    
/**
 * prints out the menu text for the interface
 */    
    public void printMenu() {
        System.out.println("---------");
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("Available commands:");
        printCommands();
            
        System.out.println();
        System.out.println("Choose Command: ");
    }
    
    
/**
 * prints out the title blurp
 */    
    public void printTitle() {
        System.out.println("|*********************************************************************************************************|");
        System.out.println("The Silent Château v1.0");
        System.out.println("|*********************************************************************************************************|");
    }
    

}
