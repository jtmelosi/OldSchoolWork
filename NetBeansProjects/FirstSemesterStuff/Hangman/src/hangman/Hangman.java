/* Jacob Melosi
 * 8/24/2014
 * Description: This program is to make code within 3 classes that plays a hangman game.
 *              This class has the main method and grabs methods from other classes to run the game.
 */

package hangman;

import java.util.Scanner;


public class Hangman {
    
    public static final String FILE_NAME = "dictionarycleaned.txt";
    private static final int NUMBER_MISSES = 5;

    public static void main(String[] args) {
        
        int guessesLeft = NUMBER_MISSES;
        String guessedLetter = "";
        
        Scanner kb = new Scanner(System.in);
        Dictionary dict = new Dictionary();         // create a new Dictionary class object
        dict.dictionary();                          // calling the dictionary method from Dictionary
        WordHider WH = new WordHider();             // create a new Word Hider class object
        String selectedWord = dict.getRandomWord(); // gets random word from Dictionary
        WH.setHiddenWord(selectedWord);             // sends the hidden word to WordHider
        WH.hideWord();                              // sets the word to all asterisks to start the game
        
        // used this to test and play with stuff for a bit. going to leave it for future reference
//        String[] a = new String[WH.getWordLength()-1];
//        a = WH.getHiddenWordArray();
//        for (int i = 0;i<=WH.getWordLength()-1;i++){
//        System.out.print(a[i]+ " ");
//        }
        do {
            System.out.println("Word: " + WH.getPartiallyFoundWord() + "    " + "Guesses Left: " + guessesLeft);
            System.out.print("Enter your guess: ");
            guessedLetter = kb.nextLine();
            WH.revealLetter(guessedLetter);
            if(WH.revealLetter(guessedLetter) == 0){
                System.out.println("Miss!");
                guessesLeft--;
            }
        } while ((guessesLeft > 0) && (WH.wordFound() == false));
        System.out.println("Word: " + WH.getPartiallyFoundWord() + "    " + "Guesses Left: " + guessesLeft);
        if (WH.wordFound() == true){
            System.out.println("Yay! You got it!");
        } else if (WH.wordFound() == false){
            System.out.println("You lost, but better luck next time!");
            System.out.println("If you're still curious, your word was " + "'" + WH.getHiddenWord() + "'.");
        }
        
        
        
        
        
        
        
        // test code:
//-         System.out.println(dict.dictionary[1]);
//-         System.out.println(selectedWord);
//-         System.out.println(WH.getPartiallyFoundWord());
//-         System.out.println(WH.getHiddenWord());
//-       String[] a = new String[15];
//        a = WH.getHiddenWordArray();
//        for (int i = 0;i<=5;i++){
//        System.out.print(a[i]+ " ");
//        }
        
        
        
    }
    
}
