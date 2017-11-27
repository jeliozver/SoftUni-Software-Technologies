package BombNumbers;

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

        int[] arguments = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int specialNumber = arguments[0];
        int bombPower = arguments[1];

        boolean hasDetonationsStopped = true;

        while (hasDetonationsStopped)
        {
            hasDetonationsStopped = false;

            int startIndex = 0;
            int detonated = 0;

            for (int i = 0; i < numbers.length; i++)
            {
                if (numbers[i] == specialNumber)
                {
                    startIndex = i - bombPower;

                    if (startIndex < 0)
                    {
                        startIndex = 0;
                    }

                    detonated = i + bombPower + 1;

                    if (detonated > numbers.length)
                    {
                        detonated = numbers.length;
                    }

                    hasDetonationsStopped = true;
                    break;
                }
            }

            if (hasDetonationsStopped)
            {
                int [] remainingLeft = Arrays
                        .stream(numbers)
                        .limit(startIndex)
                        .toArray();

                int [] remainingRight = Arrays
                        .stream(numbers)
                        .skip(detonated)
                        .toArray();

                numbers = concatArrays(remainingLeft, remainingRight);
            }
        }

        int sum = IntStream.of(numbers).sum();

        System.out.println(sum);
    }

    public static int[] concatArrays(int[] a, int[] b)
    {
        int aLen = a.length;
        int bLen = b.length;

        int[] c = new int[aLen + bLen];

        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);

        return c;
    }
}