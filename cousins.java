class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // Initialize a queue for level order traversal
        Queue<TreeNode> parent = new LinkedList<>();
        
        // Flags to indicate if x and y are found
        boolean x_found = false;
        boolean y_found = false;
        
        // Add the root node to the queue
        parent.add(root);
        
        // Loop while the queue is not empty
        while (!parent.isEmpty()) {
            // Get the number of nodes at the current level
            int size = parent.size();
            
            // Iterate over all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Remove the front node of the queue
                TreeNode currentParent = parent.poll();
                
                // Check if currentParent has both left and right children
                if (currentParent.left != null && currentParent.right != null) {
                    // Check if the children are x and y (in either order)
                    if ((currentParent.left.val == x && currentParent.right.val == y)
                            || (currentParent.right.val == x && currentParent.left.val == y)) {
                        // If x and y are siblings, return false
                        return false;
                    }
                }
                
                // Check if the current node is x
                if (currentParent.val == x) x_found = true;
                
                // Check if the current node is y
                if (currentParent.val == y) y_found = true;
                
                // Add the left child to the queue if it exists
                if (currentParent.left != null) parent.add(currentParent.left);
                
                // Add the right child to the queue if it exists
                if (currentParent.right != null) parent.add(currentParent.right);
            }
            
            // If both x and y are found at the same level, return true
            if (x_found && y_found) return true;
            
            // If only one of x or y is found at the current level, return false
            if (x_found || y_found) return false;
        }
        
        // If neither x nor y are found, return false
        return false;
    }
}
