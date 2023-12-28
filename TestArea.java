import hackerRankProblemSolving.JavaList;

import java.util.List;

public class TestArea {

    public static void main(String[] args) {

        String string = "12 14 67 40";

        List<Integer> list = JavaList.transformStringToInts(string);

        list.forEach(System.out::println);
    }
}
