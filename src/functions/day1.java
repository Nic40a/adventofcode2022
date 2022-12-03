package src.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {
    public static void run() throws IOException {
        File file = new File("./resources/day1Test.txt");
        int calories = part1(file);
        System.out.println("Day 1 - Part 1 - Test expectation - The elf with the most calories  carries: 24000");
        System.out.printf("Day 1 - Part 1 - Test Result - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Real.txt");
        calories = part1(file);
        System.out.printf("Day 1 - Part 1 - Real - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Test.txt");
        calories = part2(file);
        System.out.println("Day 1 - Part 2 - Test expectation - The elf with the most calories  carries: 45000");
        System.out.printf("Day 1 - Part 2 - Test - The elf with the most calories carries: [%d]%n", calories);

        file = new File("./resources/day1Real.txt");
        calories = part2(file);
        System.out.printf("Day 1 - Part 2 - Real - The elf with the most calories carries: [%d]%n", calories);
    }

    // Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int finalSum = 0;
        int localSum = 0;
        int n;
        while ((st = br.readLine()) != null) {
            if (st.length() > 0) {
                n = Integer.parseInt(st);
                localSum += n;
            } else {
                if (localSum > finalSum) {
                    finalSum = localSum;
                }
                localSum = 0;
            }
        }
        if (localSum > finalSum) {
            finalSum = localSum;
        }
        return finalSum;
    }

    // Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<Integer> listSum= new ArrayList<>();
        int localSum = 0;
        int n;
        while ((st = br.readLine()) != null) {
            if (st.length() > 0) {
                n = Integer.parseInt(st);
                localSum += n;
            }
            else {
                listSum.add(localSum);
                localSum = 0;
            }
        }
        if(localSum != 0) {
            listSum.add(localSum);
        }
        Collections.sort(listSum);
        return listSum.get(listSum.size() - 1) + listSum.get(listSum.size() - 2) + listSum.get(listSum.size() - 3);
    }
}
