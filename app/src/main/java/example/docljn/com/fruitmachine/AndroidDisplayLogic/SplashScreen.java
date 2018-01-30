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
        setReel1Images();
        setReel2Images();
        setReel3Images();

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

//    protected ArrayList<Integer> getReelStops(Integer reelNumber){
//        Reel reel = game.getReelSet().get(reelNumber-1);
//        ArrayList<Integer> stopNumbers = new ArrayList<>();
//        Integer visibleStop = reel.getVisibleStop();
//        Integer before = reel.getStopBefore();
//        Integer after = reel.getStopAfter();
//    }

    protected void setReel1Images(){
        Reel reel = game.getReelSet().get(0);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();


        ImageView imageViewTopLine1 = findViewById(R.id.imageViewTop1);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTopLine1.setImageResource(imageIDTop);

        ImageView imageViewWinLine1 = findViewById(R.id.imageViewWinLine1);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWinLine1.setImageResource(imageIDWin);


        ImageView imageViewBottomLine1 = findViewById(R.id.imageViewBottom1);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottomLine1.setImageResource(imageIDBottom);
    }



    protected void setReel2Images(){
        Reel reel = game.getReelSet().get(1);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTopLine1 = findViewById(R.id.imageViewTop2);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTopLine1.setImageResource(imageIDTop);

        ImageView imageViewWinLine1 = findViewById(R.id.imageViewWinLine2);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWinLine1.setImageResource(imageIDWin);


        ImageView imageViewBottomLine1 = findViewById(R.id.imageViewBottom2);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottomLine1.setImageResource(imageIDBottom);
    }




    protected void setReel3Images(){
        Reel reel = game.getReelSet().get(2);
        Integer visibleStop = reel.getVisibleStop();
        Integer before = reel.getStopBefore();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTopLine1 = findViewById(R.id.imageViewTop3);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTopLine1.setImageResource(imageIDTop);

        ImageView imageViewWinLine1 = findViewById(R.id.imageViewWinLine3);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWinLine1.setImageResource(imageIDWin);


        ImageView imageViewBottomLine1 = findViewById(R.id.imageViewBottom3);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottomLine1.setImageResource(imageIDBottom);
    }


    protected void onPlayButtonClick(View button){  // have to pass in a view even if you don't use it!
        game.play();
        updateCreditText();

        setReel1Images();
        setReel2Images();
        setReel3Images();



    }






        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater if I want a generic display set by number of reels?

}


