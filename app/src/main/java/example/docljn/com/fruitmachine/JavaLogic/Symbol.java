package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public enum Symbol {
    ONE(1),
    TWO(2),
    FOUR(4),
    TEN(10);

    private int value;

    Symbol(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }


}
