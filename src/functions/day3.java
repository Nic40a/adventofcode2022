package src.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class day3 {





    public static void run() throws IOException {
        File file = new File("./resources/day3Test.txt");
        int sum = part1(file);
        System.out.println("Day 3 - Part 1 - Test expectation - The test sum of the priorities is 157");
        System.out.printf("Day 3 - Part 1 - Test Result - The test sum of the priorities is [%d]%n", sum);

        file = new File("./resources/day3Real.txt");
        sum = part1(file);
        System.out.printf("Day 3 - Part 1 - Real - The sum of the priorities is [%d]%n", sum);

        file = new File("./resources/day3Test.txt");
        sum = part2(file);
        System.out.println("Day 3 - Part 2 - Test expectation - The test sum of the priorities is 70");
        System.out.printf("Day 3 - Part 2 - Test - The test sum of the priorities is [%d]%n", sum);

        file = new File("./resources/day3Real.txt");
        sum = part2(file);
        System.out.printf("Day 3 - Part 3 - Real - The sum of the priorities is [%d]%n", sum);

    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int sum = 0;
        String firstHalf;
        String secondHalf;
        String duplicateList = "";
        while ((st = br.readLine()) != null) {
            firstHalf = st.substring(0, st.length()/2);
            secondHalf = st.substring(st.length()/2);
            duplicateList = "";
            for (int i = 0; i < firstHalf.length(); i++) {
                for (int j = 0; j < secondHalf.length(); j++) {
                    if (firstHalf.charAt(i) == secondHalf.charAt(j)) {
                        if (duplicateList.length() == 0){
                            duplicateList += firstHalf.charAt(i);
                            sum += getCharValue(firstHalf.charAt(i));
                        } else if (firstHalf.charAt(i) != duplicateList.charAt(duplicateList.length() - 1)){
                            duplicateList += firstHalf.charAt(i);
                            sum += getCharValue(firstHalf.charAt(i));
                        }
                    }
                }
            }

        }
        return sum;
    }

    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String elf1;
        String elf2;
        String elf3;
        int sum = 0;
        String duplicateList = "";
        while ((elf1 = br.readLine()) != null &&
                (elf2 = br.readLine()) != null &&
                (elf3 = br.readLine()) != null) {
            duplicateList = "";
            for (int i = 0; i < elf1.length(); i++) {
                for (int j = 0; j < elf2.length(); j++) {
                    if (elf1.charAt(i) == elf2.charAt(j)) {
                        if (duplicateList.length() == 0){
                            duplicateList += elf1.charAt(i);
                        } else if (elf1.charAt(i) != duplicateList.charAt(duplicateList.length() - 1)){
                            duplicateList += elf1.charAt(i);
                        }
                    }
                }
            }
            int i = 0;
            boolean found = false;
            while (i < elf3.length() && !found) {
                int j = 0;
                while (j < duplicateList.length() && !found) {
                    if (elf3.charAt(i) == duplicateList.charAt(j)) {
                        sum += getCharValue(elf3.charAt(i));
                        found = true;
                    }
                    j++;
                }
                i++;
            }
        }
        return sum;
    }

    private static int getCharValue(char character) {
        int value;
        if ((value = (int) character) >= 97){
                return value - 96;
        }
        else {
            return value - 64 + 26;
        }
    }
}

