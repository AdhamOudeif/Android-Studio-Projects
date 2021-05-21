package cosc426.program.isprime;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Calculator calculator;
    AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new Calculator();
        appInterface = new AppInterface(this);
        ButtonHandler buttonHandler = new ButtonHandler();
        appInterface.setEventHandlers(buttonHandler);
        setContentView(appInterface);
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            int price = appInterface.getPrime();
            calculator.setPrime(price);
            appInterface.setOutput(calculator.getOutput());
        }
    }
}