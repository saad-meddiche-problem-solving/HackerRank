package jjava.data_structures.v15;

import java.util.*;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem
public class JavaSubarray {

    public static int negativeSumsCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        while(n-- > 0) {
            list.add(scanner.nextInt());
        }

        theSub(list.size(),list);

        System.out.println(negativeSumsCount);

    }

    public static void theSub(int dequeSize, List<Integer> list) {
        Deque<Integer> deque = new ArrayDeque<>();

        int sum = 0;
        for(Integer num : list) {

            deque.addLast(num);
            sum += num;

            if(deque.size() == dequeSize) {

                if(sum < 0)
                    negativeSumsCount++;

                sum = 0;
                deque.removeFirst();
            }

        }

        if(dequeSize > 0)
            theSub(dequeSize - 1 , list);

    }

}
