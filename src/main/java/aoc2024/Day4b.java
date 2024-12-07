package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day4b {
    private final List<String> lines;
    public Day4b(String filePath) {
        this.lines= new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while((str = br.readLine()) != null) {
                lines.add(str);
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("Day 4b file reading error: " + e);
        }
    }

    public int countOptions() {
        int count = 0;

        int linesCount = lines.size();
        for (int i = 1; i < linesCount - 1; i++) {
            String currentLine = lines.get(i);
            for (int j = 1; j < currentLine.length() - 1; j++) {
                char c = currentLine.charAt(j);
                if(c == 'A') {
                    boolean diagonal1 = false;
                    String aboveLine = lines.get(i - 1);
                    String belowLine = lines.get(i + 1);
                    if(aboveLine.charAt(j - 1) == 'M') {
                        if(belowLine.charAt(j + 1) == 'S') {
                            diagonal1 = true;
                        }
                    }
                    if(aboveLine.charAt(j - 1) == 'S') {
                        if(belowLine.charAt(j + 1) == 'M') {
                            diagonal1 = true;
                        }
                    }
                    if(belowLine.charAt(j - 1) == 'S') {
                        if(aboveLine.charAt(j + 1) == 'M' && diagonal1) {
                            count++;
                        }
                    }
                    if(belowLine.charAt(j - 1) == 'M') {
                        if(aboveLine.charAt(j + 1) == 'S' && diagonal1) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
