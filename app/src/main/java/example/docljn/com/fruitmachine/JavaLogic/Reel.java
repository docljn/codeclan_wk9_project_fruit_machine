package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class Reel {
    private boolean nudgeable;
    private boolean holdable;
    private Integer visibleStop;
    private ArrayList<Symbol> setup;
    private boolean held;

    public Reel() {
        setup = new ArrayList<>();
        //TODO: eventually, allow for different reel setups!
        //TODO: consider adding randomness to the reel layouts
        setup.add(Symbol.ONE);
        setup.add(Symbol.TWO);
        setup.add(Symbol.THREE);
        setup.add(Symbol.FIVE);
        setup.add(Symbol.ONE);
        setup.add(Symbol.TWO);
        setup.add(Symbol.THREE);
        setup.add(Symbol.ONE);

        this.held = false;
        this.holdable = false;
        this.nudgeable = false;
        this.visibleStop = 0;
    }

    public Integer getNumberOfStops() {
        return this.setup.size();
    }

    public Integer getVisibleStop() {
        return visibleStop;
    }

    public ArrayList<Symbol> getSetup() {
        return this.setup;
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

    public void setHoldable(boolean holdable) {
        this.holdable = holdable;
    }

    public void setHeld(boolean held) {
        if (getHoldable()){
        this.held = held;}
    }


    public void setVisibleStop(Integer visibleStop) {
        if (visibleStop < 0){
            visibleStop = getNumberOfStops() + visibleStop;
        }
        this.visibleStop = visibleStop % getNumberOfStops();
    }


    public Integer getStopBefore() {
        Integer before = getVisibleStop() - 1;
        if (before == -1){
            return getNumberOfStops()-1;
        }
        return before;
    }

    public Integer getStopAfter() {
        Integer after = getVisibleStop() + 1;
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
            setNudgeable(false);
        }
    }

    public void spin() {
        Random random = new Random();
        // Generate random integers in range 0 to 999
        Integer randomStop = random.nextInt(1000);
        if (!getHeld()) {
            setVisibleStop(randomStop);
        } else {
            setHeld(false);
            setHoldable(false);
        }
        if (randomStop % 20 == 0){
            setNudgeable(true);
        }
        if (randomStop % 24 == 0){
            setHoldable(true);
        }
        // todo: award nudge/hold randomly in reels AND TEST FOR IT?
    }

    public Symbol getSymbol(Integer stopNumber) {
        return this.setup.get(stopNumber);
    }

}


