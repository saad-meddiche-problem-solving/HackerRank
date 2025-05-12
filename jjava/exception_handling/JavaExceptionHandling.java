package jjava.exception_handling;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem?isFullScreen=true
public class JavaExceptionHandling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x , y;
        try{

            x = scanner.nextInt();
            y = scanner.nextInt();

        } catch(Exception ex) {
            System.out.println(ex.getClass().toString().replace("class ",""));
            return;
        }

        try {

            int result = x / y;
            System.out.println(result);

        } catch(Exception ex){
            System.out.println(ex);
            return;
        }

    }
}