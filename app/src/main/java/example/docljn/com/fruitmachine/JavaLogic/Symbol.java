package example.docljn.com.fruitmachine.JavaLogic;

/**
 * Created by lornanoble on 27/01/2018.
 */

public enum Symbol {
    ONE(1, 1),
    TWO(2, 2),
    FOUR(4, 3),
    TEN(10, 4);

    private int value;
    private int imageId;

    Symbol(int value, int imageId) {
        this.value = value;
        this.imageId = imageId;
    }


    public int getValue() {
        return value;
    }

    public int getImageId() {
        return imageId;
    }

}
