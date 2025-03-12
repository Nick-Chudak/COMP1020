import java.util.ArrayList;

public class Lab6Ex1 {

  public static void main(String [] args) {
    String[] strings = createStringArray();
    ArrayList<Word> words = stringsToWords(strings);

    printWordList(words);
    System.out.printf("\nAverage word length: %.3f\n", averageWordLength(words));
		
    System.out.println("\nEnd of processing.");
  }

  public static String[] createStringArray() {
    // Unusual construction! Not something we typically use.
    return new String[] {
      "O my Luve's like a red, red rose, That's newly sprung in June.",
      "O my Luve's like the melodie, That's sweetly play'd in tune.",
      "As fair art thou, my bonie lass, So deep in luve",
      "am I; And I will luve thee still, my dear, Till a' the seas gang dry."
    };
  }
	
  public static ArrayList<Word> stringsToWords(String[] s) {
    ArrayList<Word> result = new ArrayList<>();
    Word w;
    String[] tokens;

    for (int i = 0; i < s.length; i++) {
      // The line below splits on space and punctuation, and makes all
      // the words lower-case
      tokens = s[i].split("[ ,;.]+");
      for (int j = 0; j < tokens.length; j++) {
        String word = tokens[j].toLowerCase();
        w = findWord(result, word);
        if (w == null)
          result.add(new Word(word));
        else
          // Exercise 1: increase the count of times w appears
          w.increaseFrequency();
      }
    }
		
    return result;
  }

  // Exercise 1: linear search for a word in the array list
  public static Word findWord(ArrayList<Word> words, String word) {
    // This should return a reference to the matching word
    // or null if no match was found
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).getWord().equals(word)) {
        return words.get(i);
      }      
    }
    return null;
  }
	
  public static void printWordList(ArrayList<Word> words) {
    for (int i = 0; i < words.size(); i++)
      System.out.println(words.get(i));
  }
	
  public static double averageWordLength(ArrayList<Word> words) {
    int total = 0;
		
    for (int i = 0; i < words.size(); i++) {
      // Exercise #2: This should get the number of letters in the word
      total += (words.get(i).getWord().length());
    }
		
    return (double)total / words.size();
  }
}

class Word {
  private String word;
  private int frequency;

  public Word(String w) {
    word = w;
    frequency = 1;
  }
	
  // Exercise 1: Add methods to this class
  public void increaseFrequency() {
    this.frequency += 1;
  }
  // Exercise 2: Add methods to this class
  public String getWord() {
    return this.word;
  }

  public int getFrequency() {
    return this.frequency;
  }
  public String toString() {
    return "Word: '" + word + "' frequency: " + frequency;
  }
}