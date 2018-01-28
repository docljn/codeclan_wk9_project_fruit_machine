package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class Reel {
    private boolean nudgeable;
    private boolean holdable;
    private int visibleStop;
    private ArrayList<Symbol> setup;
    private int numberOfStops;
    private int returnLevel;
    private boolean held;

    public Reel(ArrayList<Symbol> setup, int returnLevel) {
        this.setup = setup;
        this.returnLevel = returnLevel;
        this.held = false;
        this.holdable = false;
        this.nudgeable = false;
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

    public boolean getHoldable() {
        return this.holdable;
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

    public void setHoldable(boolean holdable) {
        this.holdable = holdable;
    }

    public void setHeld(boolean held) {
        if (getHoldable()){
        this.held = held;}
    }


    public void setVisibleStop(int visibleStop) {
        if (visibleStop < 0){
            visibleStop = getNumberOfStops() + visibleStop;
        }
        this.visibleStop = visibleStop % getNumberOfStops();
    }


    public int getStopBefore() {
        int before = getVisibleStop() - 1;
        if (before == -1){
            return getNumberOfStops()-1;
        }
        return before;
    }

    public int getStopAfter() {
        int after = getVisibleStop() + 1;
        if (after == getNumberOfStops()) {
            return after - getNumberOfStops();
        }
        return after;
    }


    public boolean getNudgeable() {
        return this.nudgeable;
    }

    public void setNudgeable(boolean nudgeable) {
        this.nudgeable = nudgeable;
    }

    public void nudge() {
        if (getNudgeable()) {
            setVisibleStop(getVisibleStop() + 1);
        }
    }


    public void spin() {

        Random random = new Random();
        // Generate random integers in range 0 to 999
        int randomStop = random.nextInt(1000);
        if (getHeld() == false) {
            setVisibleStop(randomStop);
        }
    }
}


