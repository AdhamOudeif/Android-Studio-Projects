package com.cosc426.universitycost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nextButton;
    public static Tuition t; //global static object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize view
        setupView();
    }

    //onClickListener to redirect to second page
    private class ButtonHandlerNext implements View.OnClickListener {
        public void onClick(View v) {
            try {
                //Call the next activity: intent
                Intent secondActivity = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(secondActivity);

            } catch(Exception e) {}
        }
    }

    //function to set up view to beginning
    private void setupView() {
        t = new Tuition();
        ButtonHandlerNext next = new ButtonHandlerNext();
        nextButton = (Button)findViewById(R.id.buttonNext);
        nextButton.setOnClickListener(next);
    }
}
