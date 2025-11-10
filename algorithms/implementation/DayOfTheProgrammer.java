package algorithms.implementation;

import java.io.*;

/**
 * The 256th day of the year in Russia for a given year between 1700 and 2700.
 * - In a common year, the 256th day falls on September 13.
 * - In a leap year, it falls on September 12.
 * - The year 1918 is a special case where the 256th day falls on September 26 due to the transition from the Julian to the Gregorian calendar.
 * */

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static void main(String[] args) {
        System.out.println(dayOfProgrammer(1918));
    }

    static int sumOfDaysOfFirst8Month = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;

    public static String dayOfProgrammer(int year) {

        // Day of transition
        if(year == 1918) return "26.09.1948";

        Calendar calendarSystem = Result.determineCalendarSystem(year);

        return calendarSystem.dateOf256Day(year);

    }

    static Calendar determineCalendarSystem(int year) {

        if(year >= 1700 && year <= 1917) {
            return new JULIANCalendarSystem();
        }

        return new GREGORIANCalendarSystem();
    }

    static class JULIANCalendarSystem extends Calendar {

        public boolean isLeapYear(int year) {
            return year % 4 == 0;
        }

    }

    static class GREGORIANCalendarSystem extends Calendar {

        public boolean isLeapYear(int year) {
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }

    }

    static abstract class Calendar {

        abstract boolean isLeapYear(int year);

        String dateOf256Day(int year) {

            int day;

            if(isLeapYear(year)) {
                day = 256 - sumOfDaysOfFirst8Month - 1;
            } else {
                day = 256 - sumOfDaysOfFirst8Month;
            }

            return day + ".09." + year;
        }

    }

}

public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}