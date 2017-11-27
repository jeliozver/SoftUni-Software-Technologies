package BookLibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Map<String, Double> pricesByAuthors = new TreeMap<>();
        LinkedList<Book> booksList = new LinkedList<>();

        int numberOfBooks = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfBooks; i++) {
            String[] currentInfo = scanner.nextLine()
                    .split(" ");

           Book book = new Book();
           book.setTitle(currentInfo[0]);
           book.setAuthor(currentInfo[1]);
           book.setPublisher(currentInfo[2]);
           book.setReleaseDate(sdf.parse(currentInfo[3]));
           book.setIsbnNumber(currentInfo[4]);
           book.setPrice(Double.parseDouble(currentInfo[5]));
           booksList.add(book);
        }

        for (Book book : booksList) {
            String name = book.getAuthor();
            double price = book.getPrice();
            if (pricesByAuthors.containsKey(book.getAuthor())) {
                pricesByAuthors.put(name, pricesByAuthors.get(name) + price);
            } else {
                pricesByAuthors.put(name, price);
            }
        }

        Map<String, Double> sortedAuhorsByPrice = new LinkedHashMap<>();

        List<Map.Entry<String, Double>> toSort = new ArrayList<>();
        for (Map.Entry<String, Double> x : pricesByAuthors.entrySet()) {
            toSort.add(x);
        }
        toSort.sort(Map.Entry.<String, Double>comparingByValue().reversed());
        for (Map.Entry<String, Double> x : toSort) {
            sortedAuhorsByPrice.put(x.getKey(), x.getValue());
        }

        for (String key : sortedAuhorsByPrice.keySet()) {

            System.out.printf("%s -> %1.2f\n", key, sortedAuhorsByPrice.get(key));
        }
    }
}