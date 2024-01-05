package jjava.strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class JavaStringCompare {

    private static final Scanner scanner = new Scanner(System.in);

    private static String S;

    private static Integer K;

    private static String smallSubString;

    private static String largeSubString;

    private static List<String> listofSubtrings = new ArrayList<>();

    public static void main(String[] args) {

        scanData();

        getSubstringe();

        getLargestAndSmallest();

        printResult();
    }

    public static void getSubstringe(){
        Integer numberOfSubstring = S.length() - K + 1;

        for(int i = 0 ; i < numberOfSubstring ; i++){
          listofSubtrings.add(S.substring(i , i + K));
        }
    }

    public static void getLargestAndSmallest(){

        Object[] arrayList = listofSubtrings.toArray();

        Arrays.sort(arrayList);

        smallSubString = (String) arrayList[0];

        largeSubString = (String) arrayList[arrayList.length - 1];

    }

    public static void printResult(){
        System.out.println(smallSubString);
        System.out.println(largeSubString);
    }

    public static void scanData() {
        S = scanner.next();K = scanner.nextInt();
    }

}

class DeclarativeApproach{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.next();
        int substringLength = scanner.nextInt();

        List<String> substrings = generateSubstrings(inputString, substringLength);

        Pair<String, String> smallestAndLargest = getLargestAndSmallest(substrings);

        System.out.println("Smallest Substring: " + smallestAndLargest.getFirst());
        System.out.println("Largest Substring: " + smallestAndLargest.getSecond());

    }

    public static List<String> generateSubstrings(String text , Integer substringLenght){
        return IntStream.range(0 , text.length() - substringLenght + 1)
                .mapToObj(i -> text.substring(i , i + substringLenght))
                .collect(Collectors.toList());
    }

    public static Pair<String , String> getLargestAndSmallest(List<String> list){
        Collections.sort(list);
        return new Pair<>(list.get(0) ,list.get(list.size() - 1) );
    }

    static class Pair<A , B>{

        private A first;

        private B second;

        public Pair(A first , B second){
            this.first = first;
            this.second = second;
        }

        public A getFirst(){
            return first;
        }

        public B getSecond(){
            return second;
        }

    }



}