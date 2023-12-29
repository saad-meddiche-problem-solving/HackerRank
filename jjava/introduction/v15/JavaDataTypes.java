package jjava.introduction.v15;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/java-datatypes/problem?isFullScreen=true
public class JavaDataTypes {

    private static final Scanner scanner = new Scanner(System.in);

    private static int T;

    private static  List<String> listOfNumbers;

    private static List<String> results = new ArrayList<>();
    public static void main (String[] args){

        scannData();

        listOfNumbers.forEach(number -> {

            try {
                Byte numberAsByte =  Byte.parseByte(number);
                results.add(number + " can be fitted in:");
                results.add("* byte");
                results.add("* short");
                results.add("* int");
                results.add("* long");
                return;
            }catch (NumberFormatException e){

            }

            try{
                Short numberAsShort = Short.parseShort(number);
                results.add(number + " can be fitted in:");
                results.add("* short");
                results.add("* int");
                results.add("* long");
                return;
            }catch (NumberFormatException e){

            }

            try {
                Integer numberAsInteger = Integer.parseInt(number);
                results.add(number + " can be fitted in:");
                results.add("* int");
                results.add("* long");
                return;
            }catch (NumberFormatException e){

            }

            try {
                Long numberAsLong = Long.parseLong(number);
                results.add(number + " can be fitted in:");
                results.add("* long");
            }catch (NumberFormatException e){
                results.add(number + " can't be fitted anywhere.");
            }

        });

        results.forEach(System.out::println);
    }

    private static void scannData(){
        T = scanner.nextInt();

        scanner.nextLine();
        listOfNumbers = IntStream.range(0 , T).mapToObj(i -> scanner.nextLine()).collect(Collectors.toList());
    }
}
