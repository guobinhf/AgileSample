
import org.junit.Test;

import static org.junit.Assert.*;
public class TestFrame {
    @Test
    public void testScoreNoThrows(){
        Frame f = new Frame();
        assertEquals(0, f.getScore());
    }

}
