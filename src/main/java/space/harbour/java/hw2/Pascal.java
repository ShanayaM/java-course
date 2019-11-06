package main.java.space.harbour.java.hw2;

import java.util.Scanner;

final class Pascal {
    
    private Pascal() {
        // Prevent instantiation
    }

    static void printTriangle(final int n) {

        for (int line = 1; line <= n; line++) {
            int c = 1;
            for (int i = 1; i <= line; i++) {
                System.out.print(c + " ");
                c = c * (line - i) / i;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        int input = scanner.nextInt();

        printTriangle(input);
    }
}
