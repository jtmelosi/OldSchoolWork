/* Jacob Melosi
 * 8/24/2014
 * Description: This program is to make code within 3 classes that plays a hangman game.
 *              This class grabs words from a text file and puts them in an array to be used.
 */
package hangman;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Dictionary {
    
    Random rand = new Random();

    private static final String FILE_NAME = "dictionarycleaned.txt";
    private static final int numberOfWords = 81452;
    
    private String[] dictionary = new String[numberOfWords];
    private String word;
    int currentWord = 0;
    
    public void dictionary(){
        
    Scanner fin = null;
        // try and catch for the files
        try {
            fin = new Scanner(new File(FILE_NAME));
        }catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + FILE_NAME);
        System.exit(1);
        }// end try
        
        while (fin.hasNextLine()){
            word = fin.nextLine();
            dictionary[currentWord] = word;
            currentWord++;
        }
    }
        
    public String getRandomWord(){
        String randomWord;
        randomWord = dictionary[rand.nextInt(numberOfWords)];
        return randomWord;
    }
        
}
