package jjava.big_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JavaBigInteger {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = bufferReader.readLine();

        String secondLine = bufferReader.readLine();

        BigInteger firstNumber = new BigInteger(firstLine);

        BigInteger secondNumber = new BigInteger(secondLine);

        System.out.println(firstNumber.add(secondNumber));

        System.out.println(firstNumber.multiply(secondNumber));

    }

}
