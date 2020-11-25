
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
    
    private Dice die;

    
    
    public StartMenu(Scanner reader) {
        this.scribe = reader;
        this.die = new Dice(6);

        commands = new TreeMap<>();
        commands.put("x", "Exit");
        
        ArrayList<String> orders = new ArrayList<>();

//      Adds the Main Menu -commands to a list
        orders.add("Throw a D6");
        orders.add("New Game");
        
//        Inserts the command list into the command map
        setCommands(orders);
    }
    
    public void launch(){
        
        System.out.println("|*********************************************************************************************************|");
        System.out.println("Welcome to CastleAdventure(working name) interface test preliminary iteration alfa-minus-minus, v0,0002");
        System.out.println("|*********************************************************************************************************|");

        
//        Placeholder for the Main Menu -interface
        while (true) {
            System.out.println("---------");
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("Available commands:");
            printCommands();
            
            System.out.println();
            System.out.println("Choose Command: ");
            
            String command = scribe.nextLine();
                    
            if (!commands.keySet().contains(command)) {
                System.out.println("Invalid command");
                printCommands();
            }

            if (command.equals("x")) {
                System.out.println("Good bye");
                break;
            }
            
            if (command.equals("1")) {
                System.out.println(die.rollDie(6));
            }
            
            if (command.equals("2")) {
                System.out.println("The story begins...");
                System.out.println("");
                System.out.println("Name your character: ");
                
                Hero hero = new Hero(scribe.nextLine());
                
                System.out.println();
                System.out.println(hero);
                System.out.println("");
                
//                initializing the game
                WorldMap map = new WorldMap(this.scribe, hero, die);
                
                map.launch();
                   
            }

        }
    }
    
//    Prints out the available commands
    
    public void printCommands(){
        for (String key : commands.keySet()){
            System.out.println(key + " | " + commands.get(key));
        }
    }
    
//    Clears out the current list of commands, and puts in the exit command
    
    public void clearCommands(){
        commands.clear();
        commands.put("x", "Exit Game");
    }
    
//    Inserts a list of commands to be used
    
    public void setCommands(ArrayList<String> orders){
        for(String command : orders){
            commands.put(Integer.toString(commands.size()), command);
        }
    }
    

}
