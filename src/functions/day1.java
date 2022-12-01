package src.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day1 {
    public static int part1(File file) throws IOException{

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

    public static int part2(File file) throws IOException {
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
