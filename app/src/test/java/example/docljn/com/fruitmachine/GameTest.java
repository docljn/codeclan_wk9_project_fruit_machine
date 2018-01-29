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
    ArrayList<Symbol> reelSetup;

    HashMap<ArrayList<Integer>, Integer> paytable;


    @Before
    public void before(){
        reelSetup = new ArrayList<>();
        reelSetup.add(Symbol.CLUB);
        reelSetup.add(Symbol.DIAMOND);
        reelSetup.add(Symbol.HEART);
        reelSetup.add(Symbol.SPADE);
        reelSetup.add(Symbol.CLUB);
        reelSetup.add(Symbol.HEART);
        reelSetup.add(Symbol.DIAMOND);
        reelSetup.add(Symbol.HEART);

        paytable = new HashMap<>();
        ArrayList<Integer> jackpot = new ArrayList<>();
        jackpot.add(4);
        jackpot.add(4);
        jackpot.add(4);

        ArrayList<Integer> win1 = new ArrayList<>();
        win1.add(1);
        win1.add(2);
        win1.add(3);

        ArrayList<Integer> win2 = new ArrayList<>();
        win2.add(1);
        win2.add(1);
        win2.add(1);

        ArrayList<Integer> win3 = new ArrayList<>();
        win3.add(2);
        win3.add(2);
        win3.add(2);

        ArrayList<Integer> win4 = new ArrayList<>();
        win4.add(3);
        win4.add(3);
        win4.add(3);


        paytable.put(jackpot, 200);
        paytable.put(win1, 100);
        paytable.put(win2, 50);
        paytable.put(win3, 40);
        paytable.put(win4, 20);


//        gameSetup = new HashMap<>();
//        gameSetup.put(paytable, reelSetup);


        game = new Game(3, reelSetup, paytable);
    }

    @Test
    public void hasReelSetSizeSetByNumberOfReels(){
        assertEquals(3, game.getReelSet().size());
        //todo: do you need to know the number of reels in the game?
    }

    @Test
    public void canReturnWinLine(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(2);
        expected.add(2);

        assertEquals(expected, game.getWinLine());
    }

    @Test
    public void canCalculateResultFromWinLine(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(4);
        }

        Integer expected = 40;

        assertEquals(expected, game.getWinnings());

    }

    @Test
    public void canRecordPlayerCredits(){
        Integer expected = 0;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void canChangePlayerCredits(){
        Integer expected = 100;
        game.changePlayerCredits(100);
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void playReducesPlayerCredits(){
        game.changePlayerCredits(100);
        game.play();
        Integer expected = 80;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void playRequiresMinimumCredit(){
        game.play();
        Integer expected = 0;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void playSpinsReels(){
        game.changePlayerCredits(100);
        game.play();
        //todo: how to actually test this?
    }




}
