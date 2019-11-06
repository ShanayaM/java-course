package main.java.space.harbour.java.hw2;

import java.util.Scanner;

public final class Slang {

    static String fixAbbreviations(final String str) {
        String match_pattern = str.replaceAll("PLZ", "please");
        match_pattern = match_pattern.replaceAll("FYI",
                                                 "for your information");
        match_pattern = match_pattern.replaceAll("GTFO",
                                                 "please, leave me alone");
        match_pattern = match_pattern.replaceAll("ASAP",
                                                 "as soon as possible");
        return match_pattern;
    }

    static String fixSmiles(final String str) {
        String[] smilies = new String[]{":\\)", ":\\(",
                                        "¯\\_(ツ)_/¯"};
        String match_pattern = str.replaceAll(smilies[0], "[smiling]");
        match_pattern = fixed_text.replaceAll(smilies[1], "[sad]");
        match_pattern = fixed_text.replaceAll(smilies[2], "[such is life]");
        return match_pattern;
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
