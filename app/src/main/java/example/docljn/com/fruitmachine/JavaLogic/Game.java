package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.Collection;

import example.docljn.com.fruitmachine.JavaLogic.Reel;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class Game {
    private ArrayList<Symbol> reelSetup;
    private ArrayList<Reel> reelSet;
    private int numberOfReels;

    public Game(int numberOfReels, ArrayList<Symbol> reelSetup) {
        this.numberOfReels = numberOfReels;
        //TODO: all reels are identical, but need to be referred to separately
        //TODO: consider: do you set up a game with a number of reels and a reel setup, or a specific reel?
        this.reelSet = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++){
            this.reelSet.add(new Reel(reelSetup));
        }
    }


    public ArrayList<Reel> getReelSet() {
        return this.reelSet;
    }

    public ArrayList<Symbol> getWinLine() {
        ArrayList<Symbol> winLine = new ArrayList<>();
        for(Reel reel: reelSet){
            winLine.add(reel.getSymbol(reel.getVisibleStop()));
        }
        // TODO:
        // for loop repeats for number of reels in reelSet
        // each reel returns visibleSymbol
        // visibleSymbol added to winLine arraylist
        //return arraylist
        //winLine.add();
        return winLine;
    }
}
