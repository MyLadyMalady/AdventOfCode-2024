package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2b {
    private final List<List<Integer>> records;

    public Day2b(String filePath) throws IOException {
        this.records = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine()) != null) {
                String[] line = str.split(" ");
                List<Integer> stupidList = new ArrayList<>();
                for(int i = 0; i < line.length; i++) {
                    stupidList.add(Integer.valueOf(line[i]));
                }
                records.add(stupidList);
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("Day 2b file reading error: " + e);
            throw e;
        }
    }

    public int getSafeResults() {
        int unsafeResults = 0;

        for(List<Integer> record : records) {
            boolean unsafe = loopList(record);

            if(unsafe) {
                if(!checkIfSafePossible(record)) {
                    unsafeResults++;
                }
            }
        }
        return records.size() - unsafeResults;
    }

    // ugly bruteforce but I couldn't get my original solution to work
    // getting AOC stars is more important than code quality anyway :triumph:
    private boolean checkIfSafePossible(List<Integer> intList) {
        for(int i = 0; i < intList.size(); i++) {
            List<Integer> copy = new ArrayList<>(intList);
            copy.remove(i);
            boolean unsafe = loopList(copy);
            if(!unsafe) {
                return true;
            }
        }
        return false;
    }

    private boolean loopList(List<Integer> intList) {
        boolean unsafe = false;
        boolean decreasing = true;
        for(int i = 0; i < intList.size() - 1; i++) {
            int change = intList.get(i) - intList.get(i + 1);
            if(i == 0) {
                if(change < 0) {
                    decreasing = false;
                }
            }

            if(decreasing) {
                if(change < 0) {
                    unsafe = true;
                    break;
                }
            } else {
                if(change > 0) {
                    unsafe = true;
                    break;
                }
            }

            change = Math.abs(change);
            if(change == 0 || change >= 4 ) {
                unsafe = true;
                break;
            }
        }
        return unsafe;
    }
}
