
package castleadventure;

import java.util.Scanner;


public class MainClass {
 
    
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        UserSpace userSpace = new UserSpace(reader);
        userSpace.launch();
    }
}
