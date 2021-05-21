package cosc426.program.mathquizes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   // protected Questions q;
   Questions q = new Questions();
   public boolean entered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entered=false;
        generate();




    }

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

    public void check(){
        //Get Answer
        EditText answerText = (EditText)findViewById(R.id.answer);
        String answerString = answerText.getText().toString();
        int answer;
        try{
            answer = Integer.parseInt(answerString);
        }
        catch (NumberFormatException e){
            answer = 0;
        }

        if(q.checkAnswer(answer)){
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
        TextView left = (TextView)findViewById(R.id.left);
        TextView operation = (TextView)findViewById(R.id.operation);
        TextView right = (TextView)findViewById(R.id.right);
        EditText answer = (EditText) findViewById(R.id.answer);

        //Set values
        left.setText(""+q.getLeft());
        operation.setText(""+q.getOperation());
        right.setText(""+q.getRight());
        answer.setText("");
        answer.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}