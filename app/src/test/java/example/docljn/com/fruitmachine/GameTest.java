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
        ArrayList<Integer> imageReferences = new ArrayList<>();
        imageReferences.add(1);
        imageReferences.add(2);
        imageReferences.add(3);
        imageReferences.add(4);

        game = new Game(3, imageReferences);
    }

    @Test
    public void hasReelSetSizeSetByNumberOfReels(){
        assertEquals(3, game.getReelSet().size());
        //todo: do you need to know the number of reels in the game?
    }

    @Test
    public void canReturnWinLine(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);

        assertEquals(expected, game.getWinLine());
    }


//    TODO: Change from a hardcoded payTable to a logic-based win
    @Test
    public void canCalculateResultFromThreeReelWinLine10s(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(3);
        }
        Integer expected = 600;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void canCalculateResultFromThreeReelWinLine4s(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        Integer expected = 240;
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
