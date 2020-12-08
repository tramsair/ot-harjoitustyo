package castleadventure.tools;



import castleadventure.tools.Dice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class DiceTest {
    
    Dice die;
    
    public DiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        die = new Dice();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void DiceRollRightSize(){
        int i = 1;
        while(i <= 10){
            int x = die.rollDie(20);
            assertTrue(x <= 20 && x > 0);
            
            i++;
        }
    }
    
    @Test
    public void MultiDiceRollRightSize(){
        int i = 1;
        while(i <= 1000){
            int x = die.rollDice(3, die);
            assertTrue(x <= 18 && x >= 3);
            
            i++;
        }
    }
    
    @Test
    public void ExplodingDieNonZero(){
        int i = 1;
        while(i <= 10){
            int x = die.rollExplodingDie(20);
            assertTrue(x > 0);
            
            i++;
        }
    }
    
    
}
