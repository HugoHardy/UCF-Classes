import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {
    @Test
    public void testSquareName(){
        shape shape = new Square(10);
        assertEquals("square", shape.getName());
    }
    @Test
    public void testSquareArea(){
        shape2D shape = new Square(10);
        assertEquals(100, shape.getArea());
    }
    public void testSquareArea2(){
        shape2D shape = new Square(0.5);
        assertEquals(0.25, shape.getArea());
    }

}
