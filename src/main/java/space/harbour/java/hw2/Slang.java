package main.java.space.harbour.java.hw2;

import java.util.Scanner;

public class Slang {

    static String fixAbbreviations(String str) {
        String[] abbreviations = new String[]{"PLZ", "FYI", "GTFO", "ASAP"};
        String fixed_text = str.replaceAll(abbreviations[0], "please");
        fixed_text = fixed_text.replaceAll(abbreviations[1], "for your information");
        fixed_text = fixed_text.replaceAll(abbreviations[2], "please, leave me alone");
        fixed_text = fixed_text.replaceAll(abbreviations[3], "as soon as possible");
        return fixed_text;
    }

    static String fixSmiles(String str) {
        String[] smilies = new String[]{":\\)", ":\\(", "¯\\_(ツ)_/¯"};
        String fixed_text = str.replaceAll(smilies[0], "[smiling]");
        fixed_text = fixed_text.replaceAll(smilies[1], "[sad]");
        fixed_text = fixed_text.replaceAll(smilies[2], "[such is life]");
        return fixed_text;
    }

    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = fixAbbreviations(input);
        result = fixSmiles(result);

        System.out.println("Result: " + result);
    }
}