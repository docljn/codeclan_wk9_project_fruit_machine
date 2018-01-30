package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.JavaLogic.Reel;
import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class GameTest {


    Game game;
    ArrayList<Integer> imageReferences;

    @Before
    public void before(){
        imageReferences = new ArrayList<>();
        imageReferences.add(1);
        imageReferences.add(2);
        imageReferences.add(3);
        imageReferences.add(4);

        game = new Game(3);
    }

    @Test
    public void hasReelSetSizeSetByNumberOfReels(){
        assertEquals(3, game.getReelSet().size());
    }

    @Test
    public void canReturnWinLine(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(0);
        expected.add(0);

        assertEquals(expected, game.getWinLine());
    }


    @Test
    public void canCalculateResultFromThreeReelWinLine10s(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(3);
        }
        Integer expected = 300;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void canCalculateResultFromThreeReelWinLine4s(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        Integer expected = 120;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void canCalculateResultFromFiveReelWinLine4s(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        Integer expected = 200;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void NoWinIfFirstTwoOutOfThreeTheSame() {
        ArrayList<Reel> reels = game.getReelSet();
        for (Reel reel : reels) {
            reel.setVisibleStop(2);
        }
        reels.get(2).setVisibleStop(3);
        System.out.println(reels.get(2).getVisibleStop());
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void NoWinIfLastTwoOutOfThreeTheSame() {
        ArrayList<Reel> reels = game.getReelSet();
        for (Reel reel : reels) {
            reel.setVisibleStop(2);
        }
        reels.get(0).setVisibleStop(3);
        System.out.println(reels.get(2).getVisibleStop());
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }


    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopOne(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        game.getReelSet().get(0).setVisibleStop(0);
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopTwo(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        game.getReelSet().get(1).setVisibleStop(0);
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopThree(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        game.getReelSet().get(2).setVisibleStop(0);
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopFour(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        game.getReelSet().get(3).setVisibleStop(0);
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopFive(){
        game = new Game(5);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        game.getReelSet().get(4).setVisibleStop(0);
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }


    @Test
    public void canRecordPlayerCredits(){
        Integer expected = 100;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void canChangePlayerCredits(){
        Integer expected = 200;
        game.changePlayerCredits(100);
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test @Ignore("This will only work if there are no winnings.")
    public void playReducesPlayerCredits(){
        game.changePlayerCredits(100);
        game.play();
        Integer expected = 80;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void playRequiresMinimumCredit(){
        game.changePlayerCredits(-100);
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

    @Test
    public void getsNumberOfReels(){
        Integer expected = 3;
        assertEquals(expected, game.getNumberOfReels());
    }

    @Test
    public void playerWinningsIncreasesCredits(){
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
            reel.setHoldable(true);
            reel.setHeld(true);
        }  // sets up reels so they will not change on play, hence giving a predictable winning amount of 120
        game.play();
        Integer expected = 200;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void getsGameCost(){
        Integer expected = 20;
        assertEquals(expected, game.getGameCost());
    }




}
