package algorithms.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

// https://www.hackerrank.com/challenges/migratory-birds/problem?isFullScreen=true
public class MigratoryBirds {

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < arrCount; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            int result = Result.migratoryBirds(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }

}

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> capturedBirdIds) {

        BirdCage birdCage = new BirdCage(capturedBirdIds);

        return birdCage.retrieveBirdsWithSameMaxCount().first();

    }

}

class BirdCage {

    // Map<BirdId, Count>
    private final TreeMap<Integer, Integer> cage = new TreeMap<>();
    private Integer maxCount = 0;
    private final TreeSet<Integer> birdsWithSameMaxCount = new TreeSet<>();

    public BirdCage(List<Integer> birdIds) {
        this.prepareCage();
        this.storeBirds(birdIds);
    }

    public TreeMap<Integer, Integer> retrieveCage() {
        return this.cage;
    }

    public TreeSet<Integer> retrieveBirdsWithSameMaxCount() {
        return this.birdsWithSameMaxCount;
    }

    private void storeBirds(List<Integer> birdIds) {

        for(Integer birdId : birdIds) {
            this.storeBird(birdId);
        }

    }

    private void storeBird(Integer birdId) {

        if(birdId == null) return;

        Integer count = this.retrieveBirdCount(birdId);

        if(count == null) {
            // ingnore because cage is prepared to host only some specific bird types
            return;
        }

        int newCount = count + 1;

        this.cage.put(birdId, newCount);

        if(newCount > this.maxCount) {

            this.birdsWithSameMaxCount.clear();
            this.birdsWithSameMaxCount.add(birdId);

            this.maxCount = newCount;

        } else if(newCount == this.maxCount) {

            this.birdsWithSameMaxCount.add(birdId);

        }

    }

    private Integer retrieveBirdCount(Integer birdId) {
        return this.cage.get(birdId);
    }

    private void prepareCage() {

        // we have a guarantee that types are between 1 -> 5
        for(int i = 1 ; i < 6; i++) {
            this.cage.put(i, 0);
        }

    }

}


