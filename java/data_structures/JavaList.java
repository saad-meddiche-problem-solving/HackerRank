package java.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-list/problem?isFullScreen=true

public class JavaList {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        scan.nextLine();
        String spaceSeparatedIntegers = scan.nextLine();

        Integer numberOfQueries = scan.nextInt();

        List<Query> queries = new ArrayList<>();

        scan.nextLine();

        for (int i = 0; i < numberOfQueries; i++) {

            String typeOfQuery = scan.nextLine();
            String integers = scan.nextLine();
            queries.add(new Query(typeOfQuery.equals("Insert") ? TypeOfQuery.INSERT : TypeOfQuery.DELETE, integers));
        }

        List<Integer> mainList = transformStringToInts(spaceSeparatedIntegers);

        for (Query query : queries) {
            if (query.type == TypeOfQuery.INSERT) {
                List<Integer> xy = transformStringToInts(query.integers);
                Integer index = xy.get(0);
                Integer value = xy.get(1);
                mainList.add(index, value);
            } else {
                List<Integer> x = transformStringToInts(query.integers);
                mainList.remove((int) x.get(0));
            }
        }

       for(int i : mainList){
           if(i != mainList.get(mainList.size() - 1)){
               System.out.print(i + " ");
           }
           else{
               System.out.println(i);
           }
       }

    }

    // Transform the 'spaceSeparatedIntegers' to a list of long
    public static List<Integer> transformStringToInts(String spaceSeparatedIntegers) {
        String[] integerStrings = spaceSeparatedIntegers.split(" ");
        List<Integer> integers = new ArrayList<>();
        for (String integerString : integerStrings) {
            integers.add(Integer.parseInt(integerString));
        }
        return integers;
    }

    static class Query {
        TypeOfQuery type;
        String integers;

        public Query(TypeOfQuery type, String integers) {
            this.type = type;
            this.integers = integers;
        }
    }

    public enum TypeOfQuery {
        INSERT,
        DELETE
    }
}
