package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import example.docljn.com.fruitmachine.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


    }

    public void startPlay(View playButtonView) {
        String imageSet = (String) playButtonView.getTag();
        Log.d("Intent creation", imageSet);

        Intent intent = new Intent(this, GameScreenActivity.class); //NEW
        // CARE: .class is called on the target activity
        intent.putExtra("imageSet", imageSet); //NEW
        // TODO: think about attaching only the data you will use, rather than the whole object
        startActivity(intent); //NEW

        // move to the target activity here and retrieve the extra...
    }
}
