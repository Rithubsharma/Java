package vcs;


import java.util.*;

public class RepositoryService {
    private final Repository repo;

    public RepositoryService(Repository repo) {
        this.repo = repo;
    }

    public void add(String file, String content) {
        repo.getStaging().put(file, content);
        System.out.println("Staged: " + file);
    }

    public void commit(String message) {
        if (repo.getStaging().isEmpty()) {
            System.out.println("Nothing to commit.");
            return;
        }

        Map<String, String> newSnapshot = new HashMap<>(repo.getCurrentBranch().getHead().getSnapshot());
        newSnapshot.putAll(repo.getStaging());

        Commit newCommit = new Commit(repo.getCurrentBranch().getHead(), message, newSnapshot);
        repo.getCurrentBranch().setHead(newCommit);
        repo.getStaging().clear();

        System.out.println("Committed: " + newCommit.getId() + " - " + message);
    }

    public void createBranch(String name) {
        Commit head = repo.getCurrentBranch().getHead();
        repo.getBranches().put(name, new Branch(name, head));
        System.out.println("Branch created: " + name);
    }

    public void checkout(String name) {
        Branch branch = repo.getBranches().get(name);
        if (branch == null) {
            System.out.println("Branch not found: " + name);
            return;
        }
        repo.setCurrentBranch(branch);
        System.out.println("Switched to branch: " + name);
    }

    public void log() {
        Commit c = repo.getCurrentBranch().getHead();
        while (c != null) {
            System.out.println(c.getId() + " - " + c.getMessage());
            c = c.getParent();
        }
    }

    public void rollback(String commitId) {
        Commit c = repo.getCurrentBranch().getHead();
        while (c != null && !c.getId().equals(commitId)) {
            c = c.getParent();
        }

        if (c == null) {
            System.out.println("Commit not found in branch history");
        } else {
            repo.getCurrentBranch().setHead(c);
            System.out.println("Rolled back to " + commitId);
        }
    }

    public void showRepo() {
        System.out.println("=== Repository Status for branch: " + repo.getCurrentBranch().getName() + " ===");

        // Get the snapshot of the current head commit
        Map<String, String> snapshot = repo.getCurrentBranch().getHead().getSnapshot();
        if (snapshot.isEmpty()) {
            System.out.println("[No files in repo]");
        } else {
            snapshot.forEach((file, content) -> {
                System.out.println(file + " : " + content);
            });
        }

        // Also show staged files that are not yet committed
        Map<String, String> staged = repo.getStaging();
        if (!staged.isEmpty()) {
            System.out.println("\n--- Staged Files ---");
            staged.forEach((file, content) -> {
                System.out.println(file + " : " + content);
            });
        }
    }
}
