package ReverseString;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToReverse = scanner.nextLine();

        String reversed = ReverseString(stringToReverse);

        System.out.println(reversed);
    }

    public static String ReverseString(String str)
    {
        StringBuilder builder = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            builder.append(str.charAt(i));
        }

        return builder.toString();
    }
}