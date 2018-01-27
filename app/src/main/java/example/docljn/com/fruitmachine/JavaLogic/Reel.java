package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class Reel {
    private int visibleStop;
    private ArrayList<Symbol> setup;
    private int numberOfStops;
    private int returnLevel;
    private boolean held;

    public Reel(ArrayList<Symbol> setup, int returnLevel) {
        this.setup = setup;
        this.returnLevel = returnLevel;
        this.held = false;
        this.visibleStop = 0;
    }

    public int getNumberOfStops() {
        return this.setup.size();
    }

    public int getVisibleStop() {
        return visibleStop;
    }

    public ArrayList<Symbol> getSetup() {
        return this.setup;
    }

    public int getReturnLevel() {
        return returnLevel;
    }

    public boolean getHeld() {
        return this.held;
    }

    public void setSetup(ArrayList<Symbol> setup) {
        this.setup = setup;
    }


    public void setReturnLevel(int returnLevel) {
        this.returnLevel = returnLevel;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }


    public void setVisibleStop(int visibleStop) {
        //TODO: consider adding logic about negative or too large to this method as well?
        this.visibleStop = visibleStop;
    }


    public int getStopBefore() {
        int before = getVisibleStop() - 1;
        if (before < 0){
            return getNumberOfStops()-1;
        } else if (before >= getNumberOfStops()){
            return before - (getNumberOfStops()-1);
        }
        return before;
    }

    public int getStopAfter() { //TODO circular upwards
        int after = getVisibleStop() + 1;
        if (after >= getNumberOfStops()) {
            return after - getNumberOfStops();
        }
        return after;
    }
}
