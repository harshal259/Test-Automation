package practice;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Reversals {

    public void printReverseString() {

    }

    public void printReverseWords(String inputString) {
        String[] words = inputString.split(" ");
        String finalString = "";

        for (String word : words) {
            String reverseWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord = reverseWord + word.charAt(i);
            }
            finalString = finalString + " " + reverseWord;
        }
        System.out.println("Printing String with reversed words...\n" + finalString);
    }


    public static void main(String args[]) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter input string...\n");
        String inputString = scr.nextLine();

        Reversals reverse = new Reversals();
//        reverse.printReverseWords(inputString);
        reverse.printReverseWords(inputString);

    }


}

