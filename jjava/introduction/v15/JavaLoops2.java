package jjava.introduction.v15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true
public class JavaLoops2 {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        int numberOfQueries = scanner.nextInt();

        List<String>  spaceSeparatedIntegers =  new ArrayList<>(numberOfQueries);

        scanner.nextLine();

       for(int i = 0 ; i < numberOfQueries ; i++){
            spaceSeparatedIntegers.add(scanner.nextLine());
       }

        List<Query> queries =  getQueries(spaceSeparatedIntegers);

        queries.forEach(query -> {

            List<String> groupOfSumOfSeries = getSeries(query);


            groupOfSumOfSeries.forEach(System.out::print);
            System.out.println();

        });

    }

    public static List<Query> getQueries(List<String> spaceSeparatedIntegers){
        return spaceSeparatedIntegers.stream().map(is ->{

            String[] split = is.split(" ");

            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int n = Integer.parseInt(split[2]);

            return new Query(a , b , n);

        }).collect(Collectors.toList());
    }

    public static List<String> getSeries(Query query){

        List<String> groupOfSumOfSeries = new ArrayList<>();

        for(int i = 1 ; i <= query.n ; i++){

            int result = query.a + sumOfSeries(query.b , i);

            groupOfSumOfSeries.add(String.valueOf(result) + " ");
        }

        return groupOfSumOfSeries;
    }

    public static int sumOfSeries(int number , int count){

        int sum = 0;

        for(int power = 0 ; power < count ; power++){
          sum += Math.pow(2 , power) * number;
        }

        return sum;
    }


    static class Query{
        int a ;
        int b;
        int n;

        public Query(int a , int b , int n){
            this.a = a;
            this.b = b;
            this.n = n;
        }
    }
}
