package ReverseCharacters;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] result = new String[3];

        for (int i = 0; i < 3; i++) {

            String input = scanner.nextLine();

            result[i] = input;
        }

        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }
}