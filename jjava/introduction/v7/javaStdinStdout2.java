package jjava.introduction.v7;

import java.util.Scanner;

public class javaStdinStdout2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer i = scan.nextInt();
        Double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
