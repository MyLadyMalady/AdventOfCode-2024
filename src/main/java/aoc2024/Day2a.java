package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2a {
    private final List<List<Integer>> records;

    public Day2a(String filePath) throws IOException {
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
            System.out.println("Day 2a file reading error: " + e);
            throw e;
        }
    }

    public int getSafeResults() {
        int unsafeResults = 0;

        for(List<Integer> record : records) {
            boolean decreasing = true;
            for(int i = 0; i < record.size() - 1; i++) {
                int change = record.get(i) - record.get(i + 1);
                if(i == 0) {
                    if(change < 0) {
                        decreasing = false;
                    }
                }

                if(decreasing) {
                    if(change < 0) {
                        unsafeResults++;
                        break;
                    }
                } else {
                    if(change > 0) {
                        unsafeResults++;
                        break;
                    }
                }

                change = Math.abs(change);
                if(change == 0 || change >= 4 ) {
                    unsafeResults++;
                    break;
                }
            }
        }

        return records.size() - unsafeResults;
    }
}
