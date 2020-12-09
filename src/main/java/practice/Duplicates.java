package practice;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Duplicates {

    public void findDuplicateWords(String inputString) {
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        String[] inputWords = inputString.split(" ");

        for (String word : inputWords) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else
                wordMap.put(word, 1);
        }

        System.out.println("\nPrinting Duplicate words:\n");

        Set<String> wordSet = wordMap.keySet();
        for (String word : wordSet) {
            if (wordMap.get(word) > 1)
                System.out.println(word + " : " + wordMap.get(word));
        }

    }

    public void findDuplicateChars(String inputString) {
        char[] inputChars = inputString.toCharArray();
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (char ch : inputChars) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            } else
                charMap.put(ch, 1);
        }

        Set<Character> charSet = charMap.keySet();

        for (char ch : charSet) {
            if (charMap.get(ch) > 1)
                System.out.println(ch + " : " + charMap.get(ch));
        }

    }

    public static void main(String args[]) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter input string...\n");
        String inputString = scr.nextLine();

        Duplicates dupes = new Duplicates();
        dupes.findDuplicateWords(inputString);
        dupes.findDuplicateChars(inputString);

    }


}
