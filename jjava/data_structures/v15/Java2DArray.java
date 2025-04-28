package jjava.data_structures.v15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


// https://www.hackerrank.com/challenges/java-2d-array/problem
public class Java2DArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        List<int[]> tops = new ArrayList<>();
        List<Integer> middles = new ArrayList<>();
        List<int[]> bottoms = new ArrayList<>();
        for(int x = 0 ; x < 4 ; x++) {
            List<Integer> topLine = arr.get(x);
            List<Integer> middleLine =  arr.get(x+1);
            List<Integer> bottomLine = arr.get(x+2);
            for(int i = 0 ; i < 4 ;i++) {

                int firstNumber = topLine.get(i);
                int secondNumber = topLine.get(i+1);
                int lastNumber = topLine.get(i+2);
                tops.add(new int[]{firstNumber,secondNumber,lastNumber});

                middles.add(middleLine.get(i+1));

                int firstNum = bottomLine.get(i);
                int secondNum = bottomLine.get(i+1);
                int lastNum = bottomLine.get(i+2);
                bottoms.add(new int[]{firstNum,secondNum,lastNum});
            }


        }

        List<Integer> sumOfHourglasses = new ArrayList<>();
        for(int i = 0; i < 16 ; i++) {
            int sum = 0;

            int[] top = tops.get(i);
            int middle = middles.get(i);
            int[] bottom = bottoms.get(i);

            sum+= middle;
            for(int j = 0; j < 3 ;j++) {
                sum+= top[j];
                sum+= bottom[j];
            }

            sumOfHourglasses.add(sum);
        }

        Collections.sort(sumOfHourglasses);

        System.out.println(sumOfHourglasses.get(sumOfHourglasses.size() - 1));


    }

}
