package src.functions.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment {

    private Section section1;
    private Section section2;

    public Assignment(String inputLine) {
        int i = 0;
        while (inputLine.charAt(i) != ',') {
            i++;
        }
        String sec1 = inputLine.substring(0, i);
        String sec2 = inputLine.substring(i+1);
        section1 = new Section(sec1);
        section2 = new Section(sec2);
    }

    public int isIncludedSection(){
        if ((section1.getStart() <= section2.getStart()) &&
                (section1.getEnd() >= section2.getEnd())) {
            return 1;
        }
        else if ((section2.getStart() <= section1.getStart()) &&
                (section2.getEnd() >= section1.getEnd())) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int isOverlappingSection(){
        if ((section1.getStart() <= section2.getEnd()) &&
                (section1.getStart() >= section2.getStart())) {
            return 1;
        }
        else if ((section2.getStart() <= section1.getEnd()) &&
                (section2.getStart() >= section1.getStart())) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public Section getSection1() {
        return section1;
    }

    public Section getSection2() {
        return section2;
    }
}
