package jjava.data_structures.v15;

import java.util.*;

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

        if(string.isEmpty() || string.isBlank()) return true;

        if(isEven(string.length())) return false;

        List<Integer> list = new ArrayList<>();
        for(char c : string.toCharArray()) {
            list.add(book.get(c));
        }

        if(isClose(list.get(0))) return false;

        if(isOpen(list.get(list.size() - 1))) return false;

        Stack<Integer> stack = new Stack<>();
        for(Integer i : list){

            if(isOpen(i)) {
                stack.add(i);
            }

            if(isClose(i)) {
                if(stack.isEmpty()) return false;
                if(!isValid(stack.pop(),i)) return false;
            }

        }

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
