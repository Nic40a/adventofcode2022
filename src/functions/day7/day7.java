package src.functions.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day7 {

    public static int goalSize = 0;
    public final static int spaceNeeded = 30000000;
    public final static int totalSpace = 70000000;
    public static int optimalFolder = spaceNeeded;
    public static int totalSize = 0;

    public static void run() throws IOException {
        File file = new File("./resources/day7Test.txt");
        int sum = part1(file);
        System.out.println("Day 7 - Part 1 - Test expectation - The expected size is 95437");
        System.out.printf("Day 7 - Part 1 - Test Result - The total size is %d%n", goalSize);

        file = new File("./resources/day7Real.txt");
        sum = part1(file);
        System.out.printf("Day 7 - Part 1 - Real - Test Result - The total size is %d%n", goalSize);

        file = new File("./resources/day7Test.txt");
        sum = part2(file);
        System.out.println("Day 7 - Part 2 - Test expectation - The expected folder size to be deleted is 24933642");
        System.out.printf("Day 7 - Part 2 - Test - The folder size to be deleted is %d%n", optimalFolder);

        file = new File("./resources/day7Real.txt");
        sum = part2(file);
        System.out.printf("Day 7 - Part 2 - Real - The folder size to be deleted is %d%n", optimalFolder);

    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        FileSystemManager fsm = new FileSystemManager();
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '$') {
                fsm.setCommand(line);
            }
            else {
                fsm.captureLineResult(line);
            }
        }
        goalSize = 0;
        return fsm.getGoalSum();
    }

    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        FileSystemManager fsm = new FileSystemManager();
        while ((line = br.readLine()) != null) {
            if (line.charAt(0) == '$') {
                fsm.setCommand(line);
            }
            else {
                fsm.captureLineResult(line);
            }
        }
        goalSize = 0;
        optimalFolder = spaceNeeded;
        totalSize = fsm.getGoalSum();
        return fsm.getGoalSum();
    }

    public static void updateOptimalFolder(int size) {
        if (totalSize == 0) {
            return;
        }
        if (totalSpace - totalSize + size >= spaceNeeded) {
            if (size < optimalFolder) {
                optimalFolder = size;
            }
        }
    }
}
