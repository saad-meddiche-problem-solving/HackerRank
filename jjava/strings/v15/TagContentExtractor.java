package jjava.strings.v15;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true

public class TagContentExtractor {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        String regex = "^<(\\w+)>(.+)</(\\w+)>$";

        Pattern p = Pattern.compile(regex , Pattern.CASE_INSENSITIVE);

        while(testCases>0){

            String line = in.nextLine();

            Matcher m = p.matcher(line);

            if(m.find() && m.group(0) != m.group(2)){
                System.out.println("None");
            }

            System.out.println(m.group(1));

            testCases--;
        }
    }


}