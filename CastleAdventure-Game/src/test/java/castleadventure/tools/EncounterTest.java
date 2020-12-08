/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package castleadventure.tools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class EncounterTest {
    
    Hero hero;
    Encounter test;
    Encounter test2;
    
    public EncounterTest() {
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
    public void heroWinsDeadly() {
        assertEquals("success", test.faceDeadlyEncounter(hero, 25, "1"));
        assertEquals("other success", test.faceDeadlyEncounter(hero, 25, "2"));
    }
    
    @Test
    public void heroWinsNonDeadly() {
        assertEquals("success", test2.faceDeadlyEncounter(hero, 25, "1"));
        assertEquals("other success", test2.faceDeadlyEncounter(hero, 25, "2"));
    }
    
    @Test
    public void heroLosesDeadly() {
        hero.setHp(100);
        
        assertEquals("failure", test.faceDeadlyEncounter(hero, 0, "1"));
        assertEquals("other failure", test.faceDeadlyEncounter(hero, 0, "2"));
    }
    
    @Test
    public void heroLosesNonDeadly() {
        assertEquals("failure", test2.faceEncounter(hero, 0, "1"));
        assertEquals("other failure", test2.faceEncounter(hero, 0, "2"));
    }
    
    @Test
    public void heroLosesHitPointsOnLoss() {
        int hp = hero.getHP();
        
        test.faceDeadlyEncounter(hero, 0, "1");
        assertTrue(hero.getHP() < hp);
    }
    
    @Test
    public void returnsDeathMessageOnZeroHp() {
        hero.setHp(1);
        
        assertEquals("you are dead", test.faceDeadlyEncounter(hero, 0, "1"));
    }
    
    @Test
    public void encounterReturnsIsDeadlyCorrectly() {
        assertEquals(true, test.isDeadly());
        assertEquals(false, test2.isDeadly());
    }
    
    @Test
    public void encounterReturnsDescription() {
        assertEquals("description", test.getDescription());
        assertEquals("description2", test2.getDescription());
    }
    

}
