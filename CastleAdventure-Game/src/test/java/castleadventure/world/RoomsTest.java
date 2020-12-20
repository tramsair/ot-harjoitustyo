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
public class RoomsTest {
    
    Rooms rooms;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public RoomsTest() {
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
        rooms = new Rooms();
        
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

    @Test
    public void dungeonSetsAndGetsNeighboursRight() {
        rooms.addNeighbour();
        assertEquals("Hall", rooms.getNeighbour(0).getName());
        assertEquals("Study", rooms.getNeighbour(1).getName());
        assertEquals("Grand Hall", rooms.getNeighbour(2).getName());
        assertEquals("Dungeon", rooms.getNeighbour(3).getName());
    }
    
    @Test
    public void DungeonArrivesRight() {
        rooms.arrive(hero);
        
        assertTrue(rooms.getEncountersNumber() > 0);
        assertFalse(rooms.getDescription() == null);
        assertTrue(rooms.getCommands().size() > 0);
        
    }
}
