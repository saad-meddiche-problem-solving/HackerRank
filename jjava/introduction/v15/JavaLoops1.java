package jjava.introduction.v15;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/java-loops-i/problem?isFullScreen=true

public class JavaLoops1 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = scanner.nextInt();

        printMultiplicationsOfNumber(n , 11);

    }

    public static void printMultiplicationsOfNumber(int number , int count){

        IntStream.range(1 , count).forEach(i -> {
            System.out.println(number + " x " + i + " = " + number * i);
        }
       );
    }
}
