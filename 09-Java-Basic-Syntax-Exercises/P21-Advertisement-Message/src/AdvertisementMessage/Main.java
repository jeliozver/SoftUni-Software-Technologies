package AdvertisementMessage;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases =
                {
                        "Excellent product.", "Such a great product.", "I always use that product.",
                        "Best product of its category.", "Exceptional product.", "I can’t live without this product."
                };

        String[] events =
                {
                        "Now I feel good.", "I have succeeded with this product.",
                        "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                        "Try it yourself, I am very satisfied.", "I feel great!"
                };

        String[] authors =
                {
                        "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"
                };

        String[] cities =
                {
                        "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"
                };


        Random randomizer = new Random();

        int messagesToGenerate = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < messagesToGenerate; i++) {

            int phrasesIndex = randomizer.nextInt(phrases.length);
            int eventsIndex = randomizer.nextInt(events.length);
            int authorsIndex = randomizer.nextInt(authors.length);
            int citiesIndex = randomizer.nextInt(cities.length);

            System.out.println(phrases[phrasesIndex] +
                    " " + events[eventsIndex] +
                    " " + authors[authorsIndex] +
                    " - " + cities[citiesIndex]);
        }
    }
}