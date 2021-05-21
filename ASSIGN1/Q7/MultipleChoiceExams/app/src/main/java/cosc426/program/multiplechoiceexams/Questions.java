package cosc426.program.multiplechoiceexams;

import android.view.View;
import android.widget.RadioButton;

import java.util.Random;

public class Questions {
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String question;
    private int questions;
    private int correct;
    private Random generator;
    private int TheAnswer;
    private int nextinteger;

    public Questions(){

        answer1 = "?";
        answer2 = "?";
        answer3 = "?";
        answer4 = "?";
        question = "?";
        TheAnswer=0;
        questions = 0;
        correct = 0;
        //generator = new Random();
        nextinteger = 0;

    }

    public void generate(){
        int nextOperation = nextinteger++;
        switch (nextOperation){
            case 0:
                //Addition
                answer1 = "Georges Saint Pierre";
                answer2 = "Mr. Bean";
                answer3 = "Jon Jones";
                answer4 = "Khabib the EAGLE Nurmagomedov";
                question = "Who is the GOAT of UFC?";
                TheAnswer=4;
                break;
            case 1:
                //subtraction
                answer1 = "Ertugrul Ghazi Oglu Osman Bey";
                answer2 = "Suleyman Shah Oglu Ertugrul Bey";
                answer3 = "Ghengis Khan";
                answer4 = "Amir Khan";
                question = "Who came from the great steppe and conquered the world on horse back?";
                TheAnswer = 3;
                break;
            case 2:
                //multiplication
                answer1 = "William Sverdilk";
                answer2 = "Li Zhang";
                answer3 = "Suchindran Maniccam";
                answer4 = "Ranjan Chaudri";
                question = "Who is the MASTER of MACHINE UNIVERSE?";
                TheAnswer = 2;
                break;
            case 3:
                //Division
                answer1 = "1 day";
                answer2 = "2 days";
                answer3 = "3 days";
                answer4 = "7 days";
                question = "How many days before the due date did I start this Assignment?";
                TheAnswer=1;
                break;
            case 4:
                //Division
                answer1 = "No";
                answer2 = "Maybe yes Maybe no";
                answer3 = "Definitely yes";
                answer4 = "Yes";
                question = "Please can you give me an A on this assignment?";
                TheAnswer=3;
                break;

            case 5:
                //Division
                answer1 = "A distributed ledger on a peer to peer network";
                answer2 = "A type of crypto currency";
                answer3 = "An exchange";
                answer4 = "A centralized Ledger";
                question = "What is blockchain?";
                TheAnswer=1;
                break;
        }
    }

    public boolean checkAnswer(int user){
        questions ++; //Update Questions Answered
        if(user == TheAnswer) {
            correct ++;//Update correct
            return true;
        }
        return false; //else
    }






    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getQuestion(){
        return question;
    }

    public int getTheAnswer(){
        return TheAnswer;
    }




    public int getCorrect() {
        return correct;
    }

    public int getQuestions() {
        return questions;
    }
}
