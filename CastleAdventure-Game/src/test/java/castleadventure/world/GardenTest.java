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
public class GardenTest {
    
    Garden garden;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public GardenTest() {
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
        garden = new Garden();
        
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
        garden.addNeighbour();
        assertEquals("Cortyard", garden.getNeighbour(0).getName());
        assertEquals("Study", garden.getNeighbour(1).getName());
    }
    
    @Test
    public void DungeonArrivesRight() {
        garden.arrive(hero);
        
        assertTrue(garden.getEncountersNumber() > 0);
        assertFalse(garden.getDescription() == null);
        assertTrue(garden.getCommands().size() > 0);
        
    }
}
