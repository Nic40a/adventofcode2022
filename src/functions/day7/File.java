package src.functions.day7;

public class File {
    private String name;
    private int size;
    Folder parent;

    public File(String name, int size, Folder parent) {
        this.name = name;
        this.size = size;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Folder getParent() {
        return parent;
    }
}
