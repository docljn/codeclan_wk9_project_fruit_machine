package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.JavaLogic.Reel;
import example.docljn.com.fruitmachine.JavaLogic.Symbol;

import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class GameTest {


    Game game;
    ArrayList<Symbol> setup;

    HashMap<ArrayList<Integer>, Integer> paytable;


    @Before
    public void before(){
        setup = new ArrayList<>();
        setup.add(Symbol.CLUB);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);
        setup.add(Symbol.SPADE);
        setup.add(Symbol.CLUB);
        setup.add(Symbol.HEART);
        setup.add(Symbol.DIAMOND);
        setup.add(Symbol.HEART);

        paytable = new HashMap<>();
        ArrayList<Integer> jackpot = new ArrayList<>();
        jackpot.add(4);
        jackpot.add(4);
        jackpot.add(4);

        paytable.put(jackpot, 10);

//        gameSetup = new HashMap<>();
//        gameSetup.put(paytable, setup);


        game = new Game(3, setup, paytable);
    }

    @Test
    public void hasReelSetSizeSetByNumberOfReels(){
        assertEquals(3, game.getReelSet().size());
    }

    @Test
    public void canReturnWinLine(){
        ArrayList<Symbol> expected = new ArrayList<>();
        expected.add(Symbol.CLUB);
        expected.add(Symbol.CLUB);
        expected.add(Symbol.CLUB);

        assertEquals(expected, game.getWinLine());
    }

    @Test
    public void canCalculateResultFromWinLine(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(4);
        }

        Integer expected = 10;

        assertEquals(expected, game.getWinnings());

    }


}
