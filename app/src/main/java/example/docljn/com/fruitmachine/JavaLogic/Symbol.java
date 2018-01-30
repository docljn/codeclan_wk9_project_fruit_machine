package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public enum Symbol {
    ONE(0),
    TWO(1),
    THREE(2),
    FIVE(5);

    private int value;

    Symbol(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }


}
