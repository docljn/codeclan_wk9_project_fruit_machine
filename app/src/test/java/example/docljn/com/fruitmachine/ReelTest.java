package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import example.docljn.com.fruitmachine.JavaLogic.Reel;
import example.docljn.com.fruitmachine.JavaLogic.Symbol;

import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class ReelTest {

    Reel reel;
    ArrayList<Symbol> setup;
    ArrayList<Symbol> alternativeSetup;

    @Before
    public void before(){
        setup = new ArrayList<>();
        setup.add(Symbol.CLUB);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);
        setup.add(Symbol.SPADE);
        setup.add(Symbol.CLUB);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);
        setup.add(Symbol.HEART);
        reel = new Reel(setup, 2);
    }

    @Test
    public void getsNumberOfStopsDefaultIsEight(){
        assertEquals(8, reel.getNumberOfStops());
    }



    @Test
    public void getsReelReturnLevel(){
        assertEquals(2, reel.getReturnLevel());

    }

    @Test
    public void getsHeldStatusFalseAtStart(){
        assertEquals(false, reel.getHeld());
    }



    @Test
    public void setsReelSetup(){
        reel.setSetup(alternativeSetup);
        assertEquals(alternativeSetup, reel.getSetup());
    }


    @Test
    public void setsReturnLevel(){
        reel.setReturnLevel(1);
        assertEquals(1, reel.getReturnLevel());
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

    @Test
    public void stopBeforeFromVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(2, reel.getStopBefore());
    }

    @Test
    public void stopAfterFromVisibleStop(){
        reel.setVisibleStop(3);
        assertEquals(4, reel.getStopAfter());
    }

    @Test
    public void stopCountIsCircularDownwards(){
        reel.setVisibleStop(0);
        assertEquals(7, reel.getStopBefore());
    }

    @Test
    public void stopCountIsCircularUpwards(){
        reel.setVisibleStop(7);
        assertEquals(0, reel.getStopAfter());
    }

    @Test
    public void reelCanOnlyBeHeldIfHoldableTrue(){
        reel.setHeld(true);
        assertEquals(false, reel.getHeld());
    }

    @Test
    public void setsHeldStatus(){
        reel.setHoldable(true);
        reel.setHeld(true);
        assertEquals(true, reel.getHeld());
    }

    @Test
    public void setVisibleStopIsCircular(){
        reel.setVisibleStop(24);
        assertEquals(0, reel.getVisibleStop());
    }

    @Test
    public void setVisibleStopCopesWithNegatives(){
        reel.setVisibleStop(-1);
        assertEquals(7, reel.getVisibleStop());
    }




}


/*
@Test - should apply to GAME not REEL
    public void getsPayTableReference(){
        assertEquals(1, reel.getImageLookupTable());
    }
 */
