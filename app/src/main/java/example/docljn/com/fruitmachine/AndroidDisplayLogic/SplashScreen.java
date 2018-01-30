package example.docljn.com.fruitmachine.AndroidDisplayLogic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import example.docljn.com.fruitmachine.JavaLogic.Game;
import example.docljn.com.fruitmachine.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Game game = new Game(3);
        // TODO: add buttons to set the number of reels to 3 or 5 on the front page?

        // Set Grid View column count to match reel number

        // TODO Do I need a layout inflater here?

        LayoutInflater inflater = (LayoutInflater)getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fruit_machine_reels_grid, null);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.fruitMachineReelLayout);
        gridLayout.setColumnCount(game.getNumberOfReels());

        ImageView top = findViewById(R.id.imageViewTopReelImage);
        top.setImageResource(R.drawable.club);

    }
}
