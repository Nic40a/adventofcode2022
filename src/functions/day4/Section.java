package src.functions.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Section {

    private int start;
    private int end;

    public Section(String inputSection) {
        int i = 0;
        while (inputSection.charAt(i) != '-') {
            i++;
        }
        start = Integer.parseInt(inputSection.substring(0, i));
        end = Integer.parseInt(inputSection.substring(i+1));
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
