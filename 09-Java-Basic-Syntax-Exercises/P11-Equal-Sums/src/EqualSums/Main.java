package EqualSums;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqualSumsFound = false;

        for (int i = 0; i < numbers.length; i++)
        {
            int[] leftSide = Arrays
                    .stream(numbers)
                    .limit(i)
                    .toArray();

            int[] rightSide = Arrays
                    .stream(numbers)
                    .skip(i + 1)
                    .toArray();

            if (IntStream.of(leftSide).sum() == IntStream.of(rightSide).sum())
            {
                System.out.printf("%d", i);
                System.out.println();
                isEqualSumsFound = true;
                break;
            }
        }

        if (!isEqualSumsFound)
        {
            System.out.println("no");
        }
    }
}