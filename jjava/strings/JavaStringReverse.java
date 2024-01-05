package jjava.strings;

import java.util.Scanner;

public class JavaStringReverse {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String  A = scanner.next();
        scanner.close();

        String reversedA = new StringBuilder(A).reverse().toString();

        System.out.println(
                A.equals(reversedA) ? "Yes" : "No"
        );
    }





}