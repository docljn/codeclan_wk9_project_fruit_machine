package example.docljn.com.fruitmachine;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.JavaLogic.Reel;
import static org.junit.Assert.assertEquals;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class GameTest {


    Game game;
    HashMap<Integer, Integer> cardImages;
    HashMap<Integer, Integer> fruitImages;

    @Before
    public void before(){
        cardImages = new HashMap<>();
        cardImages.put(1, R.drawable.club);
        cardImages.put(2, R.drawable.diamond);
        cardImages.put(3, R.drawable.heart);
        cardImages.put(5, R.drawable.spade);

        fruitImages = new HashMap<>();
        fruitImages.put(1, R.drawable.cherry);
        fruitImages.put(2, R.drawable.lemon);
        fruitImages.put(3, R.drawable.watermelon);
        fruitImages.put(5, R.drawable.seven);

        game = new Game(3, cardImages);
    }

    @Test
    public void hasReelSetSizeSetByNumberOfReels(){
        assertEquals(3, game.getReelSet().size());
    }

    @Test
    public void canReturnWinLine(){
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);

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
        Integer expected = 180;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void canCalculateResultFromFiveReelWinLine4s(){
        game = new Game(5, cardImages);
        ArrayList<Reel> reels = game.getReelSet();
        for(Reel reel:reels){
            reel.setVisibleStop(2);
        }
        Integer expected = 300;
        assertEquals(expected, game.getWinnings());
    }

    @Test
    public void NoWinIfFirstTwoOutOfThreeTheSame() {
        ArrayList<Reel> reels = game.getReelSet();
        for (Reel reel : reels) {
            reel.setVisibleStop(2);
        }
        reels.get(2).setVisibleStop(3);
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
        Integer expected = 0;
        assertEquals(expected, game.getWinnings());
    }


    @Test
    public void noWinIfFourOutOfFiveTheSameChangedStopOne(){
        game = new Game(5, cardImages);
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
        game = new Game(5, cardImages);
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
        game = new Game(5, cardImages);
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
        game = new Game(5, cardImages);
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
        game = new Game(5, cardImages);
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
        }  // sets up reels so they will not change on play, hence giving a predictable winning amount of 180
        game.play();
        Integer expected = 260;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void getsGameCost(){
        Integer expected = 20;
        assertEquals(expected, game.getGameCost());
    }

    @Test
    public void playWithNoCreditsDoesNothing(){
        game.changePlayerCredits(-100);
        game.play();
        Integer expected = 0;
        assertEquals(expected, game.getPlayerCredits());
    }

    @Test
    public void gameReturnsInsufficientCredits(){
        game.changePlayerCredits(-100);
        assertEquals(false, game.sufficientCredits());
    }

    @Test
    public void gameGetsImageSet(){
        Integer expected = R.drawable.club;
        assertEquals(expected, game.getImageSet().get(1));
    }

    @Test
    public void gameSetsImageSet(){
        game.setImageSet(fruitImages);
        Integer expected = R.drawable.cherry;
        assertEquals(expected, game.getImageSet().get(1));
    }




}
