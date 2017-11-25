package SumsByTown;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTowns = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> sumsByTown = new TreeMap<>();

        for (int i = 0; i < numberOfTowns; i++) {
            String[] arguments = scanner
                    .nextLine()
                    .split("\\|");

            String townName = arguments[0].trim();
            double townIncome = Double.parseDouble(arguments[1].trim());

            if (!sumsByTown.containsKey(townName)) {
                sumsByTown.put(townName, townIncome);
            } else {
                sumsByTown.put(townName, townIncome + sumsByTown.get(townName));
            }
        }

        for (String town : sumsByTown.keySet()) {
            System.out.println(town + " -> " + sumsByTown.get(town));
        }
    }
}