package jjava.introduction.v15;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-currency-formatter/problem?isFullScreen=true
public class JavaCurrencyFormatter {

    private static final Scanner scanner = new Scanner(System.in);

    private static final Float amount = scanner.nextFloat();
    public static void main(String[] args) {

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);

        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);

        NumberFormat frensh = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println(us.format(amount));
        System.out.println(india.format(amount));
        System.out.println(china.format(amount));
        System.out.println(frensh.format(amount));

    }


}