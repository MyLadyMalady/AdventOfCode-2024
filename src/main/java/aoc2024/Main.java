package aoc2024;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Day4b();
    }

    public static void Day1a() {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day1a day1a = new Day1a("C:\\aoc2024\\day1a.txt");

        int result = day1a.getInteger();
        System.out.println(result);
    }

    public static void Day1b() {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day1b day1b = new Day1b("C:\\aoc2024\\day1a.txt");

        int result = day1b.getInteger();
        System.out.println(result);
    }

    public static void Day2a() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day2a day2a = new Day2a("C:\\aoc2024\\day2a.txt");

        int result = day2a.getSafeResults();
        System.out.println(result);
    }

    public static void Day2b() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day2b day2b = new Day2b("C:\\aoc2024\\day2a.txt");

        int result = day2b.getSafeResults();
        System.out.println(result);
    }

    public static void Day3a() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day3a day3a = new Day3a("C:\\aoc2024\\day3.txt");

        int result = day3a.getResult();
        System.out.println(result);
    }

    public static void Day3b() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day3b day3b = new Day3b("C:\\aoc2024\\day3.txt");

        int result = day3b.getResult();
        System.out.println(result);
    }

    public static void Day4a() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day4a day4a = new Day4a("C:\\aoc2024\\day4.txt");

        int result = day4a.countOptions();
        System.out.println(result);
    }

    public static void Day4b() throws IOException {
        // hardcoded file paths because I can't be bothered to set up args parsing
        Day4b day4b = new Day4b("C:\\aoc2024\\day4.txt");

        int result = day4b.countOptions();
        System.out.println(result);
    }
}