package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import example.docljn.com.fruitmachine.JavaLogic.Reel;

import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class ReelTest {

    Reel reel;

    @Before
    public void before(){
        reel = new Reel(11);
    }

    @Test
    public void getsNumberOfStops(){
        assertEquals(11, reel.getNumberOfStops());
    }
}
