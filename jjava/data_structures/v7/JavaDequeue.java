package jjava.data_structures.v7;

import java.util.*;

// https://www.hackerrank.com/challenges/java-dequeue/problem
public class JavaDequeue {

    private static int uniqueNumbers = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            int num = in.nextInt();

            deque.addLast(num);
            set.add(num);

            if(deque.size() == m) {

                if(set.size() > uniqueNumbers)
                    uniqueNumbers = set.size();

                int first = deque.removeFirst();

                if(!deque.contains(first)) set.remove(first);

            }

        }

        System.out.println(uniqueNumbers);

    }

}
