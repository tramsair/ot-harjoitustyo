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
public class GrandHallTest {
    
    GrandHall Ghall;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public GrandHallTest() {
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
        Ghall = new GrandHall();
        
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
    public void GrandHallSetsAndGetsNeighboursRight() {
        Ghall.addNeighbour();
        assertEquals("Hall", Ghall.getNeighbour(0).getName());
        assertEquals("Rooms", Ghall.getNeighbour(1).getName());
        assertEquals("Kitchens", Ghall.getNeighbour(2).getName());
        assertEquals("Dungeon", Ghall.getNeighbour(3).getName());
        assertEquals("the Tower", Ghall.getNeighbour(4).getName());
    }
    
    @Test
    public void GrandHallArrivesRight() {
        Ghall.arrive(hero);
        
        assertTrue(Ghall.getEncountersNumber() > 0);
        assertFalse(Ghall.getDescription() == null);
        assertTrue(Ghall.getCommands().size() > 0);
        
    }
}
