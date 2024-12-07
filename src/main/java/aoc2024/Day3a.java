package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3a {
    private final List<Tuple<Integer, Integer>> tuples;

    public Day3a(String filePath) throws IOException {
        this.tuples = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            Pattern pattern = Pattern.compile("(mul[(]\\d{1,3}[,]\\d{1,3}[)])");
            Pattern pattern2 = Pattern.compile("(\\d+)");
            String str;
            while((str = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(str);
                while(matcher.find()) {
                    System.out.println(matcher.group());
                    Matcher matcher2 = pattern2.matcher(matcher.group());

                    // tfw stackoverflow suggestions for matcher.group(index) don't work for me
                    // thanks stackoverflow
                    List<String> stupidList = new ArrayList<>();
                    while(matcher2.find()) {
                        stupidList.add(matcher2.group());
                    }
                    tuples.add(new Tuple<>(Integer.valueOf(stupidList.get(0)), Integer.valueOf(stupidList.get(1))));
                }
            }
            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("Day 3a file reading error: " + e);
            throw e;
        }
    }

    public int getResult() {
        int sum = 0;

        for(Tuple<Integer, Integer> numberPair : tuples) {
            sum += numberPair.x * numberPair.y;
        }
        return sum;
    }
}
