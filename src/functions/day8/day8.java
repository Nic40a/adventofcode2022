package src.functions.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day8 {
    public static void run() throws IOException {
        File file = new File("./resources/day8Test.txt");
        /*
        int sum = part1(file);
        System.out.println("Day 8 - Part 1 - Test expectation - The expected amount of visible trees is 21");
        System.out.printf("Day 8 - Part 1 - Test Result - The amount of visible trees is %d%n", sum);

        file = new File("./resources/day8Real.txt");
        int sum = part1(file);
        System.out.printf("Day 8 - Part 1 - Real - Test Result - The total size is %d%n", sum);

        file = new File("./resources/day8Test.txt");
        int sum = part2(file);
        System.out.println("Day 8 - Part 2 - Test expectation - The expected scenic score is 8");
        System.out.printf("Day 8 - Part 2 - Test - The scenic score is %d%n", sum);
        */
        file = new File("./resources/day8Real.txt");
        int sum = part2(file);
        System.out.printf("Day 8 - Part 2 - Real - The scenic score is %d%n", sum);

    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        Forest forest = new Forest();
        while ((line = br.readLine()) != null) {
            forest.addTreeLine(line);
        }
        return forest.countTree();
    }

    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        Forest forest = new Forest();
        while ((line = br.readLine()) != null) {
            forest.addTreeLine(line);
        }
        return forest.getScenicScore();
    }
}
