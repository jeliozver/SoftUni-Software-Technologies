package LargestThreeNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);

        int count = Math.min(3, nums.length);
        int index = nums.length - 1;

        while (count > 0) {
            System.out.println(nums[index]);
            count--;
            index--;
        }
    }
}