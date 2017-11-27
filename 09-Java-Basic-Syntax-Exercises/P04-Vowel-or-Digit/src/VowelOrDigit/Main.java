package VowelOrDigit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toUpperCase();
        char value = input.charAt(0);

        if (value >= 48 && value <= 57) {
            System.out.println("digit");
        } else if (value == 'A' ||
                value == 'E' ||
                value == 'I' ||
                value == 'O' ||
                value == 'U') {
            System.out.println("vowel");
        } else {
            System.out.println("other");
        }
    }
}