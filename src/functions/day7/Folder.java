package src.functions.day7;

import java.util.ArrayList;

public class Folder {
    String name;
    ArrayList<Folder> subFolders;
    ArrayList<File> files;
    Folder parent;
    int fileSize;
    int goalSize;

    public Folder(String name, Folder parent) {
        this.name = name;
        subFolders = new ArrayList<>();
        files = new ArrayList<>();
        this.parent = parent;
        fileSize = 0;
        goalSize = 0;
    }

    public void addFolder(String name, Folder parent) {
        subFolders.add(new Folder(name, parent));
    }

    public void addFile(String name, int size, Folder parent) {
        files.add(new File(name, size, parent));
        fileSize += size;
    }

    public Folder getFolder(String name) {
        for (Folder folder : subFolders) {
            if (folder.getName().equals(name)) {
                return folder;
            }
        }
        return null;
    }

    public File getFile(String name) {
        for (File file : files) {
            if (file.getName().equals(name)) {
                return file;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Folder getParent() {
        return parent;
    }

    public int getFileSize() {
        return fileSize;
    }

    public int getGoalSum() {
        int size = 0;
        for (Folder folder : subFolders) {
            int tempSize = folder.getGoalSum();
            size += tempSize;
        }
        goalSize = size + fileSize;
        if (goalSize <= 100000){
            day7.goalSize += goalSize;
        }
        day7.updateOptimalFolder(goalSize);
        return goalSize;
    }
}
