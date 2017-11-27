package IndexOfLetters;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner
                .nextLine()
                .toCharArray();

        for (int i = 0; i < input.length; i++) {

            char letter = input[i];
            int position = (int)input[i] - 97;
            System.out.printf("%c" + " -> " + "%d", letter, position);
            System.out.println();
        }
    }
}