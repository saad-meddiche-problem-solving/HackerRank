package jjava.strings;

import java.util.*;

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