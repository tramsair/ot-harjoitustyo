/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package castleadventure.world;

import castleadventure.tools.Encounter;
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
public class AreaTest {
    
    Area area;
    Encounter test;
    Encounter test2;
    
    public AreaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        area = new Area();
        
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
    public void areaSetsAndGetsDescriptionRight() {
        area.setDescription("test");
        
        assertEquals("test", area.getDescription());
    }
    
    public void areaAddsAndGetsEncountersRight() {
        area.addEncounter(test);
        area.addEncounter(test2);
        
        assertEquals(2, area.getEncountersNumber());
    }
}
