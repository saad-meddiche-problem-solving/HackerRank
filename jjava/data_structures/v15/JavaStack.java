package jjava.data_structures.v15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/java-stack/problem
public class JavaStack {

    public static Map<Character, Integer> book = new HashMap<>();

    public static void main(String[] args) {

        push('(',')',1);
        push('[',']',2);
        push('{','}',3);

        try(Scanner scanner = new Scanner(System.in)) {

            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(isStringBalanced(line));
            }

        }

    }

    public static void push(char c1, char c2, int num){
        book.put(c1, num);
        book.put(c2, num * -1);
    }

    public static boolean isStringBalanced(String string) {

        if(string.isEmpty()) return true;

        if(isEven(string.length())) return false;

        int length = string.length();
        int halfLength = length / 2;

        char[] arrChar = string.toCharArray();

        Stack<Integer> leftSide = new Stack<>();
        for(int i = 0 ; i < halfLength ; i++) {
            leftSide.add(book.get(arrChar[i]));
        }

        Stack<Integer> rightSide = new Stack<>();
        for(int i = length -1 ; i >= halfLength ; i--) {
            rightSide.add(book.get(arrChar[i]));
        }

        if(isClose(leftSide.firstElement())) return false;

        if(isOpen(rightSide.firstElement())) return false;


        return true;
    }

    public static boolean isEven(int num) {
        return num % 2 != 0;
    }

    public static boolean isValid(int nLeft , int nRight) {
        return nLeft + nRight == 0 && isOpen(nLeft) && isClose(nRight);
    }

    public static boolean isOpen(int n) {
        return n > 0;
    }

    public static boolean isClose(int n) {
        return n < 0;
    }

}
