package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class Game {
    private Integer numberOfReels;
    private ArrayList<Symbol> reelSetup;
    private ArrayList<Reel> reelSet;
    private HashMap<ArrayList<Integer>, Integer> payTable;
    private Integer playerCredits;
    private Integer gameCost;


    public Game(Integer numberOfReels, ArrayList<Symbol> reelSetup, HashMap<ArrayList<Integer>, Integer> payTable) {
        this.numberOfReels = numberOfReels;
        //TODO: all reels are identical, but need to be referred to separately, thus add 3 new objects
        //TODO: need to extract this method and include the paytable setup as part of it?
        this.reelSet = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++){
            this.reelSet.add(new Reel(reelSetup));
        }
        //TODO: work out how to set up the payTable
        this.payTable = payTable;
        this.playerCredits = 0;
        this.gameCost = 20; //TODO: game cost is hardcoded at the moment, no getter or setter!

    }


    public ArrayList<Reel> getReelSet() {
        return this.reelSet;
    }

    public ArrayList<Integer> getWinLine() { //todo: this returns the stops, I need the value of the symbol of those stops!
        ArrayList<Integer> winLine = new ArrayList<>();
        for(Reel reel: reelSet){
            winLine.add(reel.getSymbol(reel.getVisibleStop()).getValue());
        }
        return winLine;
    }


    public Integer getWinnings() {
        Integer winnings = this.payTable.get(getWinLine());
        if (winnings != null) {
            return winnings;
        } else {
            return 0;
        }
        //todo: winnings should depend on the game stake?

    }

    public Integer getPlayerCredits() {
        return this.playerCredits;
    }

    public void changePlayerCredits(int creditsChangedBy) {
        this.playerCredits += creditsChangedBy;
    }

    public Integer play() {
        if (getPlayerCredits() >= this.gameCost) {
            changePlayerCredits(-gameCost);
            for (Reel reel: getReelSet()) {
                reel.spin();
            }
            System.out.println(getWinnings());  //todo: work out how to actually test this!!
            return getWinnings();
        } else {
            return null;
        }
    }
}
