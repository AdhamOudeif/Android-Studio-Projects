package cosc426.program.guessinggame;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView guesses;
    TextView feedback;
    Game game;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get input and output
        input = (EditText)findViewById(R.id.input);
        guesses = (TextView) findViewById(R.id.guesses);
        feedback = (TextView) findViewById(R.id.response);

        //Button Handler
        Button button = (Button)findViewById(R.id.enter);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);

        //Starts first game on instance of first screen.
        game = new Game();
        startGame();

        //guesses.setBackgroundColor(Color.parseColor("#00FF00"));

    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Toast
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;

            //get guess
            String inputString = input.getText().toString();
            int guess;

            //error catch
            try {
                guess = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                Toast toast = Toast.makeText(context, "No Entry", toastD);
                toast.show();
                return;
            }

            if (guess <= 0 || guess > 100) {
                Toast toast = Toast.makeText(context, "Invalid Guess", toastD);
                toast.show();
                return;
            }
            //check Guess. If WIN:
            if(game.check(guess)){
                endGame(true);
                return;
            }
            //if Loss:
            if(game.checkGuesses()){
                endGame(false);
                return;
            }
            //Feedback
            feedback.setText(game.feedback(guess));

            //Update guesses
            guesses.setText(game.getGuesses()+"");
            input.setText("");
            //color change
            int colorguess = game.getGuesses();
            if(colorguess >= 6){
                guesses.setBackgroundColor(Color.parseColor("#B2FF66"));
            }else if (colorguess >= 4){
                guesses.setBackgroundColor(Color.parseColor("#FFFF00"));
            }else if (colorguess >= 2){
                guesses.setBackgroundColor(Color.parseColor("#FF0000"));
            }

        }
    }

    private void startGame(){
        //set and reset
        guesses.setText("8");
        feedback.setText("");
        input.setText("");
        game.newGame();
        guesses.setBackgroundColor(Color.parseColor("#00FF00"));
    }

    //End game messages
    private void endGame(boolean win){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);
        if(win){
            dialogBox.setMessage("You Win! Try Again?");
        }
        else{
            dialogBox.setMessage("You Lose! Try Again?");
        }
        //Response buttons with listeners
        DialogBoxListener temp = new DialogBoxListener();
        dialogBox.setPositiveButton("Yes", temp);
        dialogBox.setNegativeButton("No", temp);
        dialogBox.setNeutralButton("Cancel", temp);
        dialogBox.show();
    }

    private class DialogBoxListener implements DialogInterface.OnClickListener{
        public void onClick(DialogInterface dialog, int id){
            if(id == -1){
                startGame();
            }
            else if( id == -1 ){
                MainActivity.this.finish();
            }
        }
    }
}