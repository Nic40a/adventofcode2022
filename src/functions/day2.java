package src.functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class day2 {
    /***********************************************
     * Rock-Paper-Scissors
     * Rock     A & X   1 point
     * Paper    B & Y   2 points
     * Scissors C & Z   3 points
     * Win      6 points
     * Draw     3 points
     * Loss     0 points
     * What would your total score be if everything goes exactly according to your strategy guide?
    ***********************************************/
    public static void run() throws IOException {
        File file = new File("./resources/day2Test.txt");
        int score = part1(file);
        System.out.println("Day 2 - Part 1 - Test expectation - The total score is 15");
        System.out.printf("Day 2 - Part 1 - Test Result - The total score calculated is [%d]%n", score);

        file = new File("./resources/day2Real.txt");
        score = part1(file);
        System.out.printf("Day 2 - Part 1 - Real - The total score calculated is [%d]%n", score);
        
        file = new File("./resources/day2Test.txt");
        score = part2(file);
        System.out.println("Day 2 - Part 2 - Test expectation - The total score is 12");
        System.out.printf("Day 2 - Part 2 - Test - The total score calculated is [%d]%n", score);

        file = new File("./resources/day2Real.txt");
        score = part2(file);
        System.out.printf("Day 2 - Part 2 - Real - The total score calculated is [%d]%n", score);
    }

    private static int part1(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        char opponent;
        char me;
        int score = 0;
        while ((st = br.readLine()) != null) {
            opponent = st.charAt(0);
            me = st.charAt(2);
            score += getMatchResult1(opponent, me);
        }
        return score;
    }

    // Find the top three Elves carrying the most score. How many score are those Elves carrying in total?
    private static int part2(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        char opponent;
        char me;
        int score = 0;
        while ((st = br.readLine()) != null) {
            opponent = st.charAt(0);
            me = st.charAt(2);
            score += getMatchResult2(opponent, me);
        }
        return score;
    }

    private static int getMatchResult1(char opponent, char me) {
        /***********************************************
         * Rock-Paper-Scissors
         * Rock     A & X   1 point
         * Paper    B & Y   2 points
         * Scissors C & Z   3 points
         * Win      6 points
         * Draw     3 points
         * Loss     0 points
         */
        int win = 6;
        int draw = 3;
        int loss = 0;
        int ShapeScore;
        switch (opponent) {
            case 'A':
                switch (me) {
                    case 'X':
                        ShapeScore = 1;
                        return ShapeScore + draw;
                    case 'Y':
                        ShapeScore = 2;
                        return ShapeScore + win;
                    case 'Z':
                        ShapeScore = 3;
                        return ShapeScore + loss;
                }
            case 'B':
                switch (me) {
                    case 'X':
                        ShapeScore = 1;
                        return ShapeScore + loss;
                    case 'Y':
                        ShapeScore = 2;
                        return ShapeScore + draw;
                    case 'Z':
                        ShapeScore = 3;
                        return ShapeScore + win;
                }
            case 'C':
                switch (me) {
                    case 'X':
                        ShapeScore = 1;
                        return ShapeScore + win;
                    case 'Y':
                        ShapeScore = 2;
                        return ShapeScore + loss;
                    case 'Z':
                        ShapeScore = 3;
                        return ShapeScore + draw;
                }
            default:
                return 0;
        }
    }

    private static int getMatchResult2(char opponent, char me) {
        /***********************************************
         * Rock-Paper-Scissors
         * Rock     A    1 point
         * Paper    B    2 points
         * Scissors C    3 points
         * X is Win      6 points
         * Y is Draw     3 points
         * Z is Loss     0 points
         */
        int win = 6;
        int draw = 3;
        int loss = 0;
        int ShapeScore;
        switch (opponent) {
            case 'A':
                switch (me) {
                    case 'X':
                        ShapeScore = 3;
                        return ShapeScore + loss;
                    case 'Y':
                        ShapeScore = 1;
                        return ShapeScore + draw;
                    case 'Z':
                        ShapeScore = 2;
                        return ShapeScore + win;
                }
            case 'B':
                switch (me) {
                    case 'X':
                        ShapeScore = 1;
                        return ShapeScore + loss;
                    case 'Y':
                        ShapeScore = 2;
                        return ShapeScore + draw;
                    case 'Z':
                        ShapeScore = 3;
                        return ShapeScore + win;
                }
            case 'C':
                switch (me) {
                    case 'X':
                        ShapeScore = 2;
                        return ShapeScore + loss;
                    case 'Y':
                        ShapeScore = 3;
                        return ShapeScore + draw;
                    case 'Z':
                        ShapeScore = 1;
                        return ShapeScore + win;
                }
            default:
                return 0;
        }
    }
}
