package FitStringIn20Chars;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (input.length() > 20) {
            input = input.substring(0, 20);
        } else if (input.length() < 20) {
           input = AddStars(input);
        }

        System.out.println(input);
    }

    public static String AddStars(String str) {
        StringBuilder builder = new StringBuilder();
        int starsCount = 20 - str.length();
        int diff = 20 - starsCount;

        for (int i = 0; i < diff; i++) {
            builder.append(str.charAt(i));
        }

        for (int i = 0; i < starsCount; i++) {
            builder.append('*');
        }

        return builder.toString();
    }
}