/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.tools.Hero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mato
 */
public class HallTest {
    
    Hall hall;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public HallTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        hero = new Hero("McMoose");
        hall = new Hall();
        
        test = new Encounter("description", 25, "physique", "agility", 
                "success", "failure", "other success", 
                "other failure", true, "you are dead", "fight", "run away");
        test2 = new Encounter("description2", 25, "charisma", "willpower", 
                "success", "failure", "other success", 
                "other failure", false, "", "convince", "intimidate");
    }
    
    @After
    public void tearDown() {
    }


    // @Test
    // public void hello() {}
    
    @Test
    public void meadowSetsAndGetsNeighboursRight() {
        hall.addNeighbour();
        assertEquals("Cortyard", hall.getNeighbour(0).getName());
    }
    
    @Test
    public void meadowArrivesRight() {
        hall.arrive(hero);
        
        assertTrue(hall.getEncountersNumber() > 0);
        assertFalse(hall.getDescription() == null);
        assertTrue(hall.getCommands().size() > 0);
        
    }
}
