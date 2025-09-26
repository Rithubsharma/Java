package vcs;

public class Branch {
    private final String name;
    private Commit head;

    public Branch(String name, Commit head) {
        this.name = name;
        this.head = head;
    }

    // Getters & setters
    public String getName() { return name; }
    public Commit getHead() { return head; }
    public void setHead(Commit head) { this.head = head; }
}
