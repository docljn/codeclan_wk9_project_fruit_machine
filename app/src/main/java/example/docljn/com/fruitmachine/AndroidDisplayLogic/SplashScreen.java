package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.HashMap;

import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        HashMap<Integer, Integer> cardImages = new HashMap<>();
        cardImages.put(1, R.drawable.club);
        cardImages.put(2, R.drawable.diamond);
        cardImages.put(4, R.drawable.heart);
        cardImages.put(10, R.drawable.spade);

        Game game = new Game(3);






        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater here?



    }
}


