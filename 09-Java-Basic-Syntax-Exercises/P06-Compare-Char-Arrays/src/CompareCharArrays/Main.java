package CompareCharArrays;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayOne = scanner
                .nextLine()
                .split(" ");

        String[] arrayTwo = scanner
                .nextLine()
                .split(" ");


        String[] firstArray;
        String[] secondArray;

        int shorterArray = Math.min(arrayOne.length, arrayTwo.length);
        boolean isArrayOneFirst = false;
        boolean isArrayTwoFirst = false;

        for (int i = 0; i < shorterArray; i++) {
            if (arrayOne[i].charAt(0) < arrayTwo[i].charAt(0)) {
                isArrayOneFirst = true;
                break;
            }
            if (arrayOne[i].charAt(0) > arrayTwo[i].charAt(0)) {
                isArrayTwoFirst = true;
                break;
            }
            if (arrayOne[i].charAt(0) != arrayTwo[i].charAt(0)) {
                break;
            }
        }

        if (isArrayOneFirst) {
            firstArray = arrayOne;
            secondArray = arrayTwo;
        } else if (isArrayTwoFirst) {
            firstArray = arrayTwo;
            secondArray = arrayOne;
        } else {
            firstArray = arrayOne;
            secondArray = arrayTwo;

            if (arrayOne.length >= arrayTwo.length) {
                firstArray = arrayTwo;
                secondArray = arrayOne;
            }
        }

        System.out.println(String.join("", firstArray));
        System.out.println(String.join("", secondArray));
    }
}