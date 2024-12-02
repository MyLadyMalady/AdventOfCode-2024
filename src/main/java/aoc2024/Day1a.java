package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1a {
    private final List<Integer> list1;
    private final List<Integer> list2;
    public Day1a(String filePath) {
        this.list1 = new ArrayList<>();
        this.list2 = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine()) != null) {
                String[] line = str.split(" ");
                list1.add(Integer.valueOf(line[0]));
                // for some reason, java counts in between spaces too
                list2.add(Integer.valueOf(line[3]));
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("Day 1a file reading error: " + e);
        }
    }

    public int getInteger() {
        sortLists();

        int sum = 0;
        for(int i = 0; i < list1.size(); i++) {
            int diff = list1.get(i) - list2.get(i);
            sum += Math.abs(diff);
        }

        return sum;
    }

    private void sortLists() {
        Collections.sort(list1);
        Collections.sort(list2);
    }

}
