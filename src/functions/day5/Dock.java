package src.functions.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.UIManager.get;

public class Dock {
    private ArrayList<ArrayList<String>> stacks;

    public Dock(File inputStacks) throws IOException {
        ArrayList<ArrayList<String>> initialStacks = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(inputStacks));
        String line;
        int start;
        int increment = 4;
        int height = 0;
        int amountOfStack = 0;
        while ((line = br.readLine()) != null) {
            ArrayList<String> row = new ArrayList<>();
            start = 0;
            while (line.length() >= start) {
                if (line.length() >= start + increment) {
                    row.add(getContainerName(line.substring(start, start + increment)));
                }
                else {
                    row.add(getContainerName(line.substring(start)));
                }
                start += increment;
            }
            initialStacks.add(row);
            if (row.size() >= amountOfStack) {
                amountOfStack = row.size();
            }
        }
        stacks = formatStack(initialStacks, initialStacks.size(), amountOfStack);
    }

    public void processInstruction1(Instruction instruction){
        for (int i = 0; i < instruction.getQuantity(); i++){
            stacks.get(instruction.getTo()).add(RemoveLastContainer(stacks.get(instruction.getFrom())));
        }

    }
    public void processInstruction2(Instruction instruction){
        ArrayList<String> tempStack = RemoveContainers(stacks.get(instruction.getFrom()), instruction.getQuantity());
        for (String stack : tempStack) {
            stacks.get(instruction.getTo()).add(stack);
        }
    }

    private String getContainerName(String value){
        StringBuilder name = new StringBuilder();
        int i = 0;
        while (value.length() > i) {
            char c = value.charAt(i);
            if (c != ' ') {
                if (c != '[') {
                    if (c != ']'){
                        name.append(value.charAt(i));
                    }
                }
            }
            i++;
        }
        return name.toString();
    }

    private ArrayList<ArrayList<String>> formatStack(ArrayList<ArrayList<String>> list, int height, int amountOfStack) {
        ArrayList<ArrayList<String>> formattedList = new ArrayList<>();
        for (int j = 0; j < amountOfStack; j++) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = height - 2; i >= 0 ; i--) {
                int s = list.get(i).size();
                if (!(j >= s)) {
                    if (!list.get(i).get(j).isBlank()) {
                        row.add(list.get(i).get(j));
                    }
                }
            }
            formattedList.add(row);
        }
        return formattedList;
    }

    private String RemoveLastContainer(ArrayList<String> stack) {
        String container = "";
        int i = stack.size() - 1;
        while (i >= 0) {
            if (stack.get(i).isBlank()){
                stack.remove(i);
                i--;
            }
            else {
                container  = stack.get(i);
                stack.remove(i);
                return container;
            }
        }
        return container;
    }

    private ArrayList<String> RemoveContainers(ArrayList<String> stack, int quantity) {
        ArrayList<String> tempStack = new ArrayList<>();
        int i = stack.size() - quantity;
        while (i < stack.size()) {
            tempStack.add(stack.get(i));
            stack.remove(i);
        }
        return tempStack;
    }

    public String showLast() {
        String listOfLast = "";
        for (ArrayList<String> stack : stacks) {
            listOfLast += stack.get(stack.size() - 1);
        }
        return listOfLast;
    }

    public ArrayList<ArrayList<String>> getStacks() {
        return stacks;
    }
}
