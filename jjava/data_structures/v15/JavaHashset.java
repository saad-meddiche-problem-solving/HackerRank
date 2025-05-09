package jjava.data_structures.v15;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/java-hashset/problem
public class JavaHashset {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<Set<String>> set = new HashSet<>();

        for (int i = 0; i < t; i++) {

            Set<String> pair = new HashSet<>(2);
            pair.add(pair_left[i]);
            pair.add(pair_right[i]);

            set.add(pair);

            System.out.println(set.size());

        }


    }

}
