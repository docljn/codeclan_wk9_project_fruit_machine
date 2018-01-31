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
        this.playerCredits = 100;  // player starts with 5 free games
        this.gameCost = 20; //TODO: game cost is hardcoded at the moment, no setter!  Could pass in a value?

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
        Integer winnings = getWinLine().get(1) * numberOfReels * gameCost;
        ArrayList<Integer> reelValues = getWinLine();
        for (int i = 0; i < reelValues.size(); i++) {
            for (int j = i+1; j < reelValues.size(); j++) {
                if (reelValues.get(i) != reelValues.get(j)){
                    winnings = 0;
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
            Integer won = getWinnings();
            changePlayerCredits(won);
            //System.out.println(won);  //todo: work out how to actually test this!!
            return won;
        } else {
            return null;
        }
    }

    public Integer getNumberOfReels() {
        return this.numberOfReels;
    }


    public Integer getGameCost() {
        return this.gameCost;
    }

    public boolean sufficientCredits() {
        return getPlayerCredits() >= getGameCost();
    }
}
