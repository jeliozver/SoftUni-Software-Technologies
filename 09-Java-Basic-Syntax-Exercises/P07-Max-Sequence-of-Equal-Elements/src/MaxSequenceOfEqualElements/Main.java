package MaxSequenceOfEqualElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentStart = 0;
        int currentLength = 1;
        int bestStart = 0;
        int bestLength = 1;

        for (int i = 1; i < numbers.length; i++)
        {

            if (numbers[i] == numbers[currentStart])
            {
                currentLength++;

                if (currentLength > bestLength)
                {
                    bestStart = currentStart;
                    bestLength = currentLength;
                }
            }
            else
            {
                currentStart = i;
                currentLength = 1;
            }
        }

        for (int i = bestStart; i < bestStart + bestLength; i++)
        {
            System.out.printf("%d ", numbers[i]);
        }

        System.out.println();
    }
}