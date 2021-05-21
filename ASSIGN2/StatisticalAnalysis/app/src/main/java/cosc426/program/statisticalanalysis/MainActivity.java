package cosc426.program.statisticalanalysis;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button button = (Button)findViewById(R.id.b1);
        Sum sum = new Sum();
        button.setOnClickListener(sum);
        button = (Button)findViewById(R.id.b2);
        Mean mean = new Mean();
        button.setOnClickListener(mean);
        button = (Button)findViewById(R.id.b3);
        Median median = new Median();
        button.setOnClickListener(mean);
        button = (Button)findViewById(R.id.b4);
        Stdev stdev = new Stdev();
        button.setOnClickListener(stdev);
        button = (Button)findViewById(R.id.b5);
        Min min = new Min();
        button.setOnClickListener(min);
        button = (Button)findViewById(R.id.b6);
        Max max = new Max();
        button.setOnClickListener(max);

    }

    //Listener for on Click event
    private class Sum implements View.OnClickListener{
        public void onClick(View v){
            inputHandler(0);
        }
    }

    //Mean button
    private class Mean implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(1);
        }
    }

    //median button
    private class Median implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(2);
        }
    }

    //standard deviation button
    private class Stdev implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(3);
        }
    }

    //Minimum Button
    private class Min implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(4);
        }
    }

    //Max button
    private class Max implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(5);
        }
    }


    //Input handlers
    protected void inputHandler(int operation){

        //Get numbers input
        EditText inputText = (EditText)findViewById(R.id.input);
        String inputString = inputText.getText().toString();
        String[] splitInput = inputString.split("\\s+");

        //split input by spaces
        int[] inputArray = new int[splitInput.length];
        for(int i = 0; i < splitInput.length; i++)
            inputArray[i] = Integer.parseInt(splitInput[i]);

        //Send data to model (Stats)
        Stats stat = new Stats(inputArray, operation);

        //Give output
        TextView output = (TextView)findViewById(R.id.output);
        output.setText(""+stat.getSolution());


    }
}