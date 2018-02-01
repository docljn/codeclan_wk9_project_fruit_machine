package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by lornanoble on 01/02/2018.
 */

public class HighlightOnTouchListener implements View.OnTouchListener {

    final ImageButton imageButton;

    public HighlightOnTouchListener(final ImageButton imageButton) {
        super();
        this.imageButton = imageButton;
    }

    public boolean onTouch(final View view, final MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            imageButton.setBackgroundColor(Color.argb(155, 185, 0, 0));
            imageButton.setColorFilter(Color.argb(255, 185, 0, 0));

        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            imageButton.setBackgroundColor(Color.argb(0, 185, 0, 0));
            imageButton.setColorFilter(Color.argb(0, 185, 0, 0));

        }
        return false;
    }

}
