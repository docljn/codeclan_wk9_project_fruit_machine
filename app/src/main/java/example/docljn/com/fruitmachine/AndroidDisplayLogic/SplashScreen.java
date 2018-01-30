package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.JavaLogic.Reel;
import example.docljn.com.fruitmachine.R;

public class SplashScreen extends AppCompatActivity {
    Game game;
    HashMap<Integer, Integer> cardImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        cardImages = new HashMap<>();
        cardImages.put(0, R.drawable.club);
        cardImages.put(1, R.drawable.diamond);
        cardImages.put(2, R.drawable.heart);
        cardImages.put(5, R.drawable.spade);

        game = new Game(3);

        TextView credits = findViewById(R.id.textViewCredits);
        credits.setText(game.getPlayerCredits().toString() + " FREE CREDITS");
    }


    private void updateCreditText(){
        TextView credits = findViewById(R.id.textViewCredits);
        if (game.getPlayerCredits() >= game.getGameCost()) {
            credits.setText(game.getPlayerCredits().toString() + " CREDITS");
        } else {
            credits.setText("BUY MORE CREDITS!");
        }
    }

    protected void onBuyCreditButtonClick(View button){
        Integer amount = Integer.valueOf(button.getTag().toString());
        game.changePlayerCredits(amount);
        updateCreditText();
    }

    protected void setReel1Images(){
        Reel reel = game.getReelSet().get(0);
        Integer visibleStop = reel.getVisibleStop();
        Integer before = reel.getStopBefore();
        Integer after = reel.getStopAfter();

        Integer imageRef = reel.getSymbol(reel.getVisibleStop()).getValue();

        ImageView imageViewTopLine1 = findViewById(R.id.imageViewTop1);
        Integer imageIDTop = cardImages.get(imageRef);
        imageViewTopLine1.setImageResource(imageIDTop);

        ImageView imageViewWinLine1 = findViewById(R.id.imageViewWinLine1);
        Integer imageIDWin= cardImages.get(reel.getSymbol(reel.getVisibleStop()).getValue());
        imageViewWinLine1.setImageResource(imageIDWin);



        ImageView imageViewBottomLine1 = findViewById(R.id.imageViewBottom1);
        Integer imageIDBottom = cardImages.get(reel.getSymbol(reel.getVisibleStop()).getValue());
        imageViewBottomLine1.setImageResource(imageIDBottom);



    }


    protected void onPlayButtonClick(View button){  // have to pass in a view even if you don't use it!
        game.play();
        updateCreditText();

        setReel1Images();



    }






        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater if I want a generic display set by number of reels?

}


