package jjava.strings.v15;

import java.util.Arrays;
import java.util.Scanner;

public class JavaAnagrams {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        System.out.println(
                isAnagram(a, b) ? "Anagrams" : "Not Anagrams"
        );
    }

    public static Boolean isAnagram(String a, String b) {

        char[] charArrayA = a.toLowerCase().toCharArray();
        char[] charArrayB = b.toLowerCase().toCharArray();

        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);

        return Arrays.equals(charArrayA, charArrayB);

    }

}

class DeclarativeApproachJavaAnagrams{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        System.out.println(
                isAnagram(a, b) ? "Anagrams" : "Not Anagrams"
        );
    }

    public static Boolean isAnagram(String a, String b) {

      return Arrays.equals(
              a.toLowerCase().chars().sorted().toArray(),
              b.toLowerCase().chars().sorted().toArray()
      );
    }

}
