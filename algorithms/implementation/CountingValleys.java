package algorithms.implementation;

import java.io.*;

// https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=false
class CountingValleysResult {

    char[] example = {'_','U','D','D','D','U','D','U','U','_'};
    int [] test    = { 0 , 1 , 0 ,-1 ,-2 ,-1 ,-2 ,-1 , 0 , 0 };
    public static int countingValleys(int steps, String path) {

        int valleys = 0;
        int y = 0;

        boolean isStart = false;

        for(char step : path.toCharArray()) {

            y = countY(y , step);

            if(step == 'D' && y <= 0) {
                isStart = true;
            }

            if(y < 0 && isStart) {
                continue;
            }

            if(y == 0 && step == 'U' && isStart) {
                valleys++;
                isStart = false;
            }

        }

        return valleys;
    }

    public static int countY(int y, char step) {
        return 'D' == step ? y - 1 : y + 1;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleysResult.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}