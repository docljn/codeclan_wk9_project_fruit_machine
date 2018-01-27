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
        reel = new Reel(11, 1, 2);
    }

    @Test
    public void getsNumberOfStops(){
        assertEquals(11, reel.getNumberOfStops());
    }

    @Test
    public void getsImageLookupTableReference(){
        assertEquals(1, reel.getImageLookupTable());
    }

    @Test
    public void getsReelSetupReference(){
        assertEquals(2, reel.getSetupReference());

    }

    @Test
    public void getsHeldStatusFalseAtStart(){
        assertEquals(false, reel.getHeld());
    }


    @Test
    public void setsNumberOfStops(){
        reel.setNumberOfStops(9);
        assertEquals(9, reel.getNumberOfStops());
    }


    @Test
    public void setsImageLookupTable(){
        reel.setImageLookupTable(4);
        assertEquals(4, reel.getImageLookupTable());
    }

    @Test
    public void setsHeldStatus(){
        reel.setHeld(true);
        assertEquals(true, reel.getHeld());
    }

    @Test
    public void setsSetUpReference(){
        reel.setSetupReference(1);
        assertEquals(1, reel.getSetupReference());
    }

    
}
