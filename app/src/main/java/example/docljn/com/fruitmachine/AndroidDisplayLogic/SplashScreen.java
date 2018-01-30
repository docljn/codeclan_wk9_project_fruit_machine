package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.R;

public class SplashScreen extends AppCompatActivity {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        HashMap<Integer, Integer> cardImages = new HashMap<>();
        cardImages.put(1, R.drawable.club);
        cardImages.put(2, R.drawable.diamond);
        cardImages.put(3, R.drawable.heart);
        cardImages.put(5, R.drawable.spade);

        game = new Game(3);

        TextView credits = findViewById(R.id.textViewCredits);
        credits.setText(game.getPlayerCredits().toString() + " FREE CREDITS");
    }


    private void updateCreditText(){
        TextView credits = findViewById(R.id.textViewCredits);
        credits.setText(game.getPlayerCredits().toString() + " CREDITS");
    }

    protected void onBuyCreditButtonClick(View button){
        Integer amount = Integer.valueOf(button.getTag().toString());
        game.changePlayerCredits(amount);
        updateCreditText();
    }

    protected void onPlayButtonClick(View button){  // have to pass in a view even if you don't use it!
        game.play();
        updateCreditText();
    }






        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater if I want a generic display set by number of reels?

}


