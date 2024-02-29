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
    public Hangman(){}

    public void runGame(){
        initializeGameState();
        displayArray = this.makeDisplayArray();
        printCurrentState();
    }

    private void initializeGameState(){
        // Generates a random number before 0 - 1 then multiplies it by 3 (the max index)
        int randomIndex = (int) (Math.random() * 4);
        // Converts the word at the randomIndex to a list of chars and stores it in hiddenWord
        this.hiddenWord = words[randomIndex].toCharArray();
        System.out.println(hiddenWord);
    }

    private char[] makeDisplayArray(){
        char[] guesses = new char[hiddenWord.length];
        Arrays.fill(guesses, '_');
        return guesses;
    }

    static char getNextGuess() { // Modified from the sumOfInput to take a char instead of an int
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a single character: ");
        char character = scan.nextLine().charAt(0); // Gets first character from the input
                                                    // while also consuming the newLine character

        scan.close();
        return character;
    }

    private void announceGame(){
        System.out.println("Let's Play Wordguess version 1.0");
    }
    private void gameOver(){}
    private boolean isWordGuessed(){return false;}
    private boolean askToPlayAgain(){return false;}
    private void printCurrentState(){
        for(int i: displayArray){  // For each loop
            System.out.print(displayArray[i]);
        }
    };
    private void process(){};
    private void playerWon(){
        System.out.println("Congratulations, You Won!");
    };
    private void playerLoss(){
        System.out.println("You Lost! You ran out of guesses.");
    };

}
