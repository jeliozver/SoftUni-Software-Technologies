package SymmetricNumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (isSymmetric(i)) {

                builder.append(i);
                builder.append(" ");
            }
        }

        System.out.println(builder.toString().trim());
    }

    public static boolean isSymmetric(int num) {

        int n = num;
        int rev = 0;

        while (num > 0)
        {
            int dig = num % 10;
            rev = rev * 10 + dig;
            num = num / 10;
        }

        if (n == rev)
        {
            return true;
        }

        return false;
    }
}