package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lornanoble on 28/01/2018.
 */

public class Game {
    private Integer numberOfReels;
    private ArrayList<Integer> imageReferences;  // TODO: how to have images changeable within the game?
    private ArrayList<Reel> reelSet;
    private Integer playerCredits;
    private Integer gameCost;


    public Game(Integer numberOfReels) {
        this.numberOfReels = numberOfReels;
        this.reelSet = new ArrayList<>();
        for (int i = 0; i < numberOfReels; i++){
            this.reelSet.add(new Reel());
        }
        this.playerCredits = 0;
        this.gameCost = 20; //TODO: game cost is hardcoded at the moment, no getter or setter!

    }


    public ArrayList<Reel> getReelSet() {
        return this.reelSet;
    }

    public ArrayList<Integer> getWinLine() {
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
