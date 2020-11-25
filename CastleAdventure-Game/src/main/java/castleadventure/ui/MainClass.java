
package castleadventure.ui;

import java.util.Scanner;


public class MainClass {
 
    
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        StartMenu userSpace = new StartMenu(reader);
        userSpace.launch();
    }
}
