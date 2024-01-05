package jjava.strings.v15;

import java.util.Arrays;
import java.util.Scanner;

public class JavaStringTokens {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        scanner.close();

        String[] tokens = S.split("[ !,?._'@]+");

        System.out.println(tokens.length);

        Arrays.stream(tokens).forEach(System.out::println);


    }

}