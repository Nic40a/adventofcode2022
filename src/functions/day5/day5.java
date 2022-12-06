package src.functions.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day5 {
    public static void run() throws IOException {
        File stackFile = new File("./resources/day5TestStacks.txt");
        File instructionFile = new File("./resources/day5TestInstructions.txt");
        String list = part1(stackFile, instructionFile);

        System.out.println("Day 5 - Part 1 - Test expectation - The expect list of the last containers is CMZ");
        System.out.printf("Day 5 - Part 1 - Test Result - The list of the last containers is %s%n", list);

        stackFile = new File("./resources/day5RealStacks.txt");
        instructionFile = new File("./resources/day5RealInstructions.txt");
        list = part1(stackFile, instructionFile);

        System.out.printf("Day 5 - Part 1 - Test Result - The list of the last containers is %s%n", list);

        stackFile = new File("./resources/day5TestStacks.txt");
        instructionFile = new File("./resources/day5TestInstructions.txt");
        list = part2(stackFile, instructionFile);

        System.out.println("Day 5 - Part 2 - Test expectation - The expect list of the last containers is MCD");
        System.out.printf("Day 5 - Part 2 - Test Result - The list of the last containers is %s%n", list);

        stackFile = new File("./resources/day5RealStacks.txt");
        instructionFile = new File("./resources/day5RealInstructions.txt");
        list = part2(stackFile, instructionFile);
        System.out.printf("Day 5 - Part 2 - Real - The list of the last containers is %s%n", list);

    }

    private static String part1(File stack, File instruction) throws IOException{

        Dock dock = new Dock(stack);
        BufferedReader br = new BufferedReader(new FileReader(instruction));
        String line;
        while ((line = br.readLine()) != null) {
            dock.processInstruction1(new Instruction(line));
        }
        return dock.showLast();
    }

    private static String part2(File stack, File instruction) throws IOException{

        Dock dock = new Dock(stack);
        BufferedReader br = new BufferedReader(new FileReader(instruction));
        String line;
        while ((line = br.readLine()) != null) {
            dock.processInstruction2(new Instruction(line));
        }
        return dock.showLast();
    }
}
