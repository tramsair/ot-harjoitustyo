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
public class KitchensTest {
    
    Kitchens kithcen;
    Encounter test;
    Encounter test2;
    Hero hero;
    
    public KitchensTest() {
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
        kithcen = new Kitchens();
        
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
        kithcen.addNeighbour();
        assertEquals("Cortyard", kithcen.getNeighbour(0).getName());
        assertEquals("Hall", kithcen.getNeighbour(1).getName());
        assertEquals("Grand Hall", kithcen.getNeighbour(2).getName());
        assertEquals("Dungeon", kithcen.getNeighbour(3).getName());
    }
    
    @Test
    public void DungeonArrivesRight() {
        kithcen.arrive(hero);
        
        assertTrue(kithcen.getEncountersNumber() > 0);
        assertFalse(kithcen.getDescription() == null);
        assertTrue(kithcen.getCommands().size() > 0);
        
    }
}
