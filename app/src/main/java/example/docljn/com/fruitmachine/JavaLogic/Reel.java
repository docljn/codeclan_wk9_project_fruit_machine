package example.docljn.com.fruitmachine.JavaLogic;

import java.util.ArrayList;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class Reel {
    private int visibleStop;
    private ArrayList<Symbol> imageLookupTable;
    private int numberOfStops;
    private int setupReference;
    private boolean held;

    public Reel(ArrayList<Symbol> imageLookupTable, int setupReference) {
        this.imageLookupTable = imageLookupTable;
        this.numberOfStops = 8; //TODO: link this to the number of images in the lookupTable
        this.setupReference = setupReference;
        this.held = false;
        this.visibleStop = 0;
    }

    public int getNumberOfStops() {
        return this.numberOfStops;
    }

    public int getVisibleStop() {
        return visibleStop;
    }

    public ArrayList<Symbol> getImageLookupTable() {
        return this.imageLookupTable;
    }

    public int getSetupReference() {
        return setupReference;
    }

    public boolean getHeld() {
        return this.held;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public void setImageLookupTable(ArrayList<Symbol> imageLookupTable) {
        this.imageLookupTable = imageLookupTable;
    }


    public void setSetupReference(int setupReference) {
        this.setupReference = setupReference;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }


    public void setVisibleStop(int visibleStop) {
        this.visibleStop = visibleStop;
    }
}
