package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


public class GameScreenActivity extends AppCompatActivity {
    Game game;
    HashMap<Integer, Integer> cardImages;
    HashMap<Integer, Integer> fruitImages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        // TODO:  make the set image methods configurable
        fruitImages = new HashMap<>();
        fruitImages.put(1, R.drawable.cherry);
        fruitImages.put(2, R.drawable.lemon);
        fruitImages.put(3, R.drawable.watermelon);
        fruitImages.put(5, R.drawable.seven);

        cardImages = new HashMap<>();
        cardImages.put(1, R.drawable.club);
        cardImages.put(2, R.drawable.diamond);
        cardImages.put(3, R.drawable.heart);
        cardImages.put(5, R.drawable.spade);

        // Get tag from parent activity:
        // Create a new Intent which will be the same as the intent that was sent by startActivity on the source activity
        // There will only ever be one intent
        Intent intent = getIntent();
        // Cast the extra, which is an object, to be a String
        String imageSet = (String)intent.getSerializableExtra("imageSet");
        Log.d("GameActivity", imageSet);

        if (imageSet == "fruitImages"){
            game = new Game(3, fruitImages);
        } else if (imageSet == "cardImages"){
            game = new Game(3, cardImages);
        } else {
            game = new Game(3, fruitImages);
        }


        TextView credits = findViewById(R.id.textViewCredits);
        credits.setText(game.getPlayerCredits().toString() + " FREE CREDITS");

        //TODO: extract set images to separate method call!
        setReel1Images(game.getImageSet());
        setReel2Images(game.getImageSet());
        setReel3Images(game.getImageSet());

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

    private void setReel1Images(HashMap<Integer, Integer> reelImages){
        Reel reel = game.getReelSet().get(0);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();


        ImageView imageViewTop = findViewById(R.id.imageViewTop1);
        Integer imageIDTop = reelImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine1);
        Integer imageIDWin= reelImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom1);
        Integer imageIDBottom = reelImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }



    private void setReel2Images(HashMap<Integer, Integer> reelImages){
        Reel reel = game.getReelSet().get(1);
        Integer before = reel.getStopBefore();
        Integer visibleStop = reel.getVisibleStop();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTop = findViewById(R.id.imageViewTop2);
        Integer imageIDTop = reelImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine2);
        Integer imageIDWin= reelImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom2);
        Integer imageIDBottom = reelImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }




    private void setReel3Images(HashMap<Integer, Integer> reelImages){
        Reel reel = game.getReelSet().get(2);
        Integer visibleStop = reel.getVisibleStop();
        Integer before = reel.getStopBefore();
        Integer after = reel.getStopAfter();


        Integer imageRefTop = reel.getSymbol(before).getValue();
        Integer imageRefWin = reel.getSymbol(visibleStop).getValue();
        Integer imageRefBottom = reel.getSymbol(after).getValue();

        ImageView imageViewTop = findViewById(R.id.imageViewTop3);
        Integer imageIDTop = reelImages.get(imageRefTop);
        imageViewTop.setImageResource(imageIDTop);

        ImageView imageViewWin = findViewById(R.id.imageViewWinLine3);
        Integer imageIDWin= reelImages.get(imageRefWin);
        imageViewWin.setImageResource(imageIDWin);


        ImageView imageViewBottom = findViewById(R.id.imageViewBottom3);
        Integer imageIDBottom = reelImages.get(imageRefBottom);
        imageViewBottom.setImageResource(imageIDBottom);
    }

    private void buttonActivate(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.colorAction));
        button.setTextColor(getResources().getColor(R.color.textColorAction));
    }

    private void buttonDeactivate(Button button){
        button.setBackgroundColor(getResources().getColor(R.color.orange));
        button.setTextColor(getResources().getColor(R.color.black));
    }


    private void setButtonColour(){ //TODO: REFACTOR setButtonColour it's WAY TOO LONG!
        // Reel 1
        Button nudgeButton = findViewById(R.id.buttonNudge1);
        Button holdButton = findViewById(R.id.buttonHold1);
        Reel reel = game.getReelSet().get(0);

        if (reel.getNudgeable()){
            buttonActivate(nudgeButton);
        } else {
            buttonDeactivate(nudgeButton);
        }

        if (reel.getHoldable()){
            buttonActivate(holdButton);
        } else {
            buttonDeactivate(holdButton);
        }

        // Reel 2
        Button nudgeButton2 = findViewById(R.id.buttonNudge2);
        Button holdButton2 = findViewById(R.id.buttonHold2);
        Reel reel2 = game.getReelSet().get(1);

        if (reel2.getNudgeable()){
            buttonActivate(nudgeButton2);
        } else {
            buttonDeactivate(nudgeButton2);
        }
        if (reel2.getHoldable()){
            buttonActivate(holdButton2);
        }else {
            buttonDeactivate(holdButton2);
        }


        // Reel 3
        Button nudgeButton3 = findViewById(R.id.buttonNudge3);
        Button holdButton3 = findViewById(R.id.buttonHold3);
        Reel reel3 = game.getReelSet().get(2);

        if (reel3.getNudgeable()){
            buttonActivate(nudgeButton3);
        } else {
            buttonDeactivate(nudgeButton3);
        }
        if (reel3.getHoldable()){
            buttonActivate(holdButton3);
        } else {
            buttonDeactivate(holdButton3);
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
        //TODO: find a way to have the jackpot auto-disappear after a delay
    }

    private void showResults(Integer gameResult){
        updateCreditText();
        if (gameResult > 0) {
            jackpotVisible(true);
        } else {
            jackpotVisible(false);
        }

        setReel1Images(game.getImageSet());
        setReel2Images(game.getImageSet());
        setReel3Images(game.getImageSet());
        setButtonColour();
    }




    protected void onPlayButtonClick(View view){  // have to pass in a view even if you don't use it!
        if (game.sufficientCredits()) {  // hopefully stops a crash when play is clicked with zero credits

            //TODO: refactor so that play is void and you get won from showresults?
            game.play();
            Integer won = game.getWinnings();
            showResults(won);
        } else {
            Toast.makeText(this, "You need more credits to play", Toast.LENGTH_LONG).show();
        }
    }

    protected void onNudgeButtonClick(View button){
        ArrayList<Reel> reelSet = game.getReelSet();
        Integer reelNumber = Integer.valueOf(button.getTag().toString());
        Reel reel = reelSet.get(reelNumber);
        if (reel.getNudgeable()) {
            reel.nudge();
            Integer result = game.getWinnings();
            game.changePlayerCredits(result);
            showResults(result);
        }
    }

    protected void onHoldButtonClick(View button){
        ArrayList<Reel> reelSet = game.getReelSet();
        Integer reelNumber = Integer.valueOf(button.getTag().toString());

        Reel reel = reelSet.get(reelNumber);
        if (reel.getHoldable()) {
            reel.setHeld(true);

            Button castButton = (Button) button;
            castButton.setBackgroundColor(getResources().getColor(R.color.black));
            castButton.setTextColor(getResources().getColor(R.color.black));
        }

    }






        // TODO: IF YOU WANT TO MAKE THIS CONFIGURABLE
        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?
        // TODO: Set Grid View column count to match reel number
        // TODO Do I need a layout inflater if I want a generic display set by number of reels?

}


