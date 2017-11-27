package CountWorkingDays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        String dateOne = scanner.nextLine();
        Date date = sdf.parse(dateOne);
        Calendar startDate = Calendar.getInstance();
        startDate.setTime(date);

        String dateTwo = scanner.nextLine();
        date = sdf.parse(dateTwo);
        Calendar endDate = Calendar.getInstance();
        endDate.setTime(date);
        endDate.add(Calendar.DATE, 1);

        int workingDays = 0;

        while  (!startDate.equals(endDate)) {
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
                    !IsHolidayInBulgaria(startDate)) {

                workingDays++;
            }

            startDate.add(Calendar.DATE, 1);
        }

        System.out.println(workingDays);
    }

    public static boolean IsHolidayInBulgaria(Calendar startDate) {

        int month = startDate.get(Calendar.MONTH);
        int day = startDate.get(Calendar.DATE);
        month++;
        String dateAsString = day + "-" + month;

        String[] holidaysInBulgaria = { "1-1", "3-3", "1-5",
                "6-5", "24-5", "6-9", "22-9",
                "1-11", "24-12", "25-12", "26-12" };

        return Arrays.asList(holidaysInBulgaria).contains(dateAsString);
    }
}