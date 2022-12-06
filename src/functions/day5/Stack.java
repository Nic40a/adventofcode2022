package src.functions.day5;

import java.util.ArrayList;

public class Stack {
    private ArrayList<String> stack;

    public Stack() {
    }

    public void addOnTop(String container) {
        stack.add(container);
    }

    public ArrayList<String> getStack() {
        return stack;
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = stack;
    }
}
