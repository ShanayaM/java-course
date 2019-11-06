package main.java.space.harbour.java.hw2;

import java.util.Scanner;

final class Slang {

    static String fixAbbreviations(final String str) {
        String matchPattern = str.replaceAll("PLZ", "please");
        matchPattern = matchPattern.replaceAll("FYI",
                                                 "for your information");
        matchPattern = matchPattern.replaceAll("GTFO",
                                                 "please, leave me alone");
        matchPattern = matchPattern.replaceAll("ASAP",
                                                 "as soon as possible");
        return matchPattern;
    }

    static String fixSmiles(final String str) {
        String[] smilies = new String[]{":\\)", ":\\(",
                                        "¯\\_(ツ)_/¯"};
        String matchPattern = str.replaceAll(smilies[0], "[smiling]");
        matchPattern = matchPattern.replaceAll(smilies[1], "[sad]");
        matchPattern = matchPattern.replaceAll(smilies[2], "[such is life]");
        return matchPattern;
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
