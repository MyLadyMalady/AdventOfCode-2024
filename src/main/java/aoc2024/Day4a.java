package aoc2024;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day4a {
    private final List<String> lines;
    private final String charset = "XMAS";
    public Day4a(String filePath) throws IOException {
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
            System.out.println("Day 4a file reading error: " + e);
            throw e;
        }
    }

    public int countOptions() {
        int count = 0;
        int linesCount = lines.size();
        for (int i = 0; i < linesCount; i++) {
            String currentLine = lines.get(i);
            for (int j = 0; j < currentLine.length(); j++) {
                char c = currentLine.charAt(j);
                if(c == 'S') {
                    if(checkForMatches(c, linesCount, currentLine.length(), i, -1, -1, 3, j)) {
                        count++;
                    }
                    if(checkForMatches(c, linesCount, currentLine.length(), i, 1, -1, 3, j)) {
                        count++;
                    }
                    if(checkForMatches(c, linesCount, currentLine.length(), i, 0, -1, 3, j)) {
                        count++;
                    }
                    if(checkForMatches(currentLine, c, currentLine.length(), -1, 3, j)) {
                        count++;
                    }
                }
                if(c == 'X') {
                    if(checkForMatches(c, linesCount, currentLine.length(), i, -1, 1, 0, j)) {
                        count++;
                    }
                    if(checkForMatches(c, linesCount, currentLine.length(), i, 1, 1, 0, j)) {
                        count++;
                    }
                    if(checkForMatches(c, linesCount, currentLine.length(), i, 0, 1, 0, j)) {
                        count++;
                    }
                    if(checkForMatches(currentLine, c, currentLine.length(), 1, 0, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    // LEAVE ME AND MY SPAGHETTI RECURSION ALONE
    // this is the vertical check (only downwards)
    /**
     *
     * @param current Current character to evaluate
     * @param limit Limit the line count to not go out of bounds on last line
     * @param horizontalLimit Limit the character count to not go out of bounds on last character *in* a line
     * @param currentLine Index of the current line
     * @param verticalDiff -1 to evaluate left diagonal, 0 to evaluate straight down, 1 to evaluate right diagonal
     * @param operation -1 to go backwards on the charset, 1 to go forwards
     * @param charIndex Current index on the charset
     * @param lineCharIndex Index of the current character in its line
     * @return True if a sequence conforms to charset
     */
    private boolean checkForMatches(char current, int limit, int horizontalLimit, int currentLine, int verticalDiff, int operation, int charIndex, int lineCharIndex) {
        if(operation == -1 && charIndex == 0) {
            return current == charset.charAt(charIndex);
        } else if (operation == 1 && charIndex == 3) {
            return current == charset.charAt(charIndex);
        }

        if(currentLine == limit - 1) {
            return false;
        }

        String nextLine = lines.get(currentLine + 1);
        if(verticalDiff == -1 && lineCharIndex == 0) {
            return false;
        }

        if(verticalDiff == 1 && lineCharIndex == horizontalLimit - 1) {
            return false;
        }

        char nextChar = nextLine.charAt(lineCharIndex + verticalDiff);
        if(nextChar == charset.charAt(charIndex + operation)) {
            return checkForMatches(nextChar, limit, horizontalLimit, currentLine + 1, verticalDiff, operation, charIndex + operation, lineCharIndex + verticalDiff);
        }
        return false;
    }

    // this is the horizontal check (only forwards)

    /**
     *
     * @param line The line to evaluate across
     * @param current The current character to evaluate
     * @param horizontalLimit Limit the character count to not go out of bounds on last character *in* a line
     * @param operation -1 to go backwards on the charset, 1 to go forwards
     * @param charIndex Current index on the charset
     * @param lineCharIndex Index of the current character in its line
     * @return True if a sequence conforms to charset
     */
    private boolean checkForMatches(String line, char current, int horizontalLimit, int operation, int charIndex, int lineCharIndex) {
        if(operation == -1 && charIndex == 0) {
            return current == charset.charAt(charIndex);
        } else if (operation == 1 && charIndex == 3) {
            return current == charset.charAt(charIndex);
        }

        if(lineCharIndex == horizontalLimit - 1) {
            return false;
        }

        char nextChar = line.charAt(lineCharIndex + 1);
        if(nextChar == charset.charAt(charIndex + operation)) {
            return checkForMatches(line, nextChar, horizontalLimit, operation, charIndex + operation, lineCharIndex + 1);
        }
        return false;
    }
}
