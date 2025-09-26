package vcs;
import java.util.*;

public class Commit {
    private final String id;
    private final Commit parent;
    private final String message;
    private final Map<String, String> snapshot;

    public Commit(Commit parent, String message, Map<String, String> files) {
        this.parent = parent;
        this.message = message;
        this.snapshot = new HashMap<>(files);
        this.id = UUID.randomUUID().toString().substring(0, 7); // short id
    }

    // Getters (Commit is immutable)
    public String getId() { return id; }
    public Commit getParent() { return parent; }
    public String getMessage() { return message; }
    public Map<String, String> getSnapshot() { return new HashMap<>(snapshot); }
}
