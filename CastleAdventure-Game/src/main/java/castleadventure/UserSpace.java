
package castleadventure;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class UserSpace {
    
    private Map<String, String> commands;
    private Scanner scribe;
    
    private Dice die;
    
    public UserSpace(Scanner reader) {
        this.scribe = reader;
        this.die = new Dice(6);

        commands = new TreeMap<>();

        commands.put("x", "Exit");
        commands.put("1", "Throw a D6");
        commands.put("2", "Create a character");
    }
    
    public void launch(){
        
        System.out.println("|*********************************************************************************************************|");
        System.out.println("Welcome to CastleAdventure(working name) interface test preliminary iteration alfa-minus-minus, v0,0002");
        System.out.println("|*********************************************************************************************************|");
        System.out.println("Available commands:");
        printCommands();
        
        while (true) {
            System.out.println();
            System.out.println("Choose Command: ");
            
            String command = scribe.nextLine();
                    
            if (!commands.keySet().contains(command)) {
                System.out.println("Invalid command");
                printCommands();
            }

            if (command.equals("x")) {
                break;
            }
            
            if (command.equals("1")) {
                System.out.println(die.rollDie());
            }
            
            if (command.equals("2")) {
                System.out.println("Name your character: ");
                
                Hero hero = new Hero(scribe.nextLine());
                
                System.out.println();
                System.out.println(hero);
            }

        }
    }
    
    public void printCommands(){
        for (String key : commands.keySet()){
            System.out.println(key + " | " + commands.get(key));
        }
    }
    

}
