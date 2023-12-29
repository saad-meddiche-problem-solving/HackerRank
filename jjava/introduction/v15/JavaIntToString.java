package jjava.introduction.v15;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-int-to-string/problem?isFullScreen=true
public class JavaIntToString {

    private static final Scanner scanner = new Scanner(System.in);

    private static Byte n;

    public static void main(String[] args) {
        scannData();

        try {
            String result = n.toString();
            System.out.println("Good job");
        }catch (Exception e){
            System.out.println("Wrong answer");
        }


    }

    public static void scannData(){
        n = scanner.nextByte();
    }

}