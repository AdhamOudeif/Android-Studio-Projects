package cosc426.program.retirementsavingplan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void generateButton(View view) {
        //Get EditTexts
        EditText principleText = (EditText)findViewById(R.id.Principal);
        EditText additionText = (EditText)findViewById(R.id.AnnAdd);
        EditText yearsText = (EditText)findViewById(R.id.Years);
        EditText rateText = (EditText)findViewById(R.id.Rate);

        //Get Strings
        String principle = principleText.getText().toString();
        String addition = additionText.getText().toString();
        String years = yearsText.getText().toString();
        String rate = rateText.getText().toString();


        //Get Floats
        Float p = Float.parseFloat(principle);
        Float a = Float.parseFloat(addition);
        Float n = Float.parseFloat(years);
        Float r = Float.parseFloat(rate);

        boolean error = false;

        //Error Check
        if(!(p > (float)-1)) {
            principleText.setBackgroundColor(Color.parseColor("#FF0000"));
            error = true;
        }
        else
            principleText.setBackgroundColor(Color.parseColor("#DFDFDF"));
        if(!(a > (float)0.0)) {
            additionText.setBackgroundColor(Color.parseColor("#FF0000"));
            error = true;
        }
        else
            additionText.setBackgroundColor(Color.parseColor("#DFDFDF"));
        if(!(n > (float)0.0)) {
            yearsText.setBackgroundColor(Color.parseColor("#FF0000"));
            error = true;
        }
        else
            yearsText.setBackgroundColor(Color.parseColor("#DFDFDF"));
        if(r > (float)100.0) {
            rateText.setBackgroundColor(Color.parseColor("#FF0000"));
            error = true;
        }
        else
            rateText.setBackgroundColor(Color.parseColor("#DFDFDF"));

        if(!error){
            //Calc
            Retirement s = new Retirement(p,a,n,r);
            //Out
            TextView output = (TextView)findViewById(R.id.cpInt);
            output.setText("$" + s.getAmount());
            //MONEH?
            if (s.getAmount() > ((p*0.3))+p){
                output.setBackgroundColor(Color.parseColor("#DDFFEE"));
            }
            else
                output.setBackgroundColor(Color.parseColor("#FF0000"));
        }
        //obsolete



    }
}