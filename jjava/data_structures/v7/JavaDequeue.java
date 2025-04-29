package jjava.data_structures.v7;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class JavaDequeue {

    private static int uniqueNumbers = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0 ; i < m ; i++)
            deque.add(arr[i]);

        updateUniqueNumbers(deque);

        for(int i = m ; i < arr.length ; i++) {
            deque.removeFirst();
            deque.addLast(arr[i]);

            updateUniqueNumbers(deque);
        }

        System.out.println(uniqueNumbers);

    }

    public static void updateUniqueNumbers(Deque<Integer> deque) {

        Set<Integer> set = new HashSet<>(deque);

        int size = set.size();

        if(uniqueNumbers < size) uniqueNumbers = size;

    }

}
