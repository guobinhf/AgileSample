
import org.junit.Test;

import static org.junit.Assert.*;
public class TestGame {
    @Test
    public void testOneThrows(){
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.getScore());
    }

    @Test public void testTowThrowsNoMark(){
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.getScore());
    }
    @Test public void testFourThrowsNoMark(){
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.getScore());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }

}
