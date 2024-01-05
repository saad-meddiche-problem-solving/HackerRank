package jjava.strings.v15;

import java.util.Scanner;

public class JavaStringsIntroduction {

    private static final Scanner scanner = new Scanner(System.in);

    private static String A;

    private static String B;

    public static void main(String[] args) {

        scanData();

        Long sumOfLenghts = (long) A.length() + (long) B.length();

        System.out.println(sumOfLenghts);

        System.out.println(lexicographicalCompare());

        System.out.print(capitalize(A));
        System.out.print(" ");
        System.out.print(capitalize(B));


    }

    public static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static String lexicographicalCompare() {
        return A.compareTo(B) > 0 ? "Yes" : "No";
    }

    public static void scanData() {
        A=scanner.next();B=scanner.next();
    }

}