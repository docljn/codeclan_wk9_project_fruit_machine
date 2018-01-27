package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public enum Symbol {
    DIAMOND(1, 1),
    CLUB(2, 2),
    HEART(3, 3),
    SPADE(4, 4);

    private int value;
    private int imageId;

    Symbol(int value, int imageId) {
        this.value = value;
        this.imageId = imageId;
    }

}
