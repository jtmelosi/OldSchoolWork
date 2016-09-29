/* Jacob Melosi
 * 8/24/2014
 * Description: This program is to make code within 3 classes that plays a hangman game.
 *              This class is to keep track of most of the game, like revealing letters and keeping track of the partially found word.
 */
package hangman;

public class WordHider {

    // attribute list from outline
    private String hiddenWord;
    private String partiallyFoundWord;

    // action list
    // accessors
    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getPartiallyFoundWord() {
        return partiallyFoundWord;
    }

    // setters
    public void setHiddenWord(String newHiddenWord) {
        hiddenWord = newHiddenWord;
    }

    // utilities
    public int revealLetter(String letter) {
        String[] partiallyFoundWordArray = partiallyFoundWord.split("");
        String[] hiddenWordArray = hiddenWord.split("");
        int numberOfTimes = 0;
        if (letter.length() == 1) {                                 // this if statement checks if what was guessed was 1 letter and then it goes and runs through the method if it was
            int counter = 0;
            String tempWord = "";
            for (int i = 0; i < hiddenWord.length(); i++) {         // this for loop counts how many times the letter occurs
                if (hiddenWordArray[i].equals(letter)) {
                    counter++;
                    partiallyFoundWordArray[i] = letter;
                    numberOfTimes = counter;
                }
                tempWord = ("" + tempWord + partiallyFoundWordArray[i]);
            }
            partiallyFoundWord = tempWord;

            return numberOfTimes;
        } else {
            return 0;
        }
    }

    public boolean wordFound() {
        if (hiddenWord.equals(partiallyFoundWord)) {
            return true;
        } else {
            return false;
        }
    }

    public void hideWord() {
        int hiddenLength = hiddenWord.length();
        String asteriskWord = "";
        for (int i = 0; i < hiddenWord.length(); i++) {
            asteriskWord = (asteriskWord + "*");
        }
        partiallyFoundWord = asteriskWord;
    }

    // my extra methods
    public int getWordLength() {
        int wordLength = hiddenWord.length();
        return wordLength;
    }
    
// used to test
    //private char[] charArray = hiddenWord.toCharArray();
}
