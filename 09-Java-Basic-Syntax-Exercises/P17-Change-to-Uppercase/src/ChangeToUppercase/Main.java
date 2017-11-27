package ChangeToUppercase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String tagOpen = "<upcase>";
        String tagClose = "</upcase>";
        int tagOpenIndex = input.indexOf(tagOpen);
        int tagCloseIndex = input.indexOf(tagClose);

        while (tagOpenIndex != -1 && tagCloseIndex != -1) {

            String replacement = input
                    .substring(tagOpenIndex + tagOpen.length(), tagCloseIndex)
                    .toUpperCase();

            String toReplace = input.substring(tagOpenIndex, tagCloseIndex + tagClose.length());

            input = input.replaceAll(toReplace, replacement);

            tagOpenIndex = input.indexOf(tagOpen);
            tagCloseIndex = input.indexOf(tagClose);
        }

        System.out.println(input);
    }
}