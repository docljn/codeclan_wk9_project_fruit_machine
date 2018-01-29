package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class Game {
    private Integer numberOfReels;
    private ArrayList<Integer> imageReferences;
    private ArrayList<Reel> reelSet;
    private Integer playerCredits;
    private Integer gameCost;


    public Game(Integer numberOfReels, ArrayList<Integer> imageReferences) {
        this.numberOfReels = numberOfReels;
        this.imageReferences = imageReferences;
        //TODO: all reels are identical, but need to be referred to separately, thus add 3 new objects
        //TODO: need to extract this method and include the paytable setup as part of it?
        this.reelSet = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++){
            this.reelSet.add(new Reel());
        }
        //TODO: work out how to set up the payTable
        this.playerCredits = 0;
        this.gameCost = 20; //TODO: game cost is hardcoded at the moment, no getter or setter!

    }

    //TODO: extract game setup method instead of passing in arguments?


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
        Integer winnings = 0;
        ArrayList<Integer> reelValues = getWinLine();
        for (int i = 0; i < reelValues.size(); i++) {
            for (int j = i+1; j < reelValues.size(); j++) {
                if (reelValues.get(i) != reelValues.get(j)){
                    return winnings;
                } else {
                    winnings = getWinLine().get(1) * numberOfReels * gameCost;
                }
            }
        }

        return winnings;
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
