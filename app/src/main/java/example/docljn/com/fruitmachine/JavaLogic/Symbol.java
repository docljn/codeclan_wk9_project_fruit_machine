package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public enum Symbol {
    DIAMOND(1),
    CLUB(2),
    HEART(3),
    SPADE(4);

    private int imageRef;

    Symbol(int imageRef) {
        this.imageRef = imageRef;
    }
}
