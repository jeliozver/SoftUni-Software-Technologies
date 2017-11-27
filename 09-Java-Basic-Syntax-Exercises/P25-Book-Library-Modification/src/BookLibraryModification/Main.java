package BookLibraryModification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        TreeMap<String, Date> titlesByDate = new TreeMap<>();
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

        Date startDate = sdf.parse(scanner.nextLine());

        for (Book book : booksList) {
            String title = book.getTitle();
            Date date = book.getReleaseDate();

            if (date.after(startDate)) {
                titlesByDate.put(title, date);
            }
        }

        LinkedHashMap<String, Date> sortedTitlesByDate = new LinkedHashMap<>();

        List<Map.Entry<String, Date>> toSort = new ArrayList<>();
        toSort.addAll(titlesByDate.entrySet());
        toSort.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String, Date> x : toSort) {
            sortedTitlesByDate.put(x.getKey(), x.getValue());
        }

        for (String key : sortedTitlesByDate.keySet()) {

            Date date = sortedTitlesByDate.get(key);
            String dateAsStr = sdf.format(date.getTime());

            System.out.println(key + " -> " + dateAsStr);
        }
    }
}