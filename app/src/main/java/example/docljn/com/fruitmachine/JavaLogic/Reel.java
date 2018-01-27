package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public class Reel {
    private int imageLookupTable;
    private int numberOfStops;
    private int setupReference;
    private boolean held;

    public Reel(int numberOfStops, int imageLookupTable, int setupReference) {
        this.imageLookupTable = imageLookupTable;
        this.numberOfStops = numberOfStops;
        this.setupReference = setupReference;
        this.held = false;
    }

    public int getNumberOfStops() {
        return this.numberOfStops;
    }

    public int getImageLookupTable() {
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

    public void setImageLookupTable(int imageLookupTable) {
        this.imageLookupTable = imageLookupTable;
    }


    public void setSetupReference(int setupReference) {
        this.setupReference = setupReference;
    }

    public void setHeld(boolean held) {
        this.held = held;
    }
}
