package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1b {
    private final List<Integer> left;
    private final List<Integer> right;
    public Day1b(String filePath) {
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine()) != null) {
                String[] line = str.split(" ");
                left.add(Integer.valueOf(line[0]));
                // for some reason, java counts in between spaces too
                right.add(Integer.valueOf(line[3]));
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("Day 1b file reading error: " + e);
        }
    }

    // I love being inefficient
    public int getInteger() {
        int score = 0;
        for(int i = 0; i < left.size(); i++) {
            int curr = left.get(i);
            int count = 0;
            for(int j = 0; j < right.size(); j++) {
                if(curr == right.get(j)) {
                    count++;
                }
            }
            score += curr * count;
        }

        return score;
    }
}
