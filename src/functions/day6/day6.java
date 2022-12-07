package src.functions.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day6 {
    public static void run() throws IOException {
        File file = new File("./resources/day6Test.txt");
        int marker = part1(file);
        System.out.println("Day 6 - Part 1 - Test expectation - The first marker after character 11");
        System.out.printf("Day 6 - Part 1 - Test Result - The first marker after character %d%n", marker);

        file = new File("./resources/day6Real.txt");
        marker = part1(file);
        System.out.printf("Day 6 - Part 1 - Real - The first marker after character %d%n", marker);
        /*
        file = new File("./resources/day6Test.txt");
        marker = part2(file);
        System.out.println("Day 4 - Part 2 - Test expectation - The amount of assignment with an overlap is 4");
        System.out.printf("Day 4 - Part 2 - Test - The amount of assignment with an overlap is [%d]%n", marker);

        file = new File("./resources/day6Real.txt");
        marker = part2(file);
        System.out.printf("Day 4 - Part 2 - Real - The amount of assignment with an overlap is [%d]%n", marker);
        */
    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int marker = 0;
        int i = 0;
        int increment = 14;
        String substring = "";
        while ((line = br.readLine()) != null) {
            while (i + increment < line.length()) {
                if (hasRepeatedChar(line.substring(i, i + increment))){
                    i++;
                } else {
                    marker = i + increment;
                    break;
                }
            }
        }
        return marker;
    }

    private static boolean hasRepeatedChar(String substring) {
        for (int i = 0; i < substring.length(); i++) {
            for (int j = i + 1; j < substring.length(); j++){
                if (substring.charAt(i) == substring.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
