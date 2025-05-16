package jjava.advanced.v15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

// https://www.hackerrank.com/challenges/java-lambda-expressions/problem?isFullScreen=true
public class JavaLambdaExpressions {

    static Map<Integer,Function<Integer,String>> map = new HashMap<>();

    public static void main(String[] args) {

        map.put(1,isOdd);
        map.put(2,isPrime);
        map.put(3,isPalindrome);

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(T-- > 0) {

            int conditionToCheck = scanner.nextInt();

            int numberToBeChecked = scanner.nextInt();

            System.out.println(map.get(conditionToCheck).apply(numberToBeChecked));

        }

    }

    static Function<Integer,String> isOdd = num -> num % 2 != 0 ? "ODD" : "EVEN";

    static Function<Integer,String> isPrime = num -> {

        if(num <= 1)
            return "COMPOSITE";

        for(int i = 2 ; i <= Math.sqrt(num) ;i++)
            if(num % i == 0) return "COMPOSITE";

        return "PRIME";
    };

    static Function<Integer,String> isPalindrome = num -> {
        int reverse = 0;

        int temp = Math.abs(num);
        while(temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }

        return reverse == Math.abs(num) ? "PALINDROME" : "NOT PALINDROME";
    };
}
