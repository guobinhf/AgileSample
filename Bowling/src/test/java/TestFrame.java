
import org.junit.Test;

import static org.junit.Assert.*;
public class TestFrame {
    @Test
    public void testScoreNoThrows(){
        Frame f = new Frame();
        f.add(5);
        assertEquals(5, f.getScore());
    }

}
