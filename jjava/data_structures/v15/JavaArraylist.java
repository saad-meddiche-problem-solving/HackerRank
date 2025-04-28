package jjava.data_structures.v15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-arraylist/problem
public class JavaArraylist {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLines = scanner.nextInt();

        List<List<Integer>> table = new ArrayList<>();
        for(int i = 0 ; i < numberOfLines ; i++) {

            int numberOfIntegers = scanner.nextInt();

            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < numberOfIntegers ;j++) {
                int value = scanner.nextInt();
                row.add(value);
            }
            table.add(row);

        }

        int numberOfQueries = scanner.nextInt();

        List<int[]> queries = new ArrayList<>();
        for(int i = 0 ; i < numberOfQueries ;i++) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            queries.add(new int[]{x-1,y-1});

        }


        for(int[] query : queries) {

            try {
                System.out.println( table.get(query[0]).get(query[1]) );
            }catch(IndexOutOfBoundsException exception) {
                System.out.println("ERROR!");
            }

        }

    }

}
