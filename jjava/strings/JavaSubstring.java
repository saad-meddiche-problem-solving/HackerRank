package jjava.strings;

import java.util.Scanner;

public class JavaSubstring {

    private static final Scanner scanner = new Scanner(System.in);

    private static String S;

    private static Integer start;

    private static Integer end;


    public static void main(String[] args) {

        scanData();

        System.out.println(S.substring(start, end));
    }

    public static void scanData() {
        S = scanner.next();start = scanner.nextInt();end = scanner.nextInt();
    }

}