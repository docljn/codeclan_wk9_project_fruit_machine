package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import example.docljn.com.fruitmachine.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }





    public void onStartPlayButtonClick(View playButtonView) {
        String imageSet = playButtonView.getTag().toString();

        Intent intent = new Intent(this, GameScreenActivity.class);
        // CARE: .class is called on the target activity
        intent.putExtra("imageSet", imageSet);
        startActivity(intent);

        // move to the target activity here and retrieve the extra...
    }


    public void onSelectImageButtonClick(View button){
        //TODO: error says the signature is wrong?
        String imageSet = button.getTag().toString();
        View playButtonView = findViewById(R.id.imageButtonStartPlay);
        playButtonView.setTag(imageSet);

    }
}
