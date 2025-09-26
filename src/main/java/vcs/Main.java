package vcs;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        RepositoryService vcs = new RepositoryService(repo);

        // Add + commit files on master
        vcs.add("file1.txt", "Hello World");
        vcs.commit("Initial commit");

        vcs.showRepo();

        vcs.add("file2.txt", "Another file");
        vcs.commit("Added file2");

        vcs.showRepo();

        // Create and switch to a new branch
        vcs.createBranch("feature");
        vcs.checkout("feature");

        vcs.showRepo();;

        vcs.add("file1.txt", "Hello World from feature branch");
        vcs.commit("Updated file1 on feature");

        vcs.showRepo();

        vcs.checkout("master");

        vcs.showRepo();

        vcs.add("file3.txt", "Hello from Rishav!");
        vcs.commit("Committing Rishav's file");

        vcs.checkout("feature");

        vcs.showRepo();

        // Show logs
        System.out.println("\n=== Log on feature branch ===");
        vcs.log();

        // Switch back to master
        vcs.checkout("master");
        System.out.println("\n=== Log on master branch ===");
        vcs.log();

        // Rollback example
        String rollbackId = repo.getCurrentBranch().getHead().getParent().getId(); // via getter
        vcs.rollback(rollbackId);

        System.out.println("\n=== After rollback on master ===");
        vcs.log();


        vcs.showRepo();
    }
}

