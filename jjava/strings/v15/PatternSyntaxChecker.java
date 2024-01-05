package jjava.strings.v15;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;

public class PatternSyntaxChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        scanner.nextLine();

        IntStream.range(0, testCases).forEach(i -> {
            String pattern = scanner.nextLine();
            System.out.println(checkPattern(pattern));
        });

        scanner.close();

    }

    public static String checkPattern(String pattern) {
        try {
            Pattern p = Pattern.compile(pattern) ;
            return "Valid";
        }catch (PatternSyntaxException e) {
            return "Invalid";
        }
    }

}

