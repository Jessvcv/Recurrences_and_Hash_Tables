import java.util.*;
import java.util.regex.Pattern;

public class WordPattern {
    public static boolean followsPattern(String p, char d, String s) {
        //split input string into words using delimiter
        String[] words = s.split(Pattern.quote(String.valueOf(d)));

        //false if the number of words does not match the pattern length
        if (words.length != p.length()) return false;

        //stores the bijection between characters and words
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        //iterate through the pattern and corresponding words
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            String word = words[i];

            //check if character is mapped to different word
            if (charToWord.containsKey(c) && !charToWord.get(c).equals(word)) return false;

            //check if word is mapped to different character
            if (wordToChar.containsKey(word) && wordToChar.get(word) != c) return false;

            //establish bijection
            charToWord.put(c, word);
            wordToChar.put(word, c);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(followsPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(followsPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(followsPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(followsPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(followsPattern("adxp", ' ', "ice cream taco day")); // true
    }
}
