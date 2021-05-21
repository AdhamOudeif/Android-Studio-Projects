package cosc426.program.colors;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar red;
    private SeekBar green;
    private SeekBar blue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Seekbar listeners
        red = (SeekBar)findViewById(R.id.red);
        green = (SeekBar)findViewById(R.id.green);
        blue = (SeekBar)findViewById(R.id.blue);

        ChangeHandler temp = new ChangeHandler();

        red.setOnSeekBarChangeListener(temp);
        green.setOnSeekBarChangeListener(temp);
        blue.setOnSeekBarChangeListener(temp);

    }

    private class ChangeHandler implements SeekBar.OnSeekBarChangeListener{
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            //Get color values in real time
            int redValue = red.getProgress();
            int greenValue = green.getProgress();
            int blueValue = blue.getProgress();

            //set color in real time
            TextView box = (TextView)findViewById(R.id.box);
            box.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

            //update value boxes
            TextView redBox = (TextView)findViewById(R.id.redDisplay);
            redBox.setText(redValue+"");
            TextView greenBox = (TextView)findViewById(R.id.greenDisplay);
            greenBox.setText(greenValue+"");
            TextView blueBox = (TextView)findViewById(R.id.blueDisplay);
            blueBox.setText(blueValue+"");
        }
        //SeekBar functions
        public void onStartTrackingTouch(SeekBar seekBar) {}
        public void onStopTrackingTouch(SeekBar seekBar){}
    }
}