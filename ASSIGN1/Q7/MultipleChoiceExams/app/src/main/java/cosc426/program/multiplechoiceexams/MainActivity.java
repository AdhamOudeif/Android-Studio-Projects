package cosc426.program.multiplechoiceexams;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Questions q = new Questions();
    public boolean entered;
    public int userAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entered=false;
        generate();
    }
//next button , also check if entered submission
    public void next(View view) {
        if(entered){
            generate();
            entered = false;
        }
    }


    public void submit(View view) {
        if(!entered){
            check();
            entered = true;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.answer1:
                if (checked)
                    userAnswer = 1;

                break;
            case R.id.answer2:
                if (checked)
                    userAnswer = 2;

                break;
            case R.id.answer3:
                if (checked)
                    userAnswer = 3;

                break;
            case R.id.answer4:
                if (checked)
                    userAnswer=4;

                break;
        }
    }




    public void check(){

        if(q.checkAnswer(userAnswer)){
            TextView feedback = (TextView)findViewById(R.id.feedback);
            feedback.setText("Correct!");
        }else{
            TextView feedback = (TextView)findViewById(R.id.feedback);
            feedback.setText("Incorrect");
        }
        TextView score = (TextView)findViewById(R.id.score);
        score.setText(q.getCorrect() + " / " + q.getQuestions());
    }

    public void generate(){
        q.generate();

        //Get TextViews
        TextView question = (TextView)findViewById(R.id.question);
        TextView answer1 = (TextView)findViewById(R.id.answer1);
        TextView answer2 = (TextView)findViewById(R.id.answer2);
        TextView answer3 = (TextView)findViewById(R.id.answer3);
        TextView answer4 = (TextView)findViewById(R.id.answer4);


        //Set values
        question.setText(""+q.getQuestion());
        answer1.setText(""+q.getAnswer1());
        answer2.setText(""+q.getAnswer2());
        answer3.setText(""+q.getAnswer3());
        answer4.setText(""+q.getAnswer4());
    }
}
