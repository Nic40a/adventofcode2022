package src;

import src.functions.day1;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {

        File file = new File("./resources/day1Test.txt");
        int calories = day1.part1(file);
        System.out.println("Day 1 - Part 1 - Test expectation - The elf with the most calories  carries: 24000");
        System.out.printf("Day 1 - Part 1 - Test Result - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Real.txt");
        calories = day1.part1(file);
        System.out.printf("Day 1 - Part 1 - Real - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Test.txt");
        calories = day1.part2(file);
        System.out.println("Day 1 - Part 2 - Test expectation - The elf with the most calories  carries: 45000");
        System.out.printf("Day 1 - Part 2 - Test - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Real.txt");
        calories = day1.part2(file);
        System.out.printf("Day 1 - Part 2 - Real - The elf with the most calories carries: [%d]%n", calories);
    }
}
