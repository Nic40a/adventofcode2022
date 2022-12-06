package src.functions.day5;

public class Instruction {
    private String instruction;
    private int quantity;
    private int from;
    private int to;

    public Instruction(String instruction) {
        this.instruction = instruction;
        int indexQuantity = 5;
        int indexFrom = 12;
        int indexTo = 17;
        String quantityValue = "";
        String fromValue = "";
        String toValue = "";

        quantityValue += instruction.charAt(indexQuantity);
        while (instruction.charAt(indexQuantity + 1) != ' ') {
            quantityValue += instruction.charAt(indexQuantity + 1);
            indexQuantity++;
            indexFrom++;
            indexTo++;
        }
        quantity = Integer.parseInt(quantityValue);

        fromValue += instruction.charAt(indexFrom);
        while (instruction.charAt(indexFrom + 1) != ' ') {
            fromValue += instruction.charAt(indexFrom + 1);
            indexFrom++;
            indexTo++;
        }

        from = Integer.parseInt(fromValue) - 1;

        toValue += instruction.charAt(indexTo);
        while (instruction.length() > indexTo + 1) {
            toValue += instruction.charAt(indexTo + 1);
            indexTo++;
        }
        to = Integer.parseInt(toValue) - 1;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
