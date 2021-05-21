package cosc426.program.guessinggame;

import java.util.Random;

public class Game {
    private int guesses;
    private int number;

    public Game(){
        guesses = 8;
    }

    public void newGame(){
        //New number and reset guesses
        Random generator = new Random();
        guesses = 8;
        number = generator.nextInt(100)+1;
    }

    public boolean check(int guess){
        guesses--;
        return guess == number;
    }

    public boolean checkGuesses(){
        return guesses <= 0;
    }

    public String feedback(int guess){
        if(guess > number)
            return "The Number is less than" + guess;
        else
            return "The Number is greater than" + guess;
    }

    public int getGuesses() {
        return guesses;
    }
}