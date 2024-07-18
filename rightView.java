class Solution {
    // Declare a list to store the right side view of the binary tree
    ArrayList<Integer> result;

    // Helper method for performing depth-first search (DFS)
    private void dfs(int level, TreeNode root) {
        // Base case: if the current node is null, return
        if (root == null) return;

        // If this is the first node of the current level, add it to the result list
        if (result.size() == level) result.add(root.val);

        // Recursively traverse the right subtree first
        dfs(level + 1, root.right);

        // Recursively traverse the left subtree
        dfs(level + 1, root.left);
    }

    // Method to return the right side view of the binary tree
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize the result list
        result = new ArrayList<>();

        // If the root is null, return the empty result list
        if (root == null) return result;

        // Start the DFS traversal from the root at level 0
        dfs(0, root);

        // Return the result list containing the right side view
        return result;
    }
}
