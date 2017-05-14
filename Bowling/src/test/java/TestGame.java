
import org.junit.Test;

import static org.junit.Assert.*;
public class TestGame {
    @Test
    public void testScoreNoThrows(){
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.getScore());
    }

}
