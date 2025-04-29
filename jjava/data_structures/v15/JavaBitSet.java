package jjava.data_structures.v15;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;

// https://www.hackerrank.com/challenges/java-bitset/problem
public class JavaBitSet {

    public Map<String,BiConsumer<Integer,Integer>> book = new HashMap<>();
    public BitSet B1;
    public BitSet B2;

    public JavaBitSet(int s1, int s2) {
        B1 = new BitSet(s1);
        B2 = new BitSet(s2);
        book.put("AND", AND);
        book.put("OR", OR);
        book.put("XOR", XOR);
        book.put("FLIP", FLIP);
        book.put("SET", SET);
    }

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        JavaBitSet solution = new JavaBitSet(N,N);

        int M = scanner.nextInt();


        while(M-- > 0) {
            String operation = scanner.next();
            int set = scanner.nextInt();
            int setOrIndex = scanner.nextInt();

            solution.book.get(operation).accept(set , setOrIndex);


            System.out.println(solution.B1.cardinality() + " " + solution.B2.cardinality());
        }

    }

    public BitSet chooseSet(int set) {
        return set == 1 ? B1 : B2;
    }

    BiConsumer<Integer,Integer> AND = (set, setOrIndex ) -> chooseSet(set).and(chooseSet(setOrIndex));

    BiConsumer<Integer,Integer> OR = (set,setOrIndex) -> chooseSet(set).or(chooseSet(setOrIndex));

    BiConsumer<Integer,Integer> XOR = (set,setOrIndex) -> chooseSet(set).xor(chooseSet(setOrIndex));

    BiConsumer<Integer,Integer> FLIP = (set,index) -> chooseSet(set).flip(index);

    BiConsumer<Integer,Integer> SET = (set,index) -> chooseSet(set).set(index);
}
