package jjava.strings.v15;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

// https://www.hackerrank.com/challenges/duplicate-word/problem?isFullScreen=true
public class JavaRegex2DuplicateWord {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)\\b(\\s+\\1)+\\b";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group() , m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        int n = scanner.nextInt();
//
//        scanner.nextLine();
//        IntStream.range(0, n).forEach(i -> {
//
//            String sentence = scanner.nextLine();
//
//            String[] words = sentence.split(" ");
//
//            Set<String> wordsSet = new LinkedHashSet<>(List.of(words));
//
//            wordsSet.forEach(word -> {
//
//                System.out.print(word);
//                if(!word.equals(words[words.length - 1])) {
//                    System.out.print(" ");
//                }
//            });
//
//        });
//
//
//
//    }



}