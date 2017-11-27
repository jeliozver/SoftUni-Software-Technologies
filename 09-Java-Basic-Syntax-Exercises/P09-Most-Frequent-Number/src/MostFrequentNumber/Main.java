package MostFrequentNumber;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int longestStreak = 0;
        int mostFrequentNumber = 0;

        for (int i = 0; i < numbers.length; i++) {
            int counter = 0;

            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == numbers[i]) {
                    counter++;
                }
            }

            if (counter > longestStreak) {
                longestStreak = counter;
                mostFrequentNumber = numbers[i];
            }
        }

        System.out.println(mostFrequentNumber);
    }
}