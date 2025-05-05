package lab13;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class lab13 {
    private ArrayList<Integer> data = new ArrayList<>();

    public void readData(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    data.add(Integer.parseInt(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public long getTotalCount() {
        return data.stream().count();
    }

    public long getOddCount() {
        return data.stream().filter(n -> n % 2 != 0).count();
    }

    public long getEvenCount() {
        return data.stream().filter(n -> n % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount() {
        return data.stream().filter(n -> n > 5).distinct().count();
    }

    public Integer[] getResult1() {
        return data.stream()
                .filter(n -> n > 5 && n < 50 && n % 2 == 0)
                .sorted()
                .toArray(Integer[]::new);
    }

    public Integer[] getResult2() {
        return data.stream()
                .map(n -> n * n * 3)
                .limit(50)
                .toArray(Integer[]::new);
    }

    public Integer[] getResult3() {
        return data.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .sorted()
                .skip(20)
                .distinct()
                .toArray(Integer[]::new);
    }
}
