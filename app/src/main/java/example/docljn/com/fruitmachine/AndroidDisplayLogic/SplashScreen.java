package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
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
        // TODO: Have a second hashmap with alternative images, and make the set image methods configurable
        cardImages = new HashMap<>();
        cardImages.put(1, R.drawable.club);
        cardImages.put(2, R.drawable.diamond);
        cardImages.put(3, R.drawable.heart);
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

    // TODO: work out how to extract these methods, if possible!

    private void setReel1Images(){
        Reel reel = game.getReelSet().get(0);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();


        ImageView imageViewTop = findViewById(R.id.imageViewTop1);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine1);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom1);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }



    private void setReel2Images(){
        Reel reel = game.getReelSet().get(1);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTop = findViewById(R.id.imageViewTop2);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine2);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom2);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }




    private void setReel3Images(){
        Reel reel = game.getReelSet().get(2);
        Integer visibleStop = reel.getVisibleStop();
        Integer before = reel.getStopBefore();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTop = findViewById(R.id.imageViewTop3);
        Integer imageIDTop = cardImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine3);
        Integer imageIDWin= cardImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom3);
        Integer imageIDBottom = cardImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }

    private void buttonActivate(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.colorAction));
        button.setTextColor(getResources().getColor(R.color.textColorAction));

    }


    private void setButtonColourIfActive(){ //TODO: complete this method, consider colours or visible/invisible options
        // Reel 1
        Button nudgeButton = findViewById(R.id.buttonNudge1);
        Button holdButton = findViewById(R.id.buttonHold1);
        Reel reel = game.getReelSet().get(0);

        if (reel.getNudgeable()){
            buttonActivate(nudgeButton);
        }
        if (reel.getHoldable()){
            buttonActivate(holdButton);
        }

        // Reel 2
        Button nudgeButton2 = findViewById(R.id.buttonNudge2);
        Button holdButton2 = findViewById(R.id.buttonHold2);
        Reel reel2 = game.getReelSet().get(1);

        if (reel2.getNudgeable()){
            buttonActivate(nudgeButton2);
        }
        if (reel2.getHoldable()){
            buttonActivate(holdButton2);
        }


        // Reel 3
        Button nudgeButton3 = findViewById(R.id.buttonNudge3);
        Button holdButton3 = findViewById(R.id.buttonHold3);
        Reel reel3 = game.getReelSet().get(2);

        if (reel3.getNudgeable()){
            buttonActivate(nudgeButton3);
        }
        if (reel3.getHoldable()){
            buttonActivate(holdButton3);
        }

    }

    private void jackpotVisible(Boolean visible){
        ImageView jackpot = findViewById(R.id.imageViewJackpot);
        if (visible) {
            jackpot.setVisibility(View.VISIBLE);
        }
        if (!visible) {
            jackpot.setVisibility(View.GONE);
        }
    }

    private void showResults(Integer gameResult){
        updateCreditText();
        if (gameResult > 0) {
            jackpotVisible(true);
        } else {
            jackpotVisible(false);
        }

        setReel1Images();
        setReel2Images();
        setReel3Images();
        setButtonColourIfActive();
    }




    protected void onPlayButtonClick(View button){  // have to pass in a view even if you don't use it!
        if (game.sufficientCredits()) {  // hopefully stops a crash when play is clicked with zero credits
            Integer won = game.play();
            showResults(won);
        } else {
            Toast.makeText(this, "You need more credits to play", Toast.LENGTH_LONG).show();
        }
    }

    protected void onNudgeButtonClick(View button){
        ArrayList<Reel> reelSet = game.getReelSet();
        Integer reelNumber = Integer.valueOf(button.getTag().toString());

        reelSet.get(reelNumber).nudge();
        Integer result = game.getWinnings();
        showResults(result);


    }






        // TODO: IF YOU WANT TO MAKE THIS CONFIGURABLE
        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater if I want a generic display set by number of reels?

}


