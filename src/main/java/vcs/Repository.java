package vcs;

import java.util.*;

public class Repository {
    private final Map<String, Branch> branches = new HashMap<>();
    private Branch currentBranch;
    private final Map<String, String> staging = new HashMap<>();

    public Repository() {
        Commit root = new Commit(null, "root", new HashMap<>());
        Branch master = new Branch("master", root);
        branches.put("master", master);
        currentBranch = master;
    }

    // Getters & setters
    public Map<String, Branch> getBranches() { return branches; }

    public Branch getCurrentBranch() { return currentBranch; }
    public void setCurrentBranch(Branch branch) { this.currentBranch = branch; }

    public Map<String, String> getStaging() { return staging; }
}
