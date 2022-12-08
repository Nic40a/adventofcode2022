package src.functions.day7;

public class FileSystemManager {
    Folder fileSystem;
    Folder position;
    String command = "";

    public FileSystemManager() {
        fileSystem = new Folder("/", null);
        position = fileSystem;
    }

    public void setCommand(String line) {
        command = line.substring(2, 4);
        if (command.equals("cd")) {
            if (line.substring(5).equals("..")) {
                position = position.getParent();
            }
            else {
                position = position.getFolder(line.substring(5));
            }
        }
    }

    public void captureLineResult(String line) {
        int i = 0;
        String firstElement;
        String lastElement;
        while (i < line.length()) {
            while (line.charAt(i) != ' ') {
                i++;
            }
            firstElement = line.substring(0, i);
            lastElement = line.substring(i + 1);
            if (firstElement.equals("dir")) {
                this.position.addFolder(lastElement, position);
            }
            else {
                this.position.addFile(lastElement, Integer.parseInt(firstElement), position);
            }
            break;
        }
    }

    public int getGoalSum() {
        return fileSystem.getGoalSum();
    }
}
