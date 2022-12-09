package src.functions.day8;

import java.util.ArrayList;

public class Forest {
    private ArrayList<String> forest;
    private int visibleTreeCount;
    private int vertical;
    private int horizontal;
    private int verticalSize;
    private int horizontalSize;

    public Forest() {
        this.forest = new ArrayList<>();
    }

    public void addTreeLine(String treeline) {
        forest.add(treeline);
    }

    public int countTree(){
        visibleTreeCount = 0;
        verticalSize = forest.size();
        horizontalSize = forest.get(0).length();
        for (vertical = 0; vertical < forest.size(); vertical++) {
            String treeLine = forest.get(vertical);
            for (horizontal = 0; horizontal < treeLine.length(); horizontal++) {
                if (isEdge()) {
                    visibleTreeCount++;
                    //System.out.printf("Debug - Tree %d at [%d,%d] is visible because at the edge %n", Character.getNumericValue(forest.get(vertical).charAt(horizontal)), vertical, horizontal);
                    continue;
                }
                if (isTreeVisible()) {
                    visibleTreeCount++;
                }
            }
        }
        return visibleTreeCount;
    }

    private boolean isEdge() {
        if (vertical == 0) {
            return true;
        }
        else if (vertical == verticalSize - 1) {
            return true;
        }
        else if (horizontal == 0) {
            return true;
        }
        else if (horizontal == horizontalSize - 1) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isTreeVisible(){
        int i = vertical;
        int j = horizontal;
        int tree = Character.getNumericValue(forest.get(i).charAt(j));
        int compareTree;
        boolean visible = false;
        // Going up
        i--;
        while (i >= 0) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the top %n", tree, vertical, horizontal);
                visible = true;
                i--;
            }
            else {
                visible = false;
                break;
            }
        }
        if (visible) {
            return true;
        }
        // Going down
        i = vertical + 1;
        while (i < verticalSize) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the bottom %n", tree, vertical, horizontal);
                visible = true;
                i++;
            }
            else {
                visible = false;
                break;
            }
        }
        if (visible) {
            return true;
        }
        // Going left
        i = vertical;
        j--;
        while (j >= 0) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the left %n", tree, vertical, horizontal);
                visible = true;
                j--;
            }
            else {
                visible = false;
                break;
            }
        }
        if (visible) {
            return true;
        }
        // Going right
        i = vertical;
        j = horizontal + 1;
        while (j < horizontalSize) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the right %n", tree, vertical, horizontal);
                visible = true;
                j++;
            }
            else {
                visible = false;
                break;
            }
        }
        if (visible) {
            return true;
        }
        //System.out.printf("Debug - Tree %d at [%d,%d] is NOT visible at all %n", tree, vertical, horizontal);
        return false;
    }

    public int getScenicScore() {
        int score = 0;
        verticalSize = forest.size();
        horizontalSize = forest.get(0).length();
        for (vertical = 0; vertical < forest.size(); vertical++) {
            String treeLine = forest.get(vertical);
            for (horizontal = 0; horizontal < treeLine.length(); horizontal++) {
                if (isEdge()) {
                    //System.out.printf("Debug - Tree %d at [%d,%d] is visible because at the edge %n", Character.getNumericValue(forest.get(vertical).charAt(horizontal)), vertical, horizontal);
                    continue;
                }
                int tmpScore = calculateScenicScore();
                if (score < tmpScore) {
                    score = tmpScore;
                }
            }
        }
        return score;
    }

    private int calculateScenicScore(){
        int i = vertical;
        int j = horizontal;
        int tree = Character.getNumericValue(forest.get(i).charAt(j));
        int compareTree;
        int score = 1;

        // Going up
        i--;
        while (i >= 0) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the top %n", tree, vertical, horizontal);
                i--;
            }
            else {
                break;
            }
        }
        if (i >= 0) {
            score = score * (vertical - i);
        }
        else { // Edge
            score = score * (vertical - i - 1); // This one good
        }

        // Going down
        i = vertical + 1;
        while (i < verticalSize) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the bottom %n", tree, vertical, horizontal);
                i++;
            }
            else {
                break;
            }
        }
        if (i < verticalSize) {
            score = score * (i - vertical);
        }
        else { // Edge
            score = score * (i - vertical - 1) ;
        }

        // Going left
        i = vertical;
        j--;
        while (j >= 0) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the left %n", tree, vertical, horizontal);
                j--;
            }
            else {
                break;
            }
        }
        if (j >= 0) {
            score = score * (horizontal - j);
        }
        else { // Edge
            score = score * (horizontal - j - 1);
        }

        // Going right
        i = vertical;
        j = horizontal + 1;
        while (j < horizontalSize) {
            compareTree = Character.getNumericValue(forest.get(i).charAt(j));
            if (tree > compareTree) {
                //System.out.printf("Debug - Tree %d at [%d,%d] is visible from the right %n", tree, vertical, horizontal);
                j++;
            }
            else {
                break;
            }
        }
        if (j < horizontalSize) {
            score = score * (j - horizontal);
        }
        else { // Edge
            score = score * (j - horizontal - 1);
        }


        //System.out.printf("Debug - Tree %d at [%d,%d] is NOT visible at all %n", tree, vertical, horizontal);
        return score;
    }
}
