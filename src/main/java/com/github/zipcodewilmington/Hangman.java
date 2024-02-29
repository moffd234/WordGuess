package com.github.zipcodewilmington;


/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
// Daniel Moffett
public class Hangman {
    final private String[] words = new String[]{"cat", "dog", "bog", "cut"};
    private char[] hiddenWord;
    public Hangman(){
        // Generates a random number before 0 - 1 then multiplies it by 3 (the max index)
        int randomIndex = (int) (Math.random() * 4);
        // Converts the word at the randomIndex to a list of chars and stores it in hiddenWord
        hiddenWord = words[randomIndex].toCharArray();
        System.out.println(hiddenWord);
    }

}
