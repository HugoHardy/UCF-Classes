import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {
    private double height, weight;
    private BodyMassIndex BmiTest;
    @BeforeEach
    public void init(){
        BmiTest = new BodyMassIndex(height, weight);
    }
    @Test
    public void TestObese(){
        BmiTest = new BodyMassIndex(60, 180);
        assertEquals(35.15, BmiTest.giveBmi());
    }
    @Test
    public void TestOverWeight(){
        BmiTest = new BodyMassIndex(66, 180);
        assertEquals(29.049586776859503, BmiTest.giveBmi());
    }
    @Test
    public void TestNormalWeight(){
        BmiTest = new BodyMassIndex(72, 180);
        assertEquals(24.40972222222222, BmiTest.giveBmi());
    }@Test
    public void testUnderWeight(){
        BmiTest = new BodyMassIndex(84, 180);
        assertEquals(17.933673469387756, BmiTest.giveBmi());
    }
}