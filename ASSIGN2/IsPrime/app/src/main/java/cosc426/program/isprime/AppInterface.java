package cosc426.program.isprime;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppInterface extends RelativeLayout {
    //Interaction
    private EditText primeText;
    private TextView outputText;
    private Button button;

    public AppInterface(Context context){
        super(context);
        //Get DP value
        final int DP = (int)(getResources().getDisplayMetrics().density);

        //Prime Label
        TextView primeLabel = new TextView(context);
        primeLabel.setId(TextView.generateViewId());
        primeLabel.setTextColor(Color.parseColor("#000000"));
        primeLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        primeLabel.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        primeLabel.setText("Prime");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.leftMargin = 150*DP;
        params.topMargin = 150*DP;
        primeLabel.setLayoutParams(params);
        addView(primeLabel);

        //prime input
        primeText = new EditText(context);
        primeText.setId(EditText.generateViewId());
        primeText.setTextColor(Color.parseColor("#000000"));
        primeText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        primeText.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        primeText.setHint("2");
        primeText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.RIGHT_OF, primeLabel.getId());
        params.addRule(RelativeLayout.ALIGN_BOTTOM, primeLabel.getId());
        primeText.setLayoutParams(params);
        addView(primeText);

        //Output label
        TextView outputLabel = new TextView(context);
        outputLabel.setId(TextView.generateViewId());
        outputLabel.setTextColor(Color.parseColor("#000000"));
        outputLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        outputLabel.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        outputLabel.setText("Prime:");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, primeLabel.getId());
        params.addRule(RelativeLayout.ALIGN_LEFT, primeLabel.getId());
        outputLabel.setLayoutParams(params);
        addView(outputLabel);

        //The output
        outputText = new TextView(context);
        outputText.setId(TextView.generateViewId());
        outputText.setTextColor(Color.parseColor("#000000"));
        outputText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        outputText.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        outputText.setHint("True");
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.RIGHT_OF, outputLabel.getId());
        params.addRule(RelativeLayout.ALIGN_BOTTOM, outputLabel.getId());
        outputText.setLayoutParams(params);
        addView(outputText);

        //Button
        button = new Button(context);
        button.setId(Button.generateViewId());
        button.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        button.setText("Submit");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.topMargin = 40*DP;
        params.addRule(RelativeLayout.BELOW, outputLabel.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        button.setLayoutParams(params);
        addView(button);
    }
    //Set Button Listener
    public void setEventHandlers(View.OnClickListener buttonHandler){
        button.setOnClickListener(buttonHandler);
    }

    //Get prime
    public int getPrime(){
        String primeString = primeText.getText().toString();
        int prime;
        try{
            prime = Integer.parseInt(primeString);
        }catch (NumberFormatException e){
            prime = 0;
        }
        return prime;
    }

    //Set Output
    public void setOutput(String output){
        outputText.setText(output);
    }
}
