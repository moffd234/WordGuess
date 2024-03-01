package com.github.zipcodewilmington;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
// Daniel Moffett
public class Hangman {
    final private String[] words = new String[]{"cat", "dog", "bog", "cut"};
    private char[] hiddenWord;
    private char[] displayArray;
    private int lives;
    private final Scanner inputScanner = new Scanner(System.in);
    public Hangman(){}

    public void runGame(){
        boolean replayFlag = true; // Used to play the game again
        while(replayFlag) {
            boolean gameOn = true;

            initializeGameState();
            announceGame();
            displayArray = this.makeDisplayArray();

            while (gameOn) {
                printCurrentState();
                char guess = getNextGuess();
                if(guess == '-'){
                    replayFlag = false;
                    break;
                }
                process(guess);

                // Check lives and update gameOn if needed
                if (lives == 0) {
                    playerLoss();
                    gameOn = false;
                } else if (isWordGuessed()) {
                    playerWon();
                    gameOn = false;
                }
            }

            if (replayFlag && !askToPlayAgain()) {
                gameOver();
                replayFlag = false;
            }
        }
    }

    private void initializeGameState(){
        // Generates a random number before 0 - 1 then multiplies it by 3 (the max index)
        int randomIndex = (int) (Math.random() * 4);
        // Converts the word at the randomIndex to a list of chars and stores it in hiddenWord
        this.hiddenWord = words[randomIndex].toCharArray();
        this.lives = 3;
    }

    private char[] makeDisplayArray(){
        char[] guesses = new char[hiddenWord.length];
        Arrays.fill(guesses, '_');
        return guesses;
    }

    char getNextGuess() { // Modified from the sumOfInput to take a char instead of an int

        System.out.print("Enter a single character: ");
        String input = this.inputScanner.nextLine();
        char character = input.charAt(0); // Gets the first character from the input
        return character;
    }

    private void announceGame(){
        System.out.println("Let's Play Wordguess version 1.0");
    }
    private void gameOver(){
        System.out.println("Game Over.");
    }
    private boolean isWordGuessed(){
        for(int i: this.displayArray){
            if(i == '_') {
                return false;
            }
        }
        return true;
    }
    private boolean askToPlayAgain(){
        System.out.println("Would you like to play again? (yes/no)");
        String answer = inputScanner.nextLine();
        // Returns true if answer == "yes"
        return answer.equalsIgnoreCase("yes");

    }

    private void printCurrentState(){
        System.out.println("You have " + this.lives + " tries left.");
        for(char i: displayArray){  // For each loop
            System.out.print(i + " ");
        }
        System.out.println(); // Prints a new line once done with the for loop
    }

    // loops through the word array, looking for the inputted guess, and
    // replaces the "_" with the guesses char if found
    private void process(char guess){
        boolean found = false;
        for(int i = 0; i < this.hiddenWord.length; i++){

            // Check if guess == value at index
            if(this.hiddenWord[i] == guess){
                this.displayArray[i] = guess;
                found = true;
            }
        }

        // Subtract a life if the guess wasn't found in the word
        if (!found){
            lives -= 1;
        }
    }
    private void playerWon(){
        System.out.println("**** ****");
        printCurrentState();
        System.out.println("Congratulations, You Won!");
    }
    private void playerLoss(){
        System.out.println(":-( :-( :-(");
        printCurrentState();
        System.out.println("You Lost! You ran out of guesses.");
    }

}
