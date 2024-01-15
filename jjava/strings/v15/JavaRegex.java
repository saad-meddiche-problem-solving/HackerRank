package jjava.strings.v15;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
public class JavaRegex {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

    static class  MyRegex{
        public String pattern = "^(((25[0-5]|2[0-4]\\\\d|1\\\\d{2}|0\\\\d{2}|\\\\d{2}|0)[.]?\\\\b)){4}$";
    }

}

