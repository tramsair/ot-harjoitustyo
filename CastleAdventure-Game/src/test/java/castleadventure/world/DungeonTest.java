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
public class DungeonTest {
    
    Dungeon dungeon;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public DungeonTest() {
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
        dungeon = new Dungeon();
        
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
        dungeon.addNeighbour();
        assertEquals("Rooms", dungeon.getNeighbour(0).getName());
        assertEquals("Grand Hall", dungeon.getNeighbour(1).getName());
        assertEquals("Kitchens", dungeon.getNeighbour(2).getName());
    }
    
    @Test
    public void DungeonArrivesRight() {
        dungeon.arrive(hero);
        
        assertTrue(dungeon.getEncountersNumber() > 0);
        assertFalse(dungeon.getDescription() == null);
        assertTrue(dungeon.getCommands().size() > 0);
        
    }
}
