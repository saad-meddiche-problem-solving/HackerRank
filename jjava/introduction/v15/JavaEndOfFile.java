package jjava.introduction.v15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/java-end-of-file/problem?isFullScreen=true
public class JavaEndOfFile {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<String> lines = new ArrayList<>();
    public static void main(String[] args) {

        readLines();

        printLines();

    }

    private static void readLines(){
        while (scanner.hasNext()){
            lines.add(scanner.nextLine());
        }
    }

    private static void printLines(){
        IntStream.range(0 , lines.size()).forEach(i -> System.out.println(i + 1 + " " + lines.get(i)));
    }
}
