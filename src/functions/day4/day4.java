package src.functions.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day4 {
    public static void run() throws IOException {
        File file = new File("./resources/day4Test.txt");
        int sum = part1(file);
        System.out.println("Day 4 - Part 1 - Test expectation - The amount of assignment with one including the other is 2");
        System.out.printf("Day 4 - Part 1 - Test Result - The amount of assignment with one including the other is [%d]%n", sum);

        file = new File("./resources/day4Real.txt");
        sum = part1(file);
        System.out.printf("Day 4 - Part 1 - Real - The amount of assignment with one including the other is [%d]%n", sum);

        file = new File("./resources/day4Test.txt");
        sum = part2(file);
        System.out.println("Day 4 - Part 2 - Test expectation - The amount of assignment with an overlap is 4");
        System.out.printf("Day 4 - Part 2 - Test - The amount of assignment with an overlap is [%d]%n", sum);

        file = new File("./resources/day4Real.txt");
        sum = part2(file);
        System.out.printf("Day 4 - Part 2 - Real - The amount of assignment with an overlap is [%d]%n", sum);

    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;

        while ((st = br.readLine()) != null) {
            Assignment Assignment = new Assignment(st);
            sum += Assignment.isIncludedSection();
        }
        return sum;
    }

    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;

        while ((st = br.readLine()) != null) {
            Assignment Assignment = new Assignment(st);
            sum += Assignment.isOverlappingSection();
        }
        return sum;
    }
}
