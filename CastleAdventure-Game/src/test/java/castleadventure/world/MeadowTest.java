/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
import castleadventure.world.Cortyard;
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
public class MeadowTest {
    
    Meadow meadow;
    Encounter test;
    Encounter test2;
    Hero hero;

    
    public MeadowTest() {
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
        meadow = new Meadow();
        
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
        meadow.addNeighbour();
        assertEquals("Cortyard", meadow.getNeighbour(0).getName());
    }
    
    @Test
    public void meadowArrivesRight() {
        meadow.arrive(hero);
        
        assertTrue(meadow.getEncountersNumber() > 0);
        assertFalse(meadow.getDescription() == null);
        assertTrue(meadow.getCommands().size() > 0);
        
    }
}
