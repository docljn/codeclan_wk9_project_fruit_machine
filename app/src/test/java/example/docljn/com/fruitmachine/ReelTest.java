package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import example.docljn.com.fruitmachine.JavaLogic.Reel;
import example.docljn.com.fruitmachine.JavaLogic.Symbol;

import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class ReelTest {

    Reel reel;
    Symbol symbols;
    Symbol alternativeSymbols;

    @Before
    public void before(){
        reel = new Reel(11, symbols, 2);
    }

    @Test
    public void getsNumberOfStops(){
        assertEquals(11, reel.getNumberOfStops());
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
        reel.setImageLookupTable(alternativeSymbols);
        assertEquals(alternativeSymbols, reel.getImageLookupTable());
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

    @Test
    public void getsVisibleStopWhichStartsAtZero(){
        assertEquals(0, reel.getVisibleStop());
    }

    @Test
    public void setsVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(3, reel.getVisibleStop());
    }


}


/*
@Test - should apply to GAME not REEL
    public void getsPayTableReference(){
        assertEquals(1, reel.getImageLookupTable());
    }
 */
