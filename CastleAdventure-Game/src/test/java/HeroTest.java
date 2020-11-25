
import castleadventure.tools.Hero;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HeroTest {
    
    Hero hero;
    
    public HeroTest() {
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
    }
    
    @After
    public void tearDown() {
    }


     @Test
     public void hello() {}
     
     @Test
     public void HeroSetsNameRight(){
         Hero jonne = new Hero("jonne");
         assertEquals("jonne", jonne.getName());
     }
//----------------------------------------------------------------------------
     //Characteristic testers
//----------------------------------------------------------------------------     
     
     @Test
     public void HeroSetsPhysique(){
         assertTrue(hero.getPhysique() <= 18 && hero.getPhysique() >= 3);
     }
     
     @Test
     public void HeroSetsAgility(){
         assertTrue(hero.getAgility() <= 18 && hero.getAgility() >= 3);
     }
     
     @Test
     public void HeroSetsKnowledge(){
         assertTrue(hero.getKnowledge() <= 18 && hero.getKnowledge() >= 3);
     }
     
     @Test
     public void HeroSetsWillpower(){
         assertTrue(hero.getWillpower() <= 18 && hero.getWillpower() >= 3);
     }
     
     @Test
     public void HeroSetsCharisma(){
         assertTrue(hero.getCharisma() <= 18 && hero.getCharisma() >= 3);
     }
//----------------------------------------------------------------------------
     
     
}
