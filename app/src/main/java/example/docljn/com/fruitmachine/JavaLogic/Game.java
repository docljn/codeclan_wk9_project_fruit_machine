package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class Game {
    private ArrayList<Symbol> reelSetup;
    private ArrayList<Reel> reelSet;
    private int numberOfReels;
    private HashMap<ArrayList<Integer>, Integer> payTable;


    public Game(int numberOfReels, ArrayList<Symbol> reelSetup, HashMap<ArrayList<Integer>, Integer> payTable) {
        this.numberOfReels = numberOfReels;
        //TODO: all reels are identical, but need to be referred to separately, thus add 3 new objects
        //TODO: need to extract this method and include the paytable setup as part of it
        this.reelSet = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++){
            this.reelSet.add(new Reel(reelSetup));
        }
        //TODO: work out how to set up the payTable
        this.payTable = payTable;

    }


    public ArrayList<Reel> getReelSet() {
        return this.reelSet;
    }

    public ArrayList<Integer> getWinLine() {
        ArrayList<Integer> winLine = new ArrayList<>();
        for(Reel reel: reelSet){
            winLine.add(reel.getVisibleStop());
        }
        return winLine;
    }


    public Integer getWinnings() {
        return this.payTable.get(getWinLine());
    }
}
